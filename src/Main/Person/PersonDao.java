package Main.Person;

import java.sql.*;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Executor;

public class PersonDao {
    private String username;
    private String password;
    private String url;
    public Collection<Person> getAll() {
        Collection<Person> personCollection = new ArrayList<>();
        username="root";
        password="root";
        url="jdbc:mysql://localhost:3306/person";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            Statement stmt = connection.createStatement();
            ResultSet resSet = stmt.executeQuery("SELECT * FROM PERSON")) {
            while(resSet.next()){
                personCollection.add(new Person(resSet.getString(2),resSet.getString(3),resSet.getDate(4).toLocalDate(),resSet.getString(5).equalsIgnoreCase("male")? Gender.MALE:Gender.FEMALE));
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return personCollection;
    }

    public Person retrievePerson(int id){
        try(Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement prstmt = connection.prepareStatement("SELECT * FROM PERSON WHERE ID = ?")){
            prstmt.setInt(1,id);
            ResultSet resSet = prstmt.executeQuery();
            Person p = new Person();
            p.setBirthday(resSet.getDate("birthday").toLocalDate()).setName("name").setSurname("surname").setGender("male".equalsIgnoreCase(resSet.getString("gender"))? Gender.MALE : Gender.FEMALE);
            return p;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return new Person("INVALID","RETURN",0,0,0, Gender.MALE);
    }

}
