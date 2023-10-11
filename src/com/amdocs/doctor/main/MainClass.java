package com.amdocs.doctor.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amdocs.doctor.dao.doaClass;
import com.amdocs.doctor.doctor.*;
import com.amdocs.doctor.exception.DoctorException;

public class MainClass {
		static Scanner sc=new Scanner(System.in);
		static int DId;
		static String doctorName;
		static String mobileNumber;
		static String availableShift;
		static double fees;
		static String specialization;
		static doaClass obj1=new doaClass();
		static ArrayList<String> arr=new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.println("--------------------------------------------------------");
				
				System.out.println("Enter a number to Select operation to perform");
				System.out.println("1. Add new doctor \n2. Update doctor fees "
						+ "\n3. Delete doctor "
						+ "\n4. View all doctors "
						+ "\n5.Find doctor by specialization "
						+ "\n6.Find doctor's fees is less than all doctors of given shift "
						+ "\n7.Count number of doctors by shift "
						+ "\n8.Exit");
				System.out.println("--------------------------------------------------------");
				Doctor obj;
				int inputByUser=sc.nextInt();
				
				try {
					
					switch(inputByUser ){
					case 1: {try {
						System.out.println("--------------------------------------------------------");
								
								System.out.println("doctorName");
								doctorName=sc.next();
								
								mobileNumber= getValidMobileNumber();
								
								System.out.println("specilazation");
								specialization=sc.next().toLowerCase();
								
								availableShift=isStringAvailableShiftValid();
								fees=onlyEnterValidFees();
								
								obj=new Doctor(doctorName,mobileNumber,specialization.toLowerCase(),availableShift,fees);
								int x=obj1.addDoctor(obj);
								if(x!=0) {
									System.out.println("One Doctor Info is added");
								}else {
									System.out.println("Details entered are wrong/invalid");
								}
					} catch (Exception e) {
						System.out.println(e);
						return;
					}
						}
					System.out.println("--------------------------------------------------------");
						break;
						
					case 2: {
							try {
								System.out.println("--------------------------------------------------------");
								System.out.println("Select IDno to Update Doctor fees");
								List<Doctor> arr=obj1.showAllDoctors();
								for(Doctor arr1:arr) {
								System.out.println(arr1.toString());
								}
								System.out.println("--------------------------------------------------------");
								System.out.println("Enter Idno and Fees to be updated ");
								DId=getValidIdOfDoctor();
								fees=onlyEnterValidFees();
								boolean x=obj1.updateDoctorFees(DId,fees);
								if(x==true) {
									System.out.println("Fees are Updated");
								}else {
									System.out.println("Details entered are wrong/invalid");
								}
							} catch (Exception e) {
								System.out.println(e);
								}
							}
					
					System.out.println("--------------------------------------------------------");
						break;
					case 3:
						try {
							System.out.println("--------------------------------------------------------");
							System.out.println("Select IDno to Delete Doctor ");
							List<Doctor> arr=obj1.showAllDoctors();
							for(Doctor arr1:arr) {
							System.out.println(arr1.toString());
							}
							
							System.out.println("Enter Idno to delete Doctor detalis");
							
							int x=obj1.deleteDoctor(sc.nextInt());
							if(x!=0) {
								System.out.println("Deleted");
								
							}else {
								throw new DoctorException();
								
							}
						} catch (Exception e) {
							System.out.println(e);
						}
						System.out.println("--------------------------------------------------------");
							
						break;
					case 4:
						try {
							System.out.println("--------------------------------------------------------");
							List<Doctor> arr=obj1.showAllDoctors();
							for(Doctor arr1:arr) {
							System.out.println(arr1.toString());
							}
							if(arr.isEmpty()) throw new DoctorException();
							
						} catch (Exception e) {
							System.out.println(e);
						}
						System.out.println("--------------------------------------------------------");
						break;
					case 5:
						try {
							System.out.println("--------------------------------------------------------");
							System.out.println("Enter Specialization");
							String special=sc.next();
							List<Doctor>arr=obj1.searchBySpecialization(special.toLowerCase());
							for(Doctor arr1:arr) {
								System.out.println(arr1.toString());
								}
							if(arr.isEmpty()) throw new DoctorException();
							
						} catch (Exception e1) {
							System.out.println(e1);
						}
						System.out.println("--------------------------------------------------------");
						break;
					case 6:
						try {
							System.out.println("--------------------------------------------------------");
							availableShift= isStringAvailableShiftValid();
							List<Doctor >arr= obj1.searchByFeesAndShift(availableShift);
							for(Doctor arr1: arr) {
								System.out.println(arr1.toString());
							}
							if(arr.isEmpty()) throw new DoctorException();
							System.out.println("--------------------------------------------------------");
						} catch (Exception e) {
							//System.out.println(e);
						}
						break;
						
					case 7:
						try {
							System.out.println("--------------------------------------------------------");
							availableShift= isStringAvailableShiftValid();
							int count =obj1.CountDoctorsByShift(availableShift);
							System.out.println("The total number of doctor available: "+count );
							
							System.out.println("--------------------------------------------------------");
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 8:
						System.out.println("EXIT from Doctor's Management System");
						return;
						
					
						default:
							System.out.println("Invalid Input\n Try Again \n");
							main(args);
							
				
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	static int getValidIdOfDoctor() {
			while (true) {
			    try {
			        System.out.println("Enter Doctor's Id : ");
			        DId = sc.nextInt();
			        break; // Exit the loop if a valid value is entered
			    } catch (Exception e) {
			        System.out.println("Invalid Value. Please enter a valid numeric value.");
			        sc.nextLine(); // Clear the input buffer
			    }
			}
			
			return DId;
		}
	
	static String isStringAvailableShiftValid() {
			
			int c = 1; // Initialize c to 1 to enter the loop
			while (c == 1) {
			    System.out.println("Enter availableShift for morning (m) or evening (e):");
			    availableShift = sc.next();

			    if (availableShift.equals("m") || availableShift.equals("e")) {
			        c = 0; // Valid input, exit the loop
			    } else {
			        try {
			            throw new DoctorException(availableShift);
			        } catch (DoctorException e) {
			            System.out.println("Invalid availableShift: " + e.getMessage());
			        }
			    }
			}
			return availableShift;
		}
		
	static double onlyEnterValidFees() {
			while (true) {
			    try {
			        System.out.println("Enter fees:");
			        fees = sc.nextDouble();
			        break; // Exit the loop if a valid value is entered
			    } catch (Exception e) {
			        System.out.println("Invalid Value. Please enter a valid numeric value.");
			        sc.nextLine(); // Clear the input buffer
			    }
			}
			return fees;
		}
	 static String getValidMobileNumber() {
		 while (true) {
			    try {
			        System.out.println("Enter mobile number: ");
			        mobileNumber = sc.next();
			        
			        if (!mobileNumber.matches("\\d{10}")) {
			            throw new DoctorException("Invalid mobile number. It should be numeric and have 10 digits.");
			        }
			        
			        break; // Exit the loop if a valid mobile number is entered
			    } catch (DoctorException e) {
			        System.out.println(e.getMessage());
			    }
			}
		 return mobileNumber;
	 }
}
