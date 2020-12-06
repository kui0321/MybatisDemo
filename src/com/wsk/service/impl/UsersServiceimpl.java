package com.wsk.service.impl;

import com.wsk.dao.UserDao;
import com.wsk.dao.impl.UsersDaoImpl;
import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import com.wsk.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UsersServiceimpl implements UsersService {
    /**
     * 添加用户
     * @param users
     */
    @Override
    public void addUsers(Users users) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserDao userDao = new UsersDaoImpl();
            userDao.insertUsers(users);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Override
    public Users preUpdateUsers(int userid) {
        Users users = null;
        try {
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            UserDao userDao = new UsersDaoImpl();
            users = userDao.selectUsersById1(userid);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
        return users;
    }

    @Override
    public void modifyUser(Users users) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        try {
            UserDao userDao = new UsersDaoImpl();
            userDao.UpdateUserById(users);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Override
    public void dropUserByid(int userid) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserDao userDao = new UsersDaoImpl();
            userDao.deleteUserById(userid);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}
