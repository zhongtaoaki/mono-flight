package com.example.msasample.mono.flight.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * フライト申込情報。
 * 
 * @author zhong
 *
 */
@Data
public class FlightApplicationInfo {

	/**
	 * フライト名。
	 */
	public @NotNull String flightName;

	/**
	 * 出発日。
	 */
	public @NotNull LocalDate departureDate;

}