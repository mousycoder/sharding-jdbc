package com.mousycoder;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mousycoder.mapper.AdConfigMapper;
import com.mousycoder.mapper.ProductOrderMapper;
import com.mousycoder.model.AdConfigDO;
import com.mousycoder.model.ProductOrderDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DbTest {

    @Autowired
    private ProductOrderMapper productOrderMapper;

    @Autowired
    private AdConfigMapper adConfigMapper;

    @Test
    public void testSaveProductOrder() {
        Random random = new Random();

        for (int i = 0; i < 1; i++) {
            ProductOrderDO productOrderDO = new ProductOrderDO();
            productOrderDO.setCreateTime(new Date());
            productOrderDO.setNickname("PreciseShardingAlgorithm i=" + i);
            productOrderDO.setOutTradeNo(UUID.randomUUID().toString().substring(0, 32));
            productOrderDO.setPayAmount(100.00);
            productOrderDO.setState("PAY");
            productOrderDO.setUserId(Long.valueOf(random.nextInt(50)));
            productOrderMapper.insert(productOrderDO);
        }
    }


    @Test
    public void testSaveAdConfig() {
        AdConfigDO adConfigDO = new AdConfigDO();
        adConfigDO.setConfigKey("banner");
        adConfigDO.setConfigValue("mousycoder.com");
        adConfigDO.setType("ad");
        adConfigMapper.insert(adConfigDO);
    }

    @Test
    public void testBinding() {
        List<Object> list = productOrderMapper.listProductOrderDetail();
        System.out.println(list);
    }

    @Test
    public void testPartitionKeySelect() {
        List<ProductOrderDO> id = productOrderMapper.selectList(new QueryWrapper<ProductOrderDO>().between("id", 1509081573520056321L, 1509081573520056321L));


        System.out.println(id.size());
    }

    @Test
    public void testNoPartitionKeySelect() {
        List<ProductOrderDO> id = productOrderMapper.selectList(new QueryWrapper<ProductOrderDO>().eq("out_trade_no", "cf0850ba-00b6-4a32-a31f-c7f31fa6"));
        System.out.println(id.size());
    }


    @Test
    public void testPartitionKeyDel() {
//        productOrderMapper.delete(new QueryWrapper<ProductOrderDO>().eq("id", 1509081573520056321L));

        productOrderMapper.delete(new QueryWrapper<ProductOrderDO>().in("id", Arrays.asList(1509081573557805058L,1509081573541027841L)));
    }

    @Test
    public void testNoPartitionKeyDel() {
//        productOrderMapper.delete(new QueryWrapper<ProductOrderDO>().eq("out_trade_no", "a01a0409-28b9-484e-bfa7-3ef13a90"));
        productOrderMapper.delete(new QueryWrapper<ProductOrderDO>().in("out_trade_no", Arrays.asList("a8ffc8ef-901a-4604-8450-27d9f358","ac356e08-91d9-434e-a625-208b87ab")));
    }


    @Test
    public void testBetween() {
//        productOrderMapper.delete(new QueryWrapper<ProductOrderDO>().eq("out_trade_no", "a01a0409-28b9-484e-bfa7-3ef13a90"));
        productOrderMapper.selectList(new QueryWrapper<ProductOrderDO>().between("id", 1509515869753991170L,1509517252305637377L));
    }

    @Test
    public void testMultiPartitionKeySelect() {
//        productOrderMapper.delete(new QueryWrapper<ProductOrderDO>().eq("out_trade_no", "a01a0409-28b9-484e-bfa7-3ef13a90"));
        productOrderMapper.selectList(new QueryWrapper<ProductOrderDO>().eq("id", 1L).eq("user_id",100L));
    }

    @Test
    public void testHit() {
        HintManager.clear();
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("product_order",3L);
        hintManager.addTableShardingValue("product_order",8L);
        List<ProductOrderDO> productOrderDOS = productOrderMapper.selectList(new QueryWrapper<ProductOrderDO>().eq("id", 66L));


    }


}