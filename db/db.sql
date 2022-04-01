create table mousycoder_shop_order_0.ad_config
(
    id           bigint unsigned not null comment '主键id'
        primary key,
    config_key   varchar(1024)   null comment '配置key',
    config_value varchar(1024)   null comment '配置value',
    type         varchar(128)    null comment '类型'
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_1.ad_config
(
    id           bigint unsigned not null comment '主键id'
        primary key,
    config_key   varchar(1024)   null comment '配置key',
    config_value varchar(1024)   null comment '配置value',
    type         varchar(128)    null comment '类型'
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_0.product_order_0
(
    id           bigint auto_increment
        primary key,
    out_trade_no varchar(64)    null comment '订单唯一标识',
    state        varchar(11)    null comment 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单',
    create_time  datetime       null comment '订单生成时间',
    pay_amount   decimal(16, 2) null comment '订单实际支付价格',
    nickname     varchar(64)    null comment '昵称',
    user_id      bigint         null comment '用户id'
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_1.product_order_0
(
    id           bigint auto_increment
        primary key,
    out_trade_no varchar(64)    null comment '订单唯一标识',
    state        varchar(11)    null comment 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单',
    create_time  datetime       null comment '订单生成时间',
    pay_amount   decimal(16, 2) null comment '订单实际支付价格',
    nickname     varchar(64)    null comment '昵称',
    user_id      bigint         null comment '用户id'
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_0.product_order_1
(
    id           bigint auto_increment
        primary key,
    out_trade_no varchar(64)    null comment '订单唯一标识',
    state        varchar(11)    null comment 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单',
    create_time  datetime       null comment '订单生成时间',
    pay_amount   decimal(16, 2) null comment '订单实际支付价格',
    nickname     varchar(64)    null comment '昵称',
    user_id      bigint         null comment '用户id'
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_1.product_order_1
(
    id           bigint auto_increment
        primary key,
    out_trade_no varchar(64)    null comment '订单唯一标识',
    state        varchar(11)    null comment 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单',
    create_time  datetime       null comment '订单生成时间',
    pay_amount   decimal(16, 2) null comment '订单实际支付价格',
    nickname     varchar(64)    null comment '昵称',
    user_id      bigint         null comment '用户id'
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_1.product_order_item_0
(
    id               bigint unsigned auto_increment
        primary key,
    product_order_id bigint       null comment '订单号',
    product_id       bigint       null comment '产品id',
    product_name     varchar(128) null comment '商品名称',
    buy_num          int          null comment '购买数量',
    user_id          bigint       null
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_0.product_order_item_0
(
    id               bigint unsigned auto_increment
        primary key,
    product_order_id bigint       null comment '订单号',
    product_id       bigint       null comment '产品id',
    product_name     varchar(128) null comment '商品名称',
    buy_num          int          null comment '购买数量',
    user_id          bigint       null
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_1.product_order_item_1
(
    id               bigint unsigned auto_increment
        primary key,
    product_order_id bigint       null comment '订单号',
    product_id       bigint       null comment '产品id',
    product_name     varchar(128) null comment '商品名称',
    buy_num          int          null comment '购买数量',
    user_id          bigint       null
)
    collate = utf8mb4_bin;

create table mousycoder_shop_order_0.product_order_item_1
(
    id               bigint unsigned auto_increment
        primary key,
    product_order_id bigint       null comment '订单号',
    product_id       bigint       null comment '产品id',
    product_name     varchar(128) null comment '商品名称',
    buy_num          int          null comment '购买数量',
    user_id          bigint       null
)
    collate = utf8mb4_bin;

