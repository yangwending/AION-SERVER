package com.aionstar.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class BaseDao {

    private final SqlSessionFactory sessionFactory;

    private static ThreadLocal<SqlSession> sessionThreadLocal = new ThreadLocal<>();

    protected BaseDao(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected  <T> T getMapperInstance(Class<T> clazz){
         SqlSession session = sessionFactory.openSession();
         sessionThreadLocal.set(session);
         return session.getMapper(clazz);
    }

    protected void commit(){
        SqlSession session = sessionThreadLocal.get();
        session.commit();
        sessionThreadLocal.remove();
    }

    protected void rollback(){
        SqlSession session =sessionThreadLocal.get();
        session.rollback();
    }

    /**
     * 获取当前线程上下文中的session
     * @return  session
     */
    public SqlSession getSession(){
        return sessionThreadLocal.get();
    }
}
