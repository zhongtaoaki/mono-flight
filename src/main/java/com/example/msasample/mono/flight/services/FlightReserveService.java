package com.example.msasample.mono.flight.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public FlightReservation reserveFlight(FlightApplicationInfo flightApplicationInfo) {

		if (flightReservationRepository.count() > 5) {
			throw new RuntimeException("満席です。");
		}

		FlightReservation flightReservation = FlightReservation.builder()//
				.flightName(flightApplicationInfo.getFlightName())//
				.departureDate(flightApplicationInfo.getDepartureDate())//
				.departureDateTime(LocalDateTime.now())//
				.arrivalDateTime(LocalDateTime.now())//
				.departureAirport("HND")//
				.arrivalAirport("KIX")//
				.seatNo("A001").build();

		return flightReservationRepository.saveAndFlush(flightReservation);

	}

	@Transactional
	public void cancelFlight(Long id) {
		flightReservationRepository.deleteById(id);
	}
}
