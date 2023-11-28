package my.work.multitenencydatabase.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TenantDatabaseConfig {

    @Bean
    public MultitenantDataSource dynamicRoutingDataSource() {
        MultitenantDataSource routingDataSource = new MultitenantDataSource();
        routingDataSource.init();

        return routingDataSource;
    }

    @Bean
    public LazyConnectionDataSourceProxy lazyDataSource(MultitenantDataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(LazyConnectionDataSourceProxy lazyDataSource) {
        return new DataSourceTransactionManager(lazyDataSource);
    }

    @Bean(name = "tenantSqlSessionFactory")
    public SqlSessionFactory tenantSqlSessionFactoryBean(LazyConnectionDataSourceProxy lazyDataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(lazyDataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/my/work/multitenencydatabase/demo/**/sql/*.xml"));

        return factoryBean.getObject();
    }

    @Bean(name = "tenantSqlSession")
    public SqlSession tenantSqlSession(@Qualifier("tenantSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
