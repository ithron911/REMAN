package daomodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "RestaurantTable")
@Table(name = "RESTAURANT_TABLE")
public class RestaurantTable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@ManyToMany
	@JoinColumn(name = "Restaurant_ID")
	private Restaurant restaurant;

	@Column(name = "Chair_Number", nullable = false)
	private int chairNumber;

	@Column(name = "IS_RESERVED", nullable = false)
	private boolean isReserved;

	public RestaurantTable() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getChairNumber() {
		return chairNumber;
	}

	public void setChairNumber(int chairNumber) {
		this.chairNumber = chairNumber;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
}
