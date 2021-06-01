package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.UserDao;
import com.dbManager.DbConnection;
import com.Model.User;

public class UserDaoImp implements UserDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addUser(User user) {
		 int row=0;
			PreparedStatement pst=null;
			try {
			pst=(PreparedStatement)conn.prepareStatement("insert into user(user_name,user_nic,user_password) values(?,?,?) ");
			if(user.getUserName()!=null)
			pst.setString(1,user.getUserName());
			if(user.getNIC()!=null)
			pst.setString(2,user.getNIC());
			if(user.getUserPassword()!=null)
			pst.setString(3, user.getUserPassword());
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<User> getUsers() {
		List<User> list=new ArrayList<>(); 
		try
        {
            String query="select * from user"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	User user=new User();
             user.setUserId(rs.getInt("user_id"));
             user.setUserName(rs.getString("user_name"));
             user.setNIC(rs.getString("user_nic"));
             user.setUserPassword(rs.getString("user_password"));
             list.add(user);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteUser(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from user where user_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public Integer getIdByUser(String user_name) {
		Integer user_Id = 0;
        try {
            String delete = "select user_id from user where user_name=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setString(1, user_name);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
             user_Id = rst.getInt("user_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	return user_Id;
	}

	@Override
	public User getUserById(int id) {
		User user=new User();
		try
        {
            String query="select * from user where user_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	
            	user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setNIC(rs.getString("user_nic"));
                user.setUserPassword(rs.getString("user_password"));
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return user;
	}

	@Override
	public Integer updateUser(User user) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update user set user_name=?, user_nic=?, user_password=? where user_id=?");
			ps.setString(1,user.getUserName());
			ps.setString(2, user.getNIC());
			ps.setString(3,user.getUserPassword());
	        ps.setInt(4,user.getUserId());
		   status=ps.executeUpdate();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}

}
