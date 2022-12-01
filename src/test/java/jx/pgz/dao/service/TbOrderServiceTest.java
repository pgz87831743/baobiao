package jx.pgz.dao.service;

import jx.pgz.WorkOrderStarter;
import jx.pgz.dao.entity.TbOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WorkOrderStarter.class)
public class TbOrderServiceTest {

    @Resource
    TbOrderService tbOrderService;

    @Test
    void test1() {
        List<TbOrder> list = tbOrderService.list();
        for (TbOrder tbOrder : list) {
            System.out.println(tbOrder);
        }
    }
}