package dataAccess.concretes;


import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	@Override
	public void add(User user) {
		System.out.println(user.getFirstName() + " isimli kullanýcý Hibarnate kullanarak DB'ye eklendi ");
	
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
