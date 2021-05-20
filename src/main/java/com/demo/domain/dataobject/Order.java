package com.demo.domain.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiansong
 */
@Data
public class Order implements Serializable {
    private Long Id;
    private Long userId;
    private String title;
    private Float price;
    private Date createTime;
    private Date updateTime;
}
