package com.mousycoder.strategy;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/31 12:19 PM
 */
public class CustomTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> dataSourceNames, PreciseShardingValue<Long> preciseShardingValue) {
        for (String datasourceName : dataSourceNames){
            String value = preciseShardingValue.getValue() % dataSourceNames.size() + "";
            if (datasourceName.endsWith(value)){
                return datasourceName;
            }
        }
        return null;
    }
}
