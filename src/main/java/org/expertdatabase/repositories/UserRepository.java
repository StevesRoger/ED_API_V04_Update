package org.expertdatabase.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.expertdatabase.entities.apiuser.Role;
import org.expertdatabase.entities.apiuser.User;
import org.expertdatabase.entities.temp.UserKA;

@Repository
public interface UserRepository {

	@Select("SELECT * FROM exp_api_user WHERE user_name=#{name}")
	@Results(value={
			@Result(property="id",column="user_id"),
			@Result(property="name",column="user_name"),
			@Result(property="password",column="user_password"),
			@Result(property="roles",column="role_id",
			many=@Many(select="findRoleById"))			
	})
	public User findUserByName(String userName);
	
	@Select("SELECT * FROM exp_api_role")
	@Results(value={
			@Result(property="id",column="role_id"),
			@Result(property="roleName",column="role_name")
	})
	public ArrayList<Role> findRoleById(int id);
	
	@Select("SELECT * FROM exp_user WHERE user_email=#{email} AND user_password=#{password}")
	public UserKA findUserByEmailAndPassword(@Param("email")String email,@Param("password")String password);

	//public boolean add
}
