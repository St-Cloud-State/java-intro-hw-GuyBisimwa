package Hw1Q3;


import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> personList;

    public PersonList() {
        this.personList = new LinkedList<>();
    }

    // Store data into the linked list
    public void store(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) {
                String firstName = data[0].trim();
                String lastName = data[1].trim();
                String id = data[2].trim();
                personList.add(new Person(firstName, lastName, id));
            }
        }
    }

    // Display data from the linked list
    public void display(PrintStream outputStream) {
        for (Person person : personList) {
            outputStream.println(person.toString());
        }
    }

    // Find person by id in the linked list
    public int find(String sid) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
