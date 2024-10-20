
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactList {
    private List<Person> contacts;

    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public List<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person person) {
        contacts.add(person);
        System.out.println("Contact added: " + person.getName());
    }

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Person person : contacts) {
                System.out.println(person);
            }
        }
    }

    public List<Person> searchByName(String name) {
        return contacts.stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

    }

    public List<Person> searchByEmail(String email) {
        return contacts.stream()
                .filter(person -> person.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    public List<Person> searchByPhone(String phone) {
        return contacts.stream()
                .filter(person -> person.getPhone().equalsIgnoreCase(phone))
                .collect(Collectors.toList());
    }
}
