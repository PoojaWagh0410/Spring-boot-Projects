package com.qspiders.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qspiders.springboot.DTO.AccountDTO;
import com.qspiders.springboot.entity.Account;
import com.qspiders.springboot.mapper.AccountMapper;
import com.qspiders.springboot.repository.AccountRepository;
import com.qspiders.springboot.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDTO createAccount(AccountDTO accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account accountSaved = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(accountSaved);
	}

	@Override
	public AccountDTO getAccountById(int id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDTO deposite(int id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDTO withdrawn(int id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));

		if (account.getBalance() < amount)
			throw new RuntimeException("Insufficient Balanace");

		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> allAccounts = accountRepository.findAll();
		if (allAccounts.size() > 0) {
			return allAccounts;
		}
		return null;
	}

	@Override
	public boolean deleteAccount(int id) {
		accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		try {
			accountRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
