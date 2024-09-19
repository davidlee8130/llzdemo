package com.llz.dao.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 测试实体类
 */
@Data
@TableName("student")
public class Student {
    @TableId("id")
    private String id;
    private String name;
    private String gender;
    private String classnum;
    private String subject;
    private Integer score;
}
