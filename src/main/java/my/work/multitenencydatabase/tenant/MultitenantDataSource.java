package my.work.multitenencydatabase.tenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

public class MultitenantDataSource extends AbstractRoutingDataSource {

    @Override
    @Nullable
    protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant();
    }
}
