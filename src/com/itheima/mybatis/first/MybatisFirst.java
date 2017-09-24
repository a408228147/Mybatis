package com.itheima.mybatis.first;

import com.itheima.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatisFirst {
    @Test
    public void findUserByIdTest() throws Exception {

        //全局配置文件的路径
        String resource = "SqlMapConfig.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用sqlSession的增删改查
        //第一个参数：表示statement的唯一标识
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
    //  关闭资源
        sqlSession.close();
    }

}