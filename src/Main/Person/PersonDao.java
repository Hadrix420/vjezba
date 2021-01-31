package Main.Person;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonDao {
    /*
    This is my first DAO class. It Reads a file which gets parsed through a scanner that goes through each line of the file and adds the
    contents of each line to a separate String entry in a list called rawPersonData. The raw data then passes through a foreach loop that
    separates the lines into readable String arrays. The for loop then tries to add a person with the parameters from the list. If it
    fails there is a catch loop that does nothing, the point of this is skipping invalid entries(badly formatted entries) in the input,
    which is in this case person.txt.
     */
    public List<Person> getAll() {
        List<String> rawPersonData = new ArrayList<>();
        try (FileReader fr = new FileReader("person.txt");
             Scanner sc = new Scanner(fr)) {
            while (sc.hasNextLine()) {
                String rawData = sc.nextLine();
                if (!rawData.equals("")) {
                    rawPersonData.add(rawData);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Person> personList = new ArrayList<>();
        int forlooptrack = 0;
        for (String line : rawPersonData) {
            forlooptrack++;
            String[] input = line.split(";");
            String[] dateInput = line.split("-");
            String[] dateInputInt = dateInput[0].split(";");
            try {
                personList.add(new Person(input[0], input[1], Integer.parseInt(dateInputInt[2]), Integer.parseInt(dateInput[1]), Integer.parseInt(dateInput[2])));
            } catch (RuntimeException e) {
                String message = "Error on line "+forlooptrack+". Please check formatting of desired .txt file containing personal information. " + "Error message: " + e.getMessage();
                JOptionPane.showMessageDialog(null,message,"Formatting error",JOptionPane.WARNING_MESSAGE);
            }
        }
        return personList;
    }
}
