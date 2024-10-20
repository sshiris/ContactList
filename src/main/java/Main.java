import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);

        // add contacts
        Person person1 = new Person("iris fan", "iris@example.com", "123456789", "123 Elm St", 30);
        Person person2 = new Person("John Snow", "snow@example.com", "123456789", "snow St", 30);
        contactList.addContact(person1);
        contactList.addContact(person2);

        // save contacts to file
        ContactFileManager.saveContactsToFile(contactList.getContacts());

        // Load from file
        List<Person> loadedContact = ContactFileManager.readContactsFromFile();
        if (loadedContact != null) {
            for (Person person : loadedContact) {
                System.out.println(person);
            }
        }

        // print contacts
        contactList.printContacts();

        // search contacts by name
        System.out.println("Search by Name: ");
        String name = scanner.nextLine();
        List<Person> result = contactList.searchByName(name);
        if (!result.isEmpty()) {
            for (Person person : result) {
                System.out.println(person);
            }
        } else {
            System.out.println("No contacts found with name: " + name);
        }

        scanner.close();
    }
}