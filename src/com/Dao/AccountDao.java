package com.Dao;

import java.util.List;

import com.Model.Account;;

public interface AccountDao {
	public Integer addAccount(Account account);
	public List<Account> getAllAcounts();
	public Integer deleteAccount(Integer id);
	public Integer getIdByAccount(String account_name);
    public Account getAccountById(int id);
    public Integer updateAccount(Account account);
}