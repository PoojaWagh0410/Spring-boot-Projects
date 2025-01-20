package com.qspiders.springboot.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

	private int temp;
	private double wind_speed;
	private double humidity;

}
