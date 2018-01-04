package com.github.plei.modules.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 部门管理
 *
 * @author : pleier
 * @date: 2017/12/8
 */
public class SysDeptEntity implements Serializable {
    private static final long serialVersionUID = -7279586921673467196L;

    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 上级部门id
     */
    private Long parentId;
    /**
     * 部门名名称
     */
    private String name;
    /**
     * 上级 部门名称
     */
    private String parentName;
    /**
     * 排序
     */
    private Long orderNum;
    /**
     * ztree属性
     */
    private Boolean open;
    /**
     *
     */
    private List<?> list;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
