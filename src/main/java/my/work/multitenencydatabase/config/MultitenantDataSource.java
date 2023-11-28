package my.work.multitenencydatabase.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import my.work.multitenencydatabase.demo.dto.DataSourceDto;

public class MultitenantDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContextHolder.getTenantId();
    }

    public void init() {
        List<DataSourceDto> dataSources = new ArrayList<>();
        File[] files = Paths.get("allTenants").toFile().listFiles();
        for (File propertyFile : files) {
            Properties tenantProperties = new Properties();
            try {
                tenantProperties.load(new FileInputStream(propertyFile));
                String tenantId = tenantProperties.getProperty("name");
                DataSourceDto data = DataSourceDto.builder()
                        .tenantId(tenantId)
                        .driverClassName(tenantProperties.getProperty("datasource.driver-class-name"))
                        .username(tenantProperties.getProperty("datasource.username"))
                        .password(tenantProperties.getProperty("datasource.password"))
                        .url(tenantProperties.getProperty("datasource.url"))
                        .isDefault(tenantProperties.getProperty("datasource.isDefault"))
                        .build();
                dataSources.add(data);
            } catch (IOException exp) {
                throw new RuntimeException("Problem in tenant datasource:" + exp);
            }
        }
        setDefaultDataSource(dataSources);
        setDataSources(dataSources);
    }

    private void setDefaultDataSource(List<DataSourceDto> dataSources) {
        DataSourceDto defaultDataSource = dataSources.stream()
                .filter(DataSourceDto::isDefault)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("기본 데이터베이스가 존재하지 않습니다."));

        setDefaultTargetDataSource(defaultDataSource.buildDataSource());
    }

    private void setDataSources(List<DataSourceDto> dataSources) {
        Map<Object, Object> dataSourceMap = dataSources.stream()
                .collect(Collectors.toMap(DataSourceDto::getTenantId, DataSourceDto::buildDataSource));

        setTargetDataSources(dataSourceMap);
    }

    public void refresh() {
        init();
        afterPropertiesSet();
    }
}
