//package com.training.services;
//
//
//
//import com.training.exception.InvalidNameException;
//import com.training.model.Contact;
//import com.training.services.*;
//
//public class Validator {
//	public void ValidName(String name) throws InvalidNameException {
//		if (name == null || name.trim().isEmpty()) {
//			throw new InvalidNameException("Name cannot be empty or and can have only one whitespace.");
//		}
//		if (name.matches("^[a-zA-Z]*$")){
//			throw new InvalidNameException("Name can only contain alphabets");
//		}
//		
//	}
//	
//	public static boolean isValidPhoneNumber(String phoneNumber) {
//		return phoneNumber.matches("(0|91)?[6-9]\\d{9}");
//	}
//	
//	private static boolean isContactValid(Contact contact) {
//		
//		return !contact.getName().isEmpty() && isValidPhoneNumber(contact.getPhoneNumber()) &&
//				!contactMap.getContactMap().containsKey(contact.getName());
//	}
//}
