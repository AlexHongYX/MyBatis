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
* ��ҳ������
*/

//ͨ��ע������׼ȷ�ķ���
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {

    private String test;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //�����ļ���SQL����ID
        String id = mappedStatement.getId();
        if(id.matches(".+ByPage$")){
            BoundSql boundSql = statementHandler.getBoundSql();

            //ԭʼsql���
            String sql = boundSql.getSql();

            //��ѯ��������sql���,�ѵ�ǰsql��䵱���Ӳ�ѯ������Ҫ��һ������
            String countSql = "select count(*) from (" + sql + ")a";

            //�Լ�����һ��Statement��ͨ��Connection
                //ֻ��һ������������ʹ��[0]
            Connection connection = (Connection)invocation.getArgs()[0];
                //����һ��PreparedStatement����û�в���
            PreparedStatement countStatement = connection.prepareStatement(countSql);
                //ͨ��metaObject����.xml�ļ��ж�Ӧ���������в���
            ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                //ͨ��parameterHandler����PreparedStatement����ԭʼsql��������еģ�������໥��Ӧ����eg����==#{message.command}
            parameterHandler.setParameters(countStatement);
                //ȡ��PreparedStatement��ֵ��ִ��executeQuery����JDBC���ƣ�
            ResultSet rs = countStatement.executeQuery();


            //���ò���������Dao�����Ӧ����ΪҪ����Map������Ҫǿת��������Object��
            Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
            Page page = (Page) parameter.get("page");

            //�ж��Ƿ���ȡ���Ĳ�������Ϊpage��totalNumber��ֵ
            //��Ϊֻ��һ������count��������if�Ϳ�����
            if(rs.next()){
                //���Լ����õ�Statement��ȡ�õ�ֵ����page��totalNumber
                page.setTotalNumber(rs.getInt(1));
            }

//            System.out.println(page.getTotalPage());
//            System.out.println(page.getTotalNumber());
//            System.out.println(page.getPageNumber());
//            System.out.println(page.getCurrentPage());
//            System.out.println(page.getDbIndex());
//            System.out.println(page.getDbNumber());



            //��������ҳ��ѯ��SQL��䣨ԭʼsql+���ò�����
            String pageSql = sql + " limit "+page.getDbIndex()+","+page.getDbNumber();

            //MetaObject���޸�ԭ���޸Ĳ��˵�ֵ��ע��ʹ�õ����Ե�λ�ã�͵�컻��
            metaObject.setValue("delegate.boundSql.sql",pageSql);
        }
        //�黹��Ȩ
        return invocation.proceed() ;
    }

    //����������������������������趨������Ҫ��ҳ���ͷ���ԭ���Ķ��������Ҫ��ҳ���ͷ��ش�����
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.test = properties.getProperty("test");
    }
}
