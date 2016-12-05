package hu.uni.reman.persist.mysql.mapper;

import model.Reservation;

public interface ReservationMapper {

	void insertReservation(Reservation reservation);
	void updateReservation(Reservation reservation);
	Reservation getReservation(int id);
	void deleteReservation(int id);
}
