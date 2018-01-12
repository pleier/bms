package com.github.plei.common.aspect;

import com.github.plei.common.annotation.DataFilter;
import com.github.plei.common.exception.BmsException;
import com.github.plei.common.utils.Constant;
import com.github.plei.modules.sys.entity.SysUserEntity;
import com.github.plei.modules.sys.service.SysDeptService;
import com.github.plei.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 数据过滤，切面处理类
 *
 * @author : pleier
 * @date: 2018/1/4
 */
@Aspect
@Component
public class DataFilterAspect {

    @Autowired
    @Qualifier("sysDeptService")
    private SysDeptService sysDeptService;

    @Pointcut("@annotation(com.github.plei.common.annotation.DataFilter)")
    public void dataFilterCut() {

    }

    @Before("dataFilterCut()")
    public void dataFilter(JoinPoint point) throws Throwable {
        Object params = point.getArgs()[0];
        if (params != null && params instanceof Map) {
            SysUserEntity user = ShiroUtils.getUserEntity();

            //如果不是超级管理员，则只能查询本部门及子部门数据
            if (user.getUserId() != Constant.SUPER_ADMIN) {
                Map map = (Map) params;
                map.put("filterSql", getFilterSQL(user, point));
            }

            return;
        }
        throw new BmsException("要实现数据权限接口的参数，只能是Map类型，且不能为NULL");
    }

    /**
     * 获取过滤数据的sql
     *
     * @param user
     * @param point
     * @return
     */
    private String getFilterSQL(SysUserEntity user, JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);
        //获取表的别名
        String tableAlias = dataFilter.tableAlias();
        if (StringUtils.isNotBlank(tableAlias)) {
            tableAlias += ".";
        }

        //获取子部门ID
        String subDeptIds = sysDeptService.getSubDeptIdList(user.getDeptId());

        StringBuilder filterSql = new StringBuilder();
        filterSql.append("and (");
        filterSql.append(tableAlias).append("dept_id in(").append(subDeptIds).append(")");

        //没有本部门数据权限，也能查询本人数据
        if (dataFilter.user()) {
            filterSql.append(" or ").append(tableAlias).append("user_id=").append(user.getUserId());
        }
        filterSql.append(")");

        return filterSql.toString();
    }
}
