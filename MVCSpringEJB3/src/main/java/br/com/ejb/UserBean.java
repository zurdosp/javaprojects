package br.com.ejb;

import java.util.List;

import javax.ejb.Remote;

import br.com.ejb.bean.User;

@Remote
public interface UserBean {

	List<User> findAll();

}