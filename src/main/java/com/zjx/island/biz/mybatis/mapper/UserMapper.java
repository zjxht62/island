package com.zjx.island.biz.mybatis.mapper;

import com.zjx.island.biz.mybatis.first.User;
import com.zjx.island.biz.mybatis.vo.UserCustom;
import com.zjx.island.biz.mybatis.vo.UserQueryVo;

import java.util.List;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/11/8
 */
public interface UserMapper {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据用户名列查询用户列表
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;

    //更新用户
    public void updateUser(User user)throws Exception;

    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //根据ID查询用户信息，使用resultMap输出
    public User findUserByIdResultMap(int id) throws Exception;
}
