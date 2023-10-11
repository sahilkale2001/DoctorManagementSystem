package com.amdocs.doctor.doctor;

public class Doctor{
	private int doctorId;
	private String doctorName;
	private String mobileNumber;
	private String specialization;
	private String availableShift;
	private double fees;
	
	public Doctor( int doctorId,String doctorName, String mobileNumber,String specialization, String availableShift, double fees) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.mobileNumber = mobileNumber;
		this.specialization=specialization;
		this.availableShift = availableShift;
		this.fees = fees;
	}
	
	public Doctor(String doctorName, String mobileNumber, String specialization, String availableShift, double fees) {
		super();
		this.doctorName = doctorName;
		this.mobileNumber = mobileNumber;
		this.specialization = specialization;
		this.availableShift = availableShift;
		this.fees = fees;
	}

	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAvailableShift() {
		return availableShift;
	}
	public void setAvailableShift(String availableShift) {
		this.availableShift = availableShift;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", mobileNumber=" + mobileNumber
				+ ", specialization=" + specialization + ", availableShift=" + availableShift + ", fees=" + fees + "]";
	}
	

	
}
