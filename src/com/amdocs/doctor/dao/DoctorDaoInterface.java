package com.amdocs.doctor.dao;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.doctor.doctor.Doctor;

interface DoctorDaoInterface {
	int addDoctor(Doctor obj);
	boolean updateDoctorFees(int Id,double f);
	List<Doctor> showAllDoctors() ;
	int deleteDoctor(int ID);
	List<Doctor> searchByFeesAndShift(String shift);
	List<Doctor> searchBySpecialization(String special);
	int CountDoctorsByShift(String shift);
	
}
