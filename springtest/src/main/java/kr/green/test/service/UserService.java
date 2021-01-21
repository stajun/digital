package kr.green.test.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.UserVo;

public interface UserService {

	String getEmail(String id);

	UserVo getUser(String id);

	UserVo isUser(String id, String pw);

	boolean signup(UserVo user);

	UserVo getUser(HttpServletRequest request);
}
