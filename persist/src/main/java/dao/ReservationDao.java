package dao;

import java.util.Collection;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Reservation;

public interface ReservationDao {
	public void insertReservation(Reservation reservation) throws InsertFailedException;

	public void updateReservation(Reservation reservation) throws UpdateFailedException;

	public Reservation getReservation(int id) throws NoResultException;
	
	public Collection<Reservation> getAllReservation() throws NoResultException;

	public void deleteReservation(int id) throws DeleteFailedException;

}
