package cn.pjmike.Blog.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * 自定义mybatis分页拦截器
 *
 * @author pjmike
 * @create 2018-02-05 16:10
 **/@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})})
public class MyPageInterceptor implements Interceptor {
    /**
     * 每页显示的条数
     */
    private Integer pageSize;
    /**
     * 当前的页数
     */
    private Integer currPage;
    private String dbType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //取出被拦截对象
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        //分离代理对象，从而形成多次代理，通过两次循环最原始的被代理类，mybatis使用的JDK代理
        while (metaObject.hasGetter("h")) {
            Object object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }
        //分离最后一个代理对象的目标类
        while (metaObject.hasGetter("target")) {
            Object object = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(object);
        }
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();
        // 拦截以.ByPage结尾的请求，分页功能的统一实现
        if (mapId.matches(".+ByPage$")) {
            // 获取进行数据库操作时管理参数的handler
            ParameterHandler parameterHandler = (ParameterHandler) metaObject
                    .getValue("delegate.parameterHandler");
            // 获取请求时的参数
            Map<String, Object> paraObject = (Map<String, Object>) parameterHandler.getParameterObject();


            // 参数名称和在service中设置到map中的名称一致
            currPage = (Integer) paraObject.get("currPage");
            pageSize = (Integer) paraObject.get("pageSize");

            String sql = (String) metaObject.getValue("delegate.boundSql.sql");
            // 也可以通过statementHandler直接获取
            // sql = statementHandler.getBoundSql().getSql();

            // 构建分页功能的sql语句
            String limitSql;
            sql = sql.trim();
            limitSql = sql + " limit " + (currPage - 1) * pageSize + "," + pageSize;

            // 将构建完成的分页sql语句赋值个体'delegate.boundSql.sql'
            metaObject.setValue("delegate.boundSql.sql", limitSql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        //使用默认的mybatis提供的生成代理对象
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String limit = (String) properties.setProperty("limit", "10");
        this.pageSize = Integer.parseInt(limit);
        //设置数据库类型
        this.dbType = (String) properties.setProperty("dbType", "mysql");
    }
}
