package com.qspiders.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qspiders.springboot.DTO.AccountDTO;
import com.qspiders.springboot.entity.Account;
import com.qspiders.springboot.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//Add Account Rest API
	@PostMapping(path="/accounts")
	protected ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
		return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
	}
	
	//Get account Rest API
	@GetMapping(path="/accounts/{id}")
	protected ResponseEntity<AccountDTO> getAccountById(@PathVariable int id){
		return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.FOUND);
	}
	
	//Deposite amount Rest API
	@PutMapping(path="/accounts/deposite/{id}")
	protected ResponseEntity<AccountDTO> depositeAmount(@PathVariable int id,@RequestBody Map<String,Double> request){	
		double amount = request.get("amount");
		AccountDTO deposite = accountService.deposite(id,amount);		
		return ResponseEntity.ok(deposite);		
	}
	
	//Withdrawn amount REST API
	@PutMapping(path="/accounts/withdrawn/{id}")
	protected ResponseEntity<AccountDTO> withdrawnAmount(@PathVariable int id,@RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		AccountDTO withdrawn = accountService.withdrawn(id, amount);
		return ResponseEntity.ok(withdrawn);		
	}
	
	@GetMapping(path="/accounts")
	protected ResponseEntity<Object> getAllAccounts(){
		List<Account> allAccounts = accountService.getAllAccounts();
		if(allAccounts != null)
			return new ResponseEntity<Object>(allAccounts , HttpStatus.FOUND);
		
		return new ResponseEntity<Object>("Accounts not found" , HttpStatus.NOT_FOUND);		
	}	

	@DeleteMapping(path="/accounts/{id}")
	protected ResponseEntity<Object> deleteAccount(@PathVariable int id){
		boolean deletedAccount = accountService.deleteAccount(id);
		if(deletedAccount)
			return new ResponseEntity<>("Account deleted sucessfully", HttpStatus.OK);
		return  new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
		
	}
}












