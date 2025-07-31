import java.util.ArrayList;
import java.util.Scanner;

// Contact class to represent a contact with name, phone number, and email
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor to initialize contact
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter methods for name, phone number, and email
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods for phone number and email
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class ContactManager {
    private ArrayList<Contact> contacts; // ArrayList to store contacts
    private Scanner scanner; // Scanner object for user input

    // Constructor to initialize ArrayList and Scanner
    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new contact
    public void addContact() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Method to view all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println("-----------------------");
            }
        }
    }

    // Method to update an existing contact
    public void updateContact() {
        System.out.println("Enter name of contact to update:");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Enter new phone number:");
                String phoneNumber = scanner.nextLine();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("Enter new email:");
                String email = scanner.nextLine();
                contact.setEmail(email);
                System.out.println("Contact updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Method to delete an existing contact
    public void deleteContact() {
        System.out.println("Enter name of contact to delete:");
        String name = scanner.nextLine();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Main method to run the contact management system
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager(); // Create ContactManager object
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Main loop to display menu and perform operations
        while (isRunning) {
            System.out.println("Choose operation:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    contactManager.addContact();
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    contactManager.updateContact();
                    break;
                case 4:
                    contactManager.deleteContact();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close(); // Close Scanner object
    }
}
