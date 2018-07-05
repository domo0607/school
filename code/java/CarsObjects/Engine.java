
public class Engine  {



	private int iEngineSize ;
	private int iEnginePower ;
	private int iEnginePlace ;
	private int iFuelType;
	private int iGearBox;
	private int iDrive;

	enum FuelType{PETROL,DIESEL}
	enum Transmission{MANUAL,AUTO,SEMI}
	enum Drive{FOUR,FRONT,REAR}
	enum Place{MID,REAR,FRONT}

	FuelType eFuelType;
	Transmission eGearBox;
	Drive eDrive;
	Place ePlace;
	

	public Engine() {

		return;
	}



	public Engine(int EngineSize, int EnginePower, FuelType eFuelType,Transmission eGearBox, Drive eDrive,Place ePlace) {
		super();
		this.eDrive = eDrive;
		this.eFuelType = eFuelType;
		this.eGearBox = eGearBox;
		this.ePlace = ePlace;
		setEngineSize(EngineSize);
		setEnginePower(EnginePower);
		setFuelType(fuelType);
		
	}

	public void FuelType() {
		switch (eFuelType) {
		case PETROL:
			iFuelType = 10;
			break;

		case DIESEL:
			iFuelType = 20;
			break;

		}
	}
	public void setFuelType(int fuelType) {
		this.iFuelType = fuelType;
	}
	public int getFuelType() {
		return this.iFuelType;
	}

	public void EnginePlace() {
		switch (ePlace) {
		case REAR:
			iEnginePlace = 10 ;
			break;

		case FRONT:
			iEnginePlace = 20 ;
			break;

		case MID:
			iEnginePlace = 30 ;
			break;
		}

	}
	public void setEnginePlace(int enginePlace) {
		this.iEnginePlace = enginePlace;
	}
	public int getEnginePlace() {
		return this.iEnginePlace;
	}
	
	public void EngineDrive() {
		switch (eDrive) {
		case FRONT:
			iDrive = 10 ;
			break;

		case REAR:
			iDrive = 20 ;
			break;

		case FOUR:
			iDrive = 30;
			break;
		}
	}
	public void setEngineDrive(int engineDrive) {
		this.iDrive = engineDrive;
	}
	public int getEngineDrive() {
		return this.iDrive;
	}
	

	public void Transmisson(){
		switch (eGearBox) {
		case MANUAL:
			iGearBox = 10 ;
			break;

		case AUTO:
			iGearBox = 20 ;
			break ;

		case SEMI:
			iGearBox = 30 ;
			break;
		}
	}
	public void setTransmisson(int GearBox) {
		this.iGearBox = GearBox;
	}
	public int getTransmisson() {
		return this.iGearBox;
	}
	
	public void setEngineSize(int EngineSize) {
		this.iEngineSize = EngineSize ;
	}
	public int getEngineSize() {
		return this.iEngineSize ;
	}



	public void setEnginePower(int EnginePower) {
		this.iEnginePower = EnginePower ;
	}
	public int getEnginePower() {
		return this.iEnginePower ;
	}
}









