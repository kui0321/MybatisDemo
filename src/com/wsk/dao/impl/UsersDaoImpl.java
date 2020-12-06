package com.wsk.dao.impl;

import com.wsk.dao.UserDao;
import com.wsk.pojo.Users;
import com.wsk.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UsersDaoImpl implements UserDao {
    /**
     * 查询所有用户
     * @return
     * @throws IOException
     */
    @Override
    public List<Users> selectUsersAll() throws IOException {
        //创建SqlSessionFaction对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //通过sqlSession的API完成对数据库的操作
        List<Users> list = sqlSession.selectList("com.wsk.mapper.UserMapper.selectUsersAll");
        //关闭SqlSession对象
        sqlSession.close();
        return list;
    }

    @Override
    public Users selectUsersById(int userid) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        Users users = sqlSession.selectOne("com.wsk.mapper.UserMapper.selectUsersById",userid);
        sqlSession.close();
        return users;
    }

    @Override
    public void insertUsers(Users users) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        int insert =  sqlSession.insert("com.wsk.mapper.UserMapper.insertUsers",users);
    }

    @Override
    public Users selectUsersById1(int userid) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Users users = sqlSession.selectOne("com.wsk.mapper.UserMapper.selectUserById1",userid);
        return users;
    }

    @Override
    public void UpdateUserById(Users users) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        sqlSession.update("com.wsk.mapper.UserMapper.UpdateUserById", users);
    }

    @Override
    public void deleteUserById(int userid) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        final int delete = sqlSession.delete("com.wsk.mapper.UserMapper.deleteUserById", userid);

    }


}
