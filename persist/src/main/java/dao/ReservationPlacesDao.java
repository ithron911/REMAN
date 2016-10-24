package dao;

import java.util.List;

import daomodels.ReservationPlaces;

public interface ReservationPlacesDao {

	void recordReservationPlaces(ReservationPlaces reservationPlaces);

	List<ReservationPlaces> getAllReservationPlaces();

	void deleteReservationPlaces(ReservationPlaces reservationPlaces);
}
