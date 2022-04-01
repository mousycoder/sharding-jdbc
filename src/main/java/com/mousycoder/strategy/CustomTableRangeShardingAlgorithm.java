package com.mousycoder.strategy;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/31 9:09 PM
 */
public class CustomTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> datasourceNames, RangeShardingValue<Long> shardingValue) {
        Set<String> result = new LinkedHashSet<>();
        Long lower = shardingValue.getValueRange().lowerEndpoint();
        Long upper = shardingValue.getValueRange().upperEndpoint();


        for (long i=lower;i<= upper;i++){
            for (String datasource: datasourceNames){
                String value = i % datasourceNames.size() + "";
                if (datasource.endsWith(value)){
                    result.add(datasource);
                }
            }
        }
        return result;
    }
}
