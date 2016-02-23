package br.com.service;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.stereotype.Service;

import br.com.ejb.UserBean;
import br.com.ejb.bean.User;

//@Service
public class UserService {

//	@EJB
	private UserBean userBean;
	
	public List<User> findAll() {
		return userBean.findAll();
	}

}
