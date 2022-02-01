package lab10.builder;

import java.util.ArrayList;

public class House {

	// TODO: write optional and mandatory facilities to have in a house
	private String location;
	private int floors;
	private String heating;
	private int rooms;

	private String poolType;
	private String energySupplier;
	private String securitySystem;
	private String acBrand;



	// TODO: complete the private constructor
	private House(HouseBuilder builder) {
		this.location = builder.location;
		this.floors = builder.floors;
		this.heating = builder.heating;
		this.rooms = builder.rooms;
		this.poolType = builder.poolType;
		this.energySupplier = builder.energySupplier;
		this.securitySystem = builder.securitySystem;
		this.acBrand = builder.acBrand;
	}

	// TODO: generate getters
	public String getLocation() {
		return location;
	}

	public int getFloors() {
		return floors;
	}

	public String getHeating() {
		return heating;
	}

	public int getRooms() {
		return rooms;
	}

	public String getPoolType() {
		return poolType;
	}

	public String getEnergySupplier() {
		return energySupplier;
	}

	public String getSecuritySystem() {
		return securitySystem;
	}

	public String getAcBrand() {
		return acBrand;
	}


	// TODO: override toString method
	@Override
	public String toString() {
		return "House{" +
				"location='" + location + '\'' +
				", floors=" + floors +
				", heating='" + heating + '\'' +
				", rooms=" + rooms +
				", poolType='" + poolType + '\'' +
				", energySupplier='" + energySupplier + '\'' +
				", securitySystem='" + securitySystem + '\'' +
				", acBrand='" + acBrand + '\'' +
				'}';
	}

	public static class HouseBuilder {

		// TODO: write same facilities
		private String location;
		private int floors;
		private String heating;
		private int rooms;

		private String poolType;
		private String energySupplier;
		private String securitySystem;
		private String acBrand;

		// TODO: complete the house builder constructor only with the mandatory facilities
		public HouseBuilder(String location, int floors, String heating, int rooms) {
			this.location = location;
			this.floors = floors;
			this.heating = heating;
			this.rooms = rooms;
		}

		// TODO: add the optional facilities in a builder design
		public HouseBuilder poolType(String poolType) {
			this.poolType = poolType;
			return this;
		}

		public HouseBuilder energySupplier(String energySupplier) {
			this.energySupplier = energySupplier;
			return this;
		}

		public HouseBuilder securitySystem(String securitySystem) {
			this.securitySystem = securitySystem;
			return this;
		}

		public HouseBuilder acBrand(String acBrand) {
			this.acBrand = acBrand;
			return this;
		}

		// TODO: complete the final build method
		public House build() {
			return new House(this);
		}

		// TODO: test functionality in a Main class
	}
}
