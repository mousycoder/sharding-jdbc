package com.mousycoder.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
 *   `product_order_id` bigint DEFAULT NULL COMMENT '订单号',
 *   `product_id` bigint DEFAULT NULL COMMENT '产品id',
 *   `product_name` varchar(128) DEFAULT NULL COMMENT '商品名称',
 *   `buy_num` int DEFAULT NULL COMMENT '购买数量',
 *   `user_id` bigint DEFAULT NULL,
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/30 4:56 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("product_order_item")
public class ProductOrderItemDO {

    private Long id;

    private Long productOrderId;

    private Long productId;

    private String productName;

    private Integer buyNum;

    private Long userId;




}
