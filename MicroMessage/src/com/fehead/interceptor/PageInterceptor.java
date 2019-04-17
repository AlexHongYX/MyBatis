package com.fehead.interceptor;

import com.fehead.entity.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
* 分页拦截器
*/

//通过注解描述准确的方法
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {

    private String test;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //配置文件中SQL语句的ID
        String id = mappedStatement.getId();
        if(id.matches(".+ByPage$")){
            BoundSql boundSql = statementHandler.getBoundSql();

            //原始sql语句
            String sql = boundSql.getSql();

            //查询总条数的sql语句,把当前sql语句当成子查询，并且要起一个别名
            String countSql = "select count(*) from (" + sql + ")a";

            //自己创建一个Statement，通过Connection
                //只有一个参数，所以使用[0]
            Connection connection = (Connection)invocation.getArgs()[0];
                //创建一个PreparedStatement，但没有参数
            PreparedStatement countStatement = connection.prepareStatement(countSql);
                //通过metaObject访问.xml文件中对应方法的所有参数
            ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                //通过parameterHandler设置PreparedStatement，让原始sql语句中所有的？与参数相互对应——eg：？==#{message.command}
            parameterHandler.setParameters(countStatement);
                //取出PreparedStatement的值，执行executeQuery（和JDBC类似）
            ResultSet rs = countStatement.executeQuery();


            //配置参数——与Dao层相对应，因为要返回Map所以需要强转（本来是Object）
            Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
            Page page = (Page) parameter.get("page");

            //判断是否有取出的参数，来为page的totalNumber赋值
            //因为只有一个参数count，所以用if就可以了
            if(rs.next()){
                //将自己设置的Statement中取得的值赋给page的totalNumber
                page.setTotalNumber(rs.getInt(1));
            }

//            System.out.println(page.getTotalPage());
//            System.out.println(page.getTotalNumber());
//            System.out.println(page.getPageNumber());
//            System.out.println(page.getCurrentPage());
//            System.out.println(page.getDbIndex());
//            System.out.println(page.getDbNumber());



            //改造后带分页查询的SQL语句（原始sql+配置参数）
            String pageSql = sql + " limit "+page.getDbIndex()+","+page.getDbNumber();

            //MetaObject：修改原本修改不了的值，注意使用的属性的位置，偷天换日
            metaObject.setValue("delegate.boundSql.sql",pageSql);
        }
        //归还主权
        return invocation.proceed() ;
    }

    //设置拦截器，如果不符合拦截器设定（不需要分页）就返回原来的对象，如果需要分页，就返回代理类
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.test = properties.getProperty("test");
    }
}
