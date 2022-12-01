package jx.pgz.controller;

import jx.pgz.dao.entity.TbOrder;
import jx.pgz.service.TbOrderAllService;
import jx.pgz.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @since 2022/11/30
 */
@Controller
@RestController
public class WorkOrderController {

    @Resource
    TbOrderAllService tbOrderAllService;

    @PostMapping("saveOrUpdate")
    public Result<Boolean> saveOrUpdate(@RequestBody TbOrder tbOrder) {
        Boolean b = tbOrderAllService.saveOrUpdate(tbOrder);
        return Result.success(b, "新增成功！");
    }


    @GetMapping("delete")
    public Result<Boolean> delWorkerOrder(String id) {
        Boolean b = tbOrderAllService.delWorkerOrder(id);
        return Result.success(b, "删除成功！");
    }

    @GetMapping("list")
    public Result<List<TbOrder>> listWorkerOrder() {
        List<TbOrder> tbOrders = tbOrderAllService.listWorkerOrder();
        return Result.success(tbOrders, "获取成功！");
    }

    @GetMapping("tb")
    public Result<List<List<Object>>> tb() {
        List<List<Object>> tbOrders = tbOrderAllService.tb();
        return Result.success(tbOrders, "获取成功！");
    }


}
