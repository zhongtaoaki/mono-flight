package com.example.msasample.mono.flight.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * フライトの予約情報を表す。
 * 
 * @author ootsuka
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
public class FlightReservation {

	/**
	 * PK. <br>
	 * 自動採番される。
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.PRIVATE)
	private Long flightReservationId;

	/**
	 * フライト名。
	 */
	private String flightName;

	/**
	 * 出発日付。
	 */
	private LocalDate departureDate;

	/**
	 * 出発日時。
	 */
	private LocalDateTime departureDateTime;

	/**
	 * 到着日時。
	 */
	private LocalDateTime arrivalDateTime;

	/**
	 * 出発空港。
	 */
	private String departureAirport;

	/**
	 * 到着空港。
	 */
	private String arrivalAirport;

	/**
	 * 座席番号。
	 */
	private String seatNo;
}
