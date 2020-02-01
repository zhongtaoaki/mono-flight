package com.example.msasample.mono.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.msasample.mono.flight.model.FlightApplicationInfo;
import com.example.msasample.mono.flight.model.entities.FlightReservation;
import com.example.msasample.mono.flight.services.FlightReserveService;

import lombok.extern.slf4j.Slf4j;

/**
 * フライト予約のコントローラー。
 * 
 * @author zhong
 *
 */
@RestController
@Slf4j
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

	@DeleteMapping("/flight/{id}")
	public void cancelFlight(@PathVariable Long id) {
		flightReserveService.cancelFlight(id);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void exceptionHandler(Exception exception) {
		if (exception.getMessage().equals("満席です。")) {
			log.info(exception.getMessage());
			return;
		}
	}

}
