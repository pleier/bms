package com.github.plei.modules.sys.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统配置信息
 *
 * @author : pleier
 * @date: 2017/12/8
 */
public class SysConfigEntity implements Serializable {
    private static final long serialVersionUID = -293181678377952729L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 参数名
     */
    @NotBlank(message = "参数名不能为空")
    private String key;

    /**
     * 参数值
     */
    @NotBlank(message = "参数值不能为空")
    private String value;
    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
