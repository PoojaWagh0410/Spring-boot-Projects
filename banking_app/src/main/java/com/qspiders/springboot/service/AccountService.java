package com.qspiders.springboot.service;

import java.util.List;

import com.qspiders.springboot.DTO.AccountDTO;
import com.qspiders.springboot.entity.Account;

public interface AccountService {

	AccountDTO createAccount(AccountDTO accountDto);
	
	AccountDTO getAccountById(int id);
	
	AccountDTO deposite(int id, double amount);
	
	AccountDTO withdrawn(int id, double amount);
	
	List<Account> getAllAccounts();
	
	boolean deleteAccount(int id);
}
