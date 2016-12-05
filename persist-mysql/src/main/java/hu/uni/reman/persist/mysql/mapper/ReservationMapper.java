package hu.uni.reman.persist.mysql.mapper;

import java.util.Collection;

import model.Reservation;

public interface ReservationMapper {

	void insertReservation(Reservation reservation);
	void updateReservation(Reservation reservation);
	Reservation getReservation(int id);
	Collection<Reservation> getAllReservations();
	void deleteReservation(int id);
}
