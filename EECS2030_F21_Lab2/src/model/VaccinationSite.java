package model;

public class VaccinationSite {
	private VaccineDistribution[] distrib = new VaccineDistribution[0];
	private String status = "";
	private String name = "";

	private int maxAdded = 0;
	private int numOfAppBooked = 0;

	private HealthRecord[] booking = new HealthRecord[0];

	public VaccinationSite(String name, int maxAdded) {
		this.maxAdded = maxAdded;
		this.name = name;
		status = name + " has 0 available doses: <>";
	}

	public int getNumberOfAvailableDoses() {
		int doses = 0;
		for (int i = 0; i < distrib.length; i++) {
			doses += distrib[i].getDoses();
		}
		return doses;
	}

	public int getNumberOfAvailableDoses(String code) {
		int doses = 0;
		boolean isCode = false;
		for (int i = 0; i < distrib.length; i++) {
			if (distrib[i].getCode().equals(code)) {
				doses = distrib[i].getDoses();
				isCode = true;
				break;
			}

		}

		return doses;
	}

	public String toString() {
		return this.status;
	}

	public void addDistribution(Vaccine v1, int doses)
			throws TooMuchDistributionException, UnrecognizedVaccineCodeNameException {
		boolean isVaccine = false;

		String status2 = "";

		if (!v1.checkValid()) {
			throw new UnrecognizedVaccineCodeNameException("");
		}
		if (getNumberOfAvailableDoses() + doses > maxAdded) {
			throw new TooMuchDistributionException("val ");
		}

		if (distrib.length == 0 && v1.checkValid() && getNumberOfAvailableDoses() + doses <= this.maxAdded) {
			VaccineDistribution distrib1 = new VaccineDistribution(v1, doses);
			distrib = new VaccineDistribution[1];
			distrib[0] = distrib1;
			status = name + " has " + getNumberOfAvailableDoses() + " available doses: <" + distrib[0].getDoses()
					+ " doses of " + distrib[0].getManufacturer() + ">";
		}

		else if (getNumberOfAvailableDoses() + doses <= this.maxAdded && v1.checkValid()) {
			for (int i = 0; i < distrib.length; i++) {
				if (distrib[i].getManufacturer().equals(v1.getManufacturer())) {
					distrib[i].addDose(doses);
					isVaccine = true;
					break;
				}
			}
			if (isVaccine == false && v1.checkValid()) {
				VaccineDistribution distrib1 = new VaccineDistribution(v1, doses);
				VaccineDistribution[] temp = distrib;
				distrib = new VaccineDistribution[distrib.length + 1];
				for (int i = 0; i < temp.length; i++) {
					distrib[i] = temp[i];
					status2 += temp[i].getDoses() + " doses of " + temp[i].getManufacturer() + ", ";

				}
				distrib[distrib.length - 1] = distrib1;
				status = name + " has " + getNumberOfAvailableDoses() + " available doses: <" + status2
						+ distrib[distrib.length - 1].getDoses() + " doses of "
						+ distrib[distrib.length - 1].getManufacturer() + ">";

			}
			if (isVaccine) {
				for (int i = 0; i < distrib.length; i++) {
					status2 += distrib[i].getDoses() + " doses of " + distrib[i].getManufacturer();
					if (i < distrib.length - 1) {
						status2 += ", ";
					}
				}
				status = name + " has " + getNumberOfAvailableDoses() + " available doses: <" + status2 + ">";
			}
		}

	}

	public void bookAppointment(HealthRecord person) throws InsufficientVaccineDosesException {
		if (booking.length < getNumberOfAvailableDoses()&&numOfAppBooked<201) {
			person.setAppointmentStatus(name, "pass");

			if (booking.length == 0) {
				booking = new HealthRecord[1];
				booking[0] = person;
				numOfAppBooked++;
			} else {
				HealthRecord[] temp = booking;
				booking = new HealthRecord[booking.length + 1];
				for (int i = 0; i < temp.length; i++) {
					booking[i] = temp[i];
				}
				booking[booking.length - 1] = person;
				numOfAppBooked++;
			}

		} else {
			person.setAppointmentStatus(name, "fail");
			throw new InsufficientVaccineDosesException();

		}

	}

	public void administer(String date) {
		String status2="";
		for(int i =0;i <booking.length;i++) {
			Vaccine vaccine= getVaccine();
			booking[i].addRecord(vaccine, name, date);
			
		}
		booking=new HealthRecord[0];
		for(int j=0; j <distrib.length;j++) {
			status2=status2 += distrib[j].getDoses() + " doses of " + distrib[j].getManufacturer();
			if (j < distrib.length - 1) {
				status2 += ", ";
				
			}
			status = name + " has " + getNumberOfAvailableDoses() + " available doses: <" + status2 + ">";
		}

	}
	
	public Vaccine getVaccine() {
		int index=-1;
		for(int i =0; i <distrib.length;i++) {
			if(distrib[i].getDoses()>0) {
				index=i;
				distrib[i].remDose();
				break;
			}
		}
		
		return distrib[index].getVaccine();
		
	}

}
