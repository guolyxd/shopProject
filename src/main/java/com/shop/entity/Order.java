package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
/** 订单数据的实体类 */
public class Order extends BaseEntity implements Serializable {
    private Integer oid;
    private Integer uid;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;
    
}
