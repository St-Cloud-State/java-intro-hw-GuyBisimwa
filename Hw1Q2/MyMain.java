
import java.io.*;
import java.util.LinkedList;

public class MyMain {

    // store method
    public static void store(InputStream inputStream, LinkedList<Person> linkedList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) {
                String firstName = data[0].trim();
                String lastName = data[1].trim();
                String id = data[2].trim();
                linkedList.add(new Person(firstName, lastName, id));
            }
        }
    }

    // display method
    public static void display(PrintStream outputStream, LinkedList<Person> linkedList) {
        for (Person person : linkedList) {
            outputStream.println(person.toString());
        }
    }

    // find method
    public static int find(String sid, LinkedList<Person> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1; // if not found
    }

    // main method
    public static void main(String[] args) {
        LinkedList<Person> linkedList = new LinkedList<>();

        // Reading from a data file
        try (InputStream inputStream = MyMain.class.getClassLoader().getResourceAsStream("data.txt")) {
            if (inputStream == null) {
                System.out.println("File not found!");
            } else {
                store(inputStream, linkedList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Displaying the list of persons
        display(System.out, linkedList);

        // Finding a person by id
        String[] idsToFind = { "123", "456", "789" };
        for (String id : idsToFind) {
            int index = find(id, linkedList);
            if (index != -1) {
                System.out.println("Person with id " + id + " found at index: " + index);
            } else {
                System.out.println("Person with id " + id + " not found.");
            }
        }
    }
}
