package com.ebsco.artfulauth.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ebsco.artfulauth.value.UserVO;


@Service
public class AuthorizationService {
	HashMap<Integer, UserVO> users = new HashMap<Integer, UserVO>();
	
	public AuthorizationService() {
		UserVO vo = new UserVO("testname1", "testpwd");
		users.put(vo.getId(), vo);
		vo = new UserVO("testname2", "testpwd");
		users.put(vo.getId(), vo);
		vo = new UserVO("testname3", "testpwd");
		users.put(vo.getId(), vo);
	}
	
	public UserVO getById(Integer id){
		return users.get(id);
	}
	
	public UserVO createUser(UserVO uservo){
		uservo = new UserVO(uservo.getUsername(), uservo.getPassword());
		users.put(uservo.getId(), uservo);
		return uservo;
	}
	
	public UserVO updateUser(Integer id, UserVO uservo){
		UserVO userUpdate = users.get(id);
		userUpdate.setUsername(uservo.getUsername());
		userUpdate.setPassword(uservo.getPassword());
		return userUpdate;
	}
	
	public UserVO deleteById(Integer id){
		UserVO userUpdate = users.get(id);
		users.remove(id);
		return userUpdate;
	}
	
	public Boolean login(UserVO uservo){
		return users.entrySet().stream()
                .filter(map -> uservo.getUsername()
                .equals(map.getValue().getUsername()) && uservo.getPassword()
                .equals(map.getValue().getPassword()))
                .map(map -> map.getValue().getUsername())
                .collect(Collectors.joining(uservo.getUsername())).equals("") ? false : true;
	}
}
