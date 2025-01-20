package com.qspiders.springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

	private int id;
	private String accountHolderName;
	private double balance;

}
