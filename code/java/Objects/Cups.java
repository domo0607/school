/**
 * this is to learn about object orientation this is for the creation of a mug
 */
public class Cups extends LiquidVessel {

	// Member variables

	private String szEmpty; // to find if the cup is not empty drink it
	private String szColour; // what colour is this cup

	// constructors has to be the same as the file name
	public Cups() {
		super();
		reset(); // Allow you to reset everything to a set value
	}

	public  Cups(int size, String colour, int capacity) {
		super(size,capacity);
		setcolour(colour);
	}
	
	public Cups(String state) {
		reset();

		setstate(state);
		return;
	}

	// setters

	public void reset() {
		setVolume(0);
		setcolour(null);
		setcapacity(500);
		return;
	}
	
	
	public void setcapacity(int capacity) {
		if ((capacity >= 0) && (capacity <= 500)) {
			super.setcapacity(capacity);// if in this range it is correct and is equal
		} 
		else if (capacity > 500) {
			super.setcapacity(500) ;
		} 
		else {
			super.setcapacity(0);
		}
	}

	public void setVolume(int size) {
		if ((size >= 0) && (size <= 500)) {
			super.setVolume(size);
		} 
		else if (size > 500) {
			super.setVolume(500);;
		} 
		else {
			super.setVolume(0);
		}
	}

	public String getstate() {
	
		if (getsize() == 0) {
			 return "Empty";
		} else if (getsize() < getcapacity()) {
			return "Not full";
		} else if (getsize() == getcapacity()) {
			return "Full";
		} else if (getsize() > getcapacity()) {
			return "Overflowing";
		}
		return null;
	}

	public String getcolour() {
		return this.szColour;

	}

	public void setstate(String state) {
		
		

	}

	public void setcolour(String colour) {
		this.szColour = colour;

	}

	public static void main(String[] args) {

		
		Cups cup = new Cups(450,"blue",500);
		
	
		

		System.out.println("You have put " + cup.getsize() + " ml into a cup wich is " + cup.getcapacity() + " ml big.");
		System.out.println("Your cup is now " + cup.getstate());
		System.out.println("You have set your colour to " + cup.getcolour());

	}

}
