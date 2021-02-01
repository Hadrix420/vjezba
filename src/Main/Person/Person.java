package Main.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private String surname;
    LocalDate birthday;

    public Person(String nameInput, String surnameInput, int birthYearInput, int birthMonthInput, int birthDayOfMonthInput) {
        this.name = nameInput;
        this.surname = surnameInput;
        this.birthday = LocalDate.of(birthYearInput, birthMonthInput, birthDayOfMonthInput);
    }

    public String toString() {
        return "Ime: " + this.name + "\nPrezime: " + this.surname + "\nRodjendan: " + this.birthday + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;
        Person comparedPerson = (Person) o;
        return name.equals(comparedPerson.name) && surname.equals(comparedPerson.surname) && birthday.equals(comparedPerson.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthYearInput, int birthMonthInput, int birthDayOfMonthInput) {
        this.birthday = LocalDate.of(birthYearInput, birthMonthInput, birthDayOfMonthInput);
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period gap = birthday.until(now);
        return gap.getYears();
    }

    public void setAge() {
        System.out.println("Can't do that : ^ )");
    }

    @Override
    public int compareTo(Person p) {
        int result = name.compareTo(p.getName());
        if (result == 0) {
            result = surname.compareTo(p.getSurname());
        }
        if (result == 0) {
            result = birthday.compareTo(p.getBirthday());
        }
        return result;
    }
}

