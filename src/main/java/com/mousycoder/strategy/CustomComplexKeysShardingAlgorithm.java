package com.mousycoder.strategy;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/31 9:37 PM
 */
public class CustomComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    /**
     * @param dataSourceNames 数据源集合
     *                        在分库时值为所有分片库的集合 databaseNames：比如表：product_order_0/product_order_1、库ds0/ds1 等
     *                        分表时为对应分片库中所有分片表的集合 tablesNames
     * @param shardingValue   分片属性，包括
     *                        logicTableName 为逻辑表，
     *                        columnNameAndShardingValuesMap 存储多个分片健，包括key-value
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> dataSourceNames, ComplexKeysShardingValue<Long> shardingValue) {
        Collection<Long> orderIdValues = this.getShardingValue(shardingValue, "id");
        Collection<Long> userIdValues = this.getShardingValue(shardingValue, "user_id");

        List<String> shardingSuffix = new ArrayList<>();

        for (Long userId : userIdValues) {
            for (Long orderId : orderIdValues) {
                String suffix = userId % 2 + "_" + orderId % 2;
                for (String datasourceName : dataSourceNames) {
                    if (datasourceName.endsWith(suffix)) {
                        shardingSuffix.add(datasourceName);
                    }
                }
            }
        }

        return shardingSuffix;
    }

    private Collection<Long> getShardingValue(ComplexKeysShardingValue<Long> shardingValues, final String key) {
        Collection<Long> valueSet = new ArrayList<>();
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = shardingValues.getColumnNameAndShardingValuesMap();
        if (columnNameAndShardingValuesMap.containsKey(key)) {
            valueSet.addAll(columnNameAndShardingValuesMap.get(key));
        }
        return valueSet;
    }


}
