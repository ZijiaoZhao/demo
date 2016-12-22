package com.inspiry.rw;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by zijiao on 12/21/16.
 */
public class RoutingDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceAspect.currentDataSource();
    }
}
