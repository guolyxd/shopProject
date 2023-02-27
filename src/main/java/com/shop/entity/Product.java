package com.shop.entity;

import java.io.Serializable;
import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Feb 27, 2023
*/
@Data
public class Product extends BaseEntity implements Serializable{
	
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;

}
