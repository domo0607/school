
public class Teapot extends LiquidVessel {
	
	private boolean blid;
	private boolean bspout;
	
	
	private String szEmpty; // to find if the cup is not empty drink it
	private String szColour; // what colour is this cup

	// constructors has to be the same as the file name
	public Teapot() {
		super();
		reset(); // Allow you to reset everything to a set value
	}

	public  Teapot(int size, String colour, int capacity) {
		super(size,capacity);
		setcolour(colour);
	}
	
	public Teapot(String state) {
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
	
	public void pour(int iPour) {
		if (iPour < getcapacity()) {
			setVolume(getcapacity() - iPour);
		}
		
	}
	
	public void setcapacity(int capacity) {
		if ((capacity >= 0) && (capacity <= 1500)) {
			super.setcapacity(capacity);;// if in this range it is correct and is equal
		} 
		else if (capacity > 1500) {
			super.setcapacity(1500);
		} else {
			super.setcapacity(0);
		}
	}

	public void setVolume(int size) {
		if ((size >= 0) && (size <= 1500)) {
			super.setVolume(size);
		} 
		else if (size > 1500) {
			super.setVolume(1500);
		} 
		else {
			super.setVolume(0);
		}
	}

	public String getstate() {
	
		if (getsize() == 0) {
			 return "Empty";
		} 
		else if (getsize() < getcapacity()) {
			return "Not full";
		} 
		else if (getsize() == getcapacity()) {
			return "Full";
		} 
		else if (getsize() > getcapacity()) {
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
		Teapot tp = new Teapot(500, "blue", 1500);
		
		System.out.println("you have got " + tp.getsize() + " ml in a " + tp.getcapacity() + " ml teapot.");
		System.out.println("Your teapot is now " + tp.getstate());
		System.out.println("You have set your colour to " + tp.getcolour());
	}

}
