package jx.pgz.service;

import jx.pgz.dao.entity.TbOrder;

import java.util.List;

/**
 * @author admin
 * @since 2022/11/30
 */
public interface TbOrderAllService {

    Boolean saveOrUpdate(TbOrder tbOrder);

    Boolean delWorkerOrder(String id);

    List<TbOrder> listWorkerOrder();

    List<List<Object>> tb();

}
