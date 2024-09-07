package Hw1Q3;


import java.io.*;

public class MyMain {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        // Specify the full path to the data.txt file
        try (InputStream inputStream = MyMain.class.getClassLoader().getResourceAsStream("data.txt")) {
            personList.store(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Displaying the list of persons
        personList.display(System.out);

        // Finding a person by id
        String[] idsToFind = {"123", "456", "789"};
        for (String id : idsToFind) {
            int index = personList.find(id);
            if (index != -1) {
                System.out.println("Person with id " + id + " found at index: " + index);
            } else {
                System.out.println("Person with id " + id + " not found.");
            }
        }
    }
}

