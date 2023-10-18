package com.training.services;
import java.util.TreeMap;

import com.training.model.Contact;

public class PhoneBook {
	private TreeMap<String, Contact> contactMap = new TreeMap<>();
	
	public void addContact(Contact contact) {
		if (isContactValid(contact)) {
			contactMap.put(contact.getName(), contact);
			System.out.println("Contact added: " + contact.getName()+ " - "+ contact.getPhoneNumber());
		}else {
			System.out.println("Invalid Contact data. Please try again.");

		}
	}
	
	
	public Contact searchContact(String name) {
		return contactMap.get(name);
	}
	
	
	public void removeContact(String name) {
		if (contactMap.containsKey(name)) {
			contactMap.remove(name);
			System.out.println("Contact removed.");
		}else {
			System.out.println("Contact not found.");

		}
	}
	
	
	public void listContacts() {
		System.out.println("PhoneBook contacts: ");
		for (Contact contact : contactMap.values()) {
			System.out.println(contact);
		}

	}
	
	public TreeMap<String, Contact> getContactMap() {
		return contactMap;
	}


	public void setContactMap(TreeMap<String, Contact> contactMap) {
		this.contactMap = contactMap;
	}


	private boolean isContactValid(Contact contact) {
		return !contact.getName().isEmpty() && isValidPhoneNumber(contact.getPhoneNumber()) &&
				!contactMap.containsKey(contact.getName());
	}
	private boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("(0|9)?[6-9]\\d{9}");
	}
	
}
