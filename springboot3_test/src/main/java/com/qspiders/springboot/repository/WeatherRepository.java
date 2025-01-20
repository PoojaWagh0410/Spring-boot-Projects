package com.qspiders.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qspiders.springboot.entity.Weather_Info;

@Repository
public interface WeatherRepository extends JpaRepository<Weather_Info, Integer> {

	Optional<Weather_Info> findByTimeAndDate(String time, String date);
}
