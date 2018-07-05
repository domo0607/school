
public class Vehicle {


	private int iWheels ;
	private int iSeats ;
	private int iDoors ;
	public Engine myEngine = new Engine() ;

	public Vehicle() {

	}

	public Vehicle(int Wheels, int Seats) {
		setWheels(Wheels);
		setSeats(Seats);

	}

	public void setWheels(int Wheels) {
		this.iWheels = Wheels ;
	}
	public int getWheels() {
		return this.iWheels ;
	}

	public void setSeats(int Seats) {
		this.iSeats = Seats ;
	}
	public int getSeats() {
		return this.iSeats ;
	}

	public void setDoors(int Doors) {
		this.iDoors = Doors ;
	}
	public int getDoors() {
		return this.iDoors ;
	}


}
