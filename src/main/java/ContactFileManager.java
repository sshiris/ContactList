import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.List;

import com.google.gson.Gson;

public class ContactFileManager {
    private static final String FILE_PATH = "contacts.json";
    private static final Gson gson = new Gson();

    public static void saveContactsToFile(List<Person> contacts) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(contacts, writer);
            System.out.println("Contacts saved to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> readContactsFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Person>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
