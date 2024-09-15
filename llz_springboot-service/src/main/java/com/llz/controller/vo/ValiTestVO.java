package com.llz.controller.vo;

import com.llz.common.util.enumValidate.EnumValue;
import com.llz.common.util.enumValidate.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 参数校验测试用VO
 */
@Data
public class ValiTestVO {
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
    @EnumValue(enumClass = Gender.class , message = "性别字段校验错误")
    private String gender;

}
