package com.gene.domain;

import java.util.List;

import com.gene.plugin.ioc.Service;
import com.jfinal.plugin.activerecord.Model;

@Service
public class User extends Model<User> {
	/**
	 * 用户DAO
	 */
	private static final long serialVersionUID = 1L;

	public User getUserByUserID(String loginid) {
		return (User) findFirst("select * from users where loginID = '"
				+ loginid + "'");
	}

	public List<User> getAllUsers() {
		return find("select * from users");
	}

	@Override
	public boolean save() {
		return super.save();
	}

	/**
	 * 修改用户的密码
	 * */
	public boolean updatePwd(String userName, String pwd) {
		return findFirst("select * from users where loginID='"+userName+"'").set("password", pwd).update();
	}

}
