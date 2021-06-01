package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.AccountDao;
import com.Model.Account;
import com.Model.User;
import com.dbManager.DbConnection;

public class AccountDaoImp implements AccountDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addAccount(Account account) {
		 int row=0;
			PreparedStatement pst=null;
			try {
			pst=(PreparedStatement)conn.prepareStatement("insert into account(account_no,account_name,password,address,Balance) values(?,?,?,?,?) ");
			if(account.getAccountNo()!=null)
			pst.setInt(1, account.getAccountNo());
			if(account.getAccountHolder()!=null)
			pst.setString(2,account.getAccountHolder());
			if(account.getPassword()!=null)
			pst.setString(3, account.getPassword());
			if(account.getAddress()!=null)
		    pst.setString(4, account.getAddress());
			if(account.getBalance()!=null)
			pst.setDouble(5, account.getBalance());
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<Account> getAllAcounts() {
		List<Account> list=new ArrayList<>(); 
		try
        {
            String query="select * from account"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              Account account=new Account();
                 account.setAccountId(rs.getInt("account_id"));
                 account.setAccountNo(rs.getInt("account_no"));
                 account.setAccountHolder(rs.getString("account_name"));
                 account.setPassword(rs.getString("password"));
                 account.setAddress(rs.getString("address"));
                 account.setBalance(rs.getDouble("Balance"));
                 list.add(account);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteAccount(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from account where account_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;

	}

	@Override
	public Integer getIdByAccount(String account_name) {
		Integer account_Id = 0;
        try {
            String delete = "select account_id from account where account_name=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setString(1, account_name);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
             account_Id = rst.getInt("account_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	return account_Id;
	}

	@Override
	public Account getAccountById(int id) {
		Account account=new Account();
		try
        {
            String query="select * from account where account_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	 account.setAccountId(rs.getInt("account_id"));
                 account.setAccountNo(rs.getInt("account_no"));
                 account.setAccountHolder(rs.getString("account_name"));
                 account.setPassword(rs.getString("password"));
                 account.setAddress(rs.getString("address"));
                 account.setBalance(rs.getDouble("Balance"));
            	
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return account;
	}

	@Override
	public Integer updateAccount(Account account) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update account set account_no=?, account_name=?, password=?,address=?, Balance=? where account_id=?");
			ps.setInt(1, account.getAccountNo());
			ps.setString(2,account.getAccountHolder());
			ps.setString(3,account.getPassword());
			ps.setString(4,account.getAddress());
			ps.setDouble(5,account.getBalance());
	        ps.setInt(6,account.getAccountId());
		   status=ps.executeUpdate();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}

}
