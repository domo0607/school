
public class LiquidVessel {

	// Member variables

	private int iVolume; // amount the cup can hold in ml

	private int iCapacity;

	public LiquidVessel() {
		setVolume(0);
		setcapacity(0);
	}

	public LiquidVessel(int size, int capacity) {
		setVolume(size);

		setcapacity(capacity);
	}

	public void setcapacity(int capacity) {
		this.iCapacity = capacity;
	}

	public void setVolume(int size) {
		this.iVolume = size;
	}

	public int getsize() {
		return this.iVolume;
	}

	public int getcapacity() {
		return this.iCapacity;
	}

	public void wash() {
		setVolume(0);
		return;
	}
}
