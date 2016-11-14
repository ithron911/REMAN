package dao;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.MultipleResultException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Reservation;

public interface ReservationDao {
	public void insertReservation() throws InsertFailedException;

	public void updateReservation(Reservation reservation) throws UpdateFailedException;

	public void getReservation(Reservation reservation) throws NoResultException, MultipleResultException;

	public void deleteReservation(Reservation reservation) throws DeleteFailedException;

}
