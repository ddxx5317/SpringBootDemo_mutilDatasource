package com.spb.SpringBootDemo.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spb.SpringBootDemo.vo.User;


/**
 *  
 * @author Administrator
 *
 */
@Mapper
public interface UserDao {

	/**
	 * 新增用户
	 * @param user
	 */
	void createUser(User user);
	/**
	 * 查询用户列表
	 * @return
	 */
	List<User> findAllUser();
}
