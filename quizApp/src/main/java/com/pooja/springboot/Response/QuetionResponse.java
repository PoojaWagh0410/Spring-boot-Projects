package com.pooja.springboot.Response;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuetionResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String quetionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

}
