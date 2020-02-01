package com.example.msasample.mono.flight.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.msasample.mono.flight.model.FlightApplicationInfo;
import com.example.msasample.mono.flight.model.entities.FlightReservation;
import com.example.msasample.mono.flight.model.entities.FlightReservationRepository;

/**
 * フライト予約サービス。
 * 
 * @author zhong
 *
 */
@Service
public class FlightReserveService {

	@Autowired
	private FlightReservationRepository flightReservationRepository;

	/**
	 * フライト予約を行う。
	 * 
	 * @param FlightApplicationInfo
	 * @return FlightReservation
	 */
	public FlightReservation reserveFlight(FlightApplicationInfo flightApplicationInfo) {

		FlightReservation example = FlightReservation.builder()//
				.flightName(flightApplicationInfo.getFlightName())//
				.departureDate(flightApplicationInfo.getDepartureDate())//
				.build();

		Example<FlightReservation> exampleFlight = Example.of(example);
		
		return flightReservationRepository.findOne(exampleFlight).orElseThrow();

	}
}
