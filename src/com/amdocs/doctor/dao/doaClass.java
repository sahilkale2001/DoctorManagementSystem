package com.amdocs.doctor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.doctor.doctor.*;

public class doaClass implements DoctorDaoInterface{
	ConnectionCode code=new ConnectionCode();
	PreparedStatement st;
	Statement stm;
	ResultSet rs;
	int r;
	
	public int addDoctor(Doctor obj) {
		
		obj.getDoctorName();
		obj.getMobileNumber();
		obj.getSpecialization();
		obj.getAvailableShift();
		obj.getFees();
		try {
			st=code.con.prepareStatement("insert into doctor values (seqname.nextval,?,?,?,?,?) ");
			
			st.setString(1,obj.getDoctorName());
			st.setString(2, obj.getMobileNumber());
			st.setString(3,obj.getSpecialization());
			st.setString(4,obj.getAvailableShift());
			st.setDouble(5,obj.getFees());
			r=st.executeUpdate();
			return r;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	} 
	
	public boolean updateDoctorFees(int Id,double f) {
		try {
			
			st=code.con.prepareStatement("update doctor set FEES=? where DID=?");
			st.setDouble(1, f);
			st.setInt(2, Id);
			
			r=st.executeUpdate();
			if(r!=0) return true;
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public List<Doctor> showAllDoctors() {
		List<Doctor> arr=new ArrayList<>();
		try {
			stm= code.con.createStatement();
			rs=stm.executeQuery("SELECT * FROM doctor");
			
			while(rs.next()) {
				Doctor ojt=new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
				
				arr.add(ojt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public int deleteDoctor(int ID) {
		try {
			st=code.con.prepareStatement("Delete from doctor where DID=?");
			st.setInt(1, ID);
			r=st.executeUpdate();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public List<Doctor> searchByFeesAndShift(String shift) {
		List<Doctor> arr=new ArrayList<>();
		try {
			st= code.con.prepareStatement("select * from doctor where fees < (Select min(fees) from doctor where availableshift like ?)");
			st.setString(1, shift);
			rs=st.executeQuery();
			
			while(rs.next()) {
				Doctor ojt=new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
				arr.add(ojt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public List<Doctor> searchBySpecialization(String special){
		List<Doctor> arr = new ArrayList<>();;
		try {
			
			st= code.con.prepareStatement("SELECT * FROM doctor where specialization like ? ");
			st.setString(1, special);
			rs=st.executeQuery();
			
			while(rs.next()) {
				Doctor ojt=new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
				arr.add(ojt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
	}
	
	public int CountDoctorsByShift(String shift) {
		ArrayList<String> arr=new ArrayList<String>();
		try {
			st= code.con.prepareStatement("SELECT * FROM doctor where availableshift like ? ");
			st.setString(1, shift);
			rs=st.executeQuery();
			
			while(rs.next()) {
				arr.add(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getDouble(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr.size();
	}


	}
	
