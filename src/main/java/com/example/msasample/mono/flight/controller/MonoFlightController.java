package com.example.msasample.mono.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msasample.mono.flight.model.FlightApplicationInfo;
import com.example.msasample.mono.flight.model.entities.FlightReservation;
import com.example.msasample.mono.flight.services.FlightReserveService;

/**
 * フライト予約のコントローラー。
 * 
 * @author zhong
 *
 */
@RestController
public class MonoFlightController {

	@Autowired
	private FlightReserveService flightReserveService;

	/**
	 * フライト予約を行う。
	 * 
	 * @return FlightReservation
	 */
	@PostMapping("/flight")
	public FlightReservation reserveFlight(@RequestBody FlightApplicationInfo flightApplicationInfo) {
		return flightReserveService.reserveFlight(flightApplicationInfo);
	}
}
