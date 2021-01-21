package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.UserVo;

public interface UserDao {
	public String getEmail(@Param("id")String id);

	public String getName(@Param("id")String id);

	public UserVo getUser(@Param("id")String id);

	public int getAge(@Param("id")String id);

	public ArrayList<UserVo> getAllUser();

	public void insertUser(@Param("user")UserVo user);

	public void updateAuthor(@Param("user")UserVo userVo);

	public void updateUser(@Param("user")UserVo dbUser);
}

