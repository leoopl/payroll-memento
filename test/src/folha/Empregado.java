package folha;

import org.joda.time.DateTime;

public class Empregado {
	private String name;
	private String address;
	private String type;
	private int ID;
	private String paymentMethod;
	private boolean syndicate;
	private double syndicateTax;
	private int syndicateID;
	private double syndicateService;
	private double salary;
	private int hours;
	private DateTime starDate;

	
	public Empregado() {
		DateTime startDate = new DateTime();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setType(int type) {
		if (type == 0) {
			this.type = "Hourly";
		} else if (type == 1) {
			this.type = "Salaried";
		} else if (type == 2) {
			this.type = "Commissioned";
		}
	}

	public String getType() {
		return type;
	}

	public void setPaymentMethod(int paymentMethod) {
		if (paymentMethod == 0) {
			this.paymentMethod = "Check payment by the post office";
		} else if (paymentMethod == 1) {
			this.paymentMethod = "Check payment in hands";
		} else if (paymentMethod == 2) {
			this.paymentMethod = "Bank deposit";
		}
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setSyndicateID(int syndicateID) {
		this.syndicateID = syndicateID;
	}

	public int getSyndicateID() {
		return syndicateID;
	}

	public boolean getSyndicate() {
		return syndicate;
	}

	public void setSyndicate(boolean syndicate) {
		this.syndicate = syndicate;
	}

	public double getSyndicateTax() {
		return syndicateTax;
	}

	public void setSyndicateTax(double syndicateTax) {
		this.syndicateTax = syndicateTax;
	}

	public double getSyndicateService() {
		return syndicateService;
	}

	public void setSyndicateService(int syndicateService) {
		this.syndicateService = syndicateService;
	}

	public double getSalary() {// sem taxa de sindicato
		if (type.equals("Hourly")) {
			if (hours > 8) {
				int mult = hours - 8;
				return salary + mult * (1.5 * salary);
			} else {
				return salary;
			}
		} else if (type.equals("Commissioned")) {
			return salary;// falta comissão
		} else {
			return salary;
		}
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void getStatus() {
		System.out.println("ID: " + getID());
		System.out.println("Name: " + getName());
		System.out.println("Address: " + getAddress());
		System.out.println("Salary: " + getSalary());
		System.out.println("Type: " + getType());
		System.out.println("Payment Method: " + getPaymentMethod());
		System.out.println("Syndicate: " + getSyndicate());
		System.out.println("Syndicate Tax: " + getSyndicateTax());
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Empregado [name=" + name + ", address=" + address + ", type=" + type + ", ID=" + ID + ", paymentMethod="
				+ paymentMethod + ", syndicate=" + syndicate + ", syndicateTax=" + syndicateTax + ", syndicateID="
				+ syndicateID + ", syndicateService=" + syndicateService + ", salary=" + salary + ", hours=" + hours
				+ "]";
	}
	
	
}
