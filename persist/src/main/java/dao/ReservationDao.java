package dao;

import java.util.List;

import daomodels.Reservation;

public interface ReservationDao {

	void recordReservation(Reservation reservation);

	List<Reservation> getAllReservations();

	void deleteReservation(Reservation reservation);
}
