package com.amdocs.doctor.exception;

public class DoctorException extends Exception{
		public DoctorException(String s){
			super(s);
		}
		public DoctorException() {
			System.out.println("Doctor not available");
		}
}
