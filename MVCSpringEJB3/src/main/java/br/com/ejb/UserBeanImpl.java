package br.com.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import br.com.ejb.bean.User;

@Stateless(mappedName = "MVCSpringEJB3/Remote")
//@Remote(UserBean.class)
//@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UserBeanImpl implements UserBean {

    public List<User> findAll() {
        return new ArrayList<User>();
    }

}