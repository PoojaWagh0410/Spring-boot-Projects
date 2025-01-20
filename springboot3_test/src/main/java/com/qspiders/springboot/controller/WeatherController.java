package com.qspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspiders.springboot.entity.Weather_Info;
import com.qspiders.springboot.response.WeatherResponse;
import com.qspiders.springboot.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@PostMapping(path = "/weather")
	protected Weather_Info addDetails(@RequestBody Weather_Info weather_Info) {
		return weatherService.addDetails(weather_Info);
	}

	@GetMapping(path = "/weather")
	protected ResponseEntity<Object> findWeatherDetails(@RequestParam String time, @RequestParam String date) {
		WeatherResponse details = weatherService.findWeatherDetails(time, date);
		if (details != null) {
			return new ResponseEntity<>(details, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Details Not Found", HttpStatus.NOT_FOUND);
		}
	}

}
