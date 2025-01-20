package com.qspiders.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qspiders.springboot.entity.Weather_Info;
import com.qspiders.springboot.repository.WeatherRepository;
import com.qspiders.springboot.response.WeatherResponse;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	public Weather_Info addDetails(Weather_Info weather_Info) {
		Weather_Info info = weatherRepository.save(weather_Info);
		return info;
	}

	public WeatherResponse findWeatherDetails(String time, String date) {
		Optional<Weather_Info> details = weatherRepository.findByTimeAndDate(time, date);
		if (details.isPresent()) {
			Weather_Info info = details.get();
			return new WeatherResponse(info.getTemp(), info.getWind_speed(), info.getHumidity());
		}
		return null;
	}
}
