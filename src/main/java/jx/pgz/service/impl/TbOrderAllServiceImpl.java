package jx.pgz.service.impl;

import jx.pgz.dao.entity.TbOrder;
import jx.pgz.dao.service.TbOrderService;
import jx.pgz.service.TbOrderAllService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author admin
 * @since 2022/11/30
 */
@Service
public class TbOrderAllServiceImpl implements TbOrderAllService {
    @Resource
    TbOrderService tbOrderService;

    @Override
    public Boolean saveOrUpdate(TbOrder tbOrder) {
        return tbOrderService.saveOrUpdate(tbOrder);
    }


    @Override
    public Boolean delWorkerOrder(String id) {
        return tbOrderService.removeById(id);
    }

    @Override
    public List<TbOrder> listWorkerOrder() {
        List<TbOrder> list = tbOrderService.list();
        list.sort(Comparator.comparing(TbOrder::getPlaceData).reversed());
        return list;
    }

    @Override
    public List<List<Object>> tb() {
        List<List<Object>> data = new ArrayList<>();


        List<TbOrder> list = tbOrderService.list();

        Map<DayOfWeek, List<TbOrder>> dayWeek = list.stream().collect(Collectors.groupingBy(s -> s.getPlaceData().getDayOfWeek()));
        dayWeek.forEach((k,v)->{
            List<Object> weekData=new ArrayList<>();
            if (k.getValue()==1){
                weekData.add("星期一");
            }
            if (k.getValue()==2){
                weekData.add("星期二");
            }
            if (k.getValue()==3){
                weekData.add("星期三");
            }
            if (k.getValue()==4){
                weekData.add("星期四");
            }
            if (k.getValue()==5){
                weekData.add("星期五");
            }
            if (k.getValue()==6){
                weekData.add("星期六");
            }
            if (k.getValue()==7){
                weekData.add("星期日");
            }
            weekData.add(v.stream().collect(Collectors.summarizingLong(TbOrder::getWOrderNumber)).getSum());
            weekData.add(v.stream().collect(Collectors.summarizingLong(TbOrder::getEndNumber)).getSum());
            data.add(weekData);
        });
        data.add(0,new ArrayList<>() {{
            add("product");
            add("派单数");
            add("完成数");
        }});

        return data;
    }

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().getDayOfWeek().getValue());
    }
}
