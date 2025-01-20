package com.qspiders.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Weather")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Weather_Info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String time;
	private String day;
	private String date;
	private int temp;
	private double wind_speed;
	private double humidity;

}
