package jx.pgz.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author test
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单号
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 工单状态
     */
    private String orderStatus;

    /**
     * 工单类型
     */
    private String orderType;

    /**
     * 订单单号
     */
    private String orderOdd;

    /**
     * 部门
     */
    private String dept;

    /**
     * 性质
     */
    private String nature;

    /**
     * 物料编码
     */
    private String materialCode;

    /**
     * 物料名称
     */
    private String materialName;

    /**
     * 订单数量
     */
    private Long orderNumber;

    /**
     * 工单数量
     */
    private Long wOrderNumber;

    /**
     * 完工数量
     */
    private Long endNumber;

    /**
     * 下单日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime placeData;


}
