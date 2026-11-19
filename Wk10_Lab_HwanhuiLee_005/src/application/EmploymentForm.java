package application;

import java.time.LocalDate;

public class EmploymentForm {
	private String fullName;
	private String currentAddress;
	private String contact;
	private String email;
	private String attainment;
	private String gender;
	private LocalDate dateAvailable;
	private String desiredPosition;
	private String desiredSalary;
	private boolean AuthorizedToWork;
	private boolean RelativesWorking;
	private String further;
	
	public EmploymentForm(String fullName, String currentAddress, String contact, String email, String attainment,
			String gender, LocalDate dateAvailable, String desiredPosition, String desiredSalary,
			boolean authorizedToWork, boolean relativesWorking, String further) {
		super();
		this.fullName = fullName;
		this.currentAddress = currentAddress;
		this.contact = contact;
		this.email = email;
		this.attainment = attainment;
		this.gender = gender;
		this.dateAvailable = dateAvailable;
		this.desiredPosition = desiredPosition;
		this.desiredSalary = desiredSalary;
		AuthorizedToWork = authorizedToWork;
		RelativesWorking = relativesWorking;
		this.further = further;
	}
	
	public String getFullName() {
		return fullName;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public String getContact() {
		return contact;
	}
	public String getEmail() {
		return email;
	}
	public String getAttainment() {
		return attainment;
	}
	public String getGender() {
		return gender;
	}
	public LocalDate getDateAvailable() {
		return dateAvailable;
	}
	public String getDesiredPosition() {
		return desiredPosition;
	}
	public String getDesiredSalary() {
		return desiredSalary;
	}
	public boolean isAuthorizedToWork() {
		return AuthorizedToWork;
	}
	public boolean isRelativesWorking() {
		return RelativesWorking;
	}
	public String getFurther() {
		return further;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAttainment(String attainment) {
		this.attainment = attainment;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDateAvailable(LocalDate dateAvailable) {
		this.dateAvailable = dateAvailable;
	}
	public void setDesiredPosition(String desiredPosition) {
		this.desiredPosition = desiredPosition;
	}
	public void setDesiredSalary(String desiredSalary) {
		this.desiredSalary = desiredSalary;
	}
	public void setAuthorizedToWork(boolean authorizedToWork) {
		AuthorizedToWork = authorizedToWork;
	}
	public void setRelativesWorking(boolean relativesWorking) {
		RelativesWorking = relativesWorking;
	}
	public void setFurther(String further) {
		this.further = further;
	}
	
	
	
}
