package com.qspiders.springboot.mapper;

import com.qspiders.springboot.DTO.AccountDTO;
import com.qspiders.springboot.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDTO accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
		return account;
	}
	
	public static AccountDTO mapToAccountDto(Account account) {
		AccountDTO accountDto = new AccountDTO(account.getId(), account.getAccountHolderName(), account.getBalance());
		return accountDto;
	}

}
