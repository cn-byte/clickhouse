package com.demo.domain.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiansong
 */
@Accessors(chain = true)
@EqualsAndHashCode()
@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String userName;
    private String passWord;
    private String phone;
    private String email;
    private Date createTime;
    private Date updateTime;

}
