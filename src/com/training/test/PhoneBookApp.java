package com.training.test;
import java.util.*;

import com.training.model.Contact;
import com.training.services.PhoneBook;
//import com.training.services.PhoneBook;


public class PhoneBookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook phoneBook = new PhoneBook();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		while(running) {
			System.out.println("Phone Book menu: ");
			System.out.println("1. Add a contact");
			System.out.println("2. Remove a contact");
			System.out.println("3. Search a contact");
			System.out.println("4. Display all contacts");
			System.out.println("5. Exit");
			System.out.println("");
			System.out.println("Enter your choice: ");
			int choice ;
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("Invalid input!! please enter a number.");
				continue;
			}
			
			switch (choice) {
			case 1: 
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				System.out.println("Enter phone number: ");
				String phoneNumber = sc.nextLine();
				if(isValidContactData(name,phoneNumber, phoneBook)) {
					phoneBook.addContact(new Contact(name,phoneNumber));
				}
				break;
			case 2:
				System.out.println("Enter name to remove: ");
				String removeName = sc.nextLine();
				phoneBook.removeContact(removeName);
				break;
			case 3:
				System.out.println("Enter name to search: ");
				String searchName = sc.nextLine();
				Contact contact = phoneBook.searchContact(searchName);
				if(contact != null) {
					System.out.println("Contact found. name: "+contact.getName()+" phone number: "+contact.getPhoneNumber());
				
				}else {
					System.out.println("Contact not found with name "+searchName);
				}
				break;
			case 4:
				phoneBook.listContacts();
				break;
			case 5:
				running = false;
				System.out.println("Thankyou for using phoneBook.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		
		
	}

	private static boolean isValidContactData(String name, String number, PhoneBook phoneBook) {
		if(name.isEmpty()) {
			System.out.println("Name cannot be empty");
			return false;
		}
		if (!isValidPhoneNumber(number)) {
			System.out.println("invalid phone number format!");
			return false;
		}
		if(phoneBook.searchContact(name) != null) {
			System.out.println("Contact with the same name already exists.");
			return false;
		}
		return true;
	}
	
	private static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("(0|91)?[6-9]\\d{9}");
	}
	
}
