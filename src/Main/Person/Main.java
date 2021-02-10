package Main.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        PersonChecker personChecker = new PersonChecker();
        PersonDao personDao = new PersonDao();
    }
    public static void removeFromCollection(Collection<Person> personCollection,Predicate<Person> removalTest){
        personCollection.removeIf(removalTest);
    }
    public static void printTestedPersons(Collection<Person> personCollection, Predicate<Person> personPredicate){
        personCollection.stream().filter(personPredicate).forEach(System.out::println);
    }
    public static void printPersons(Collection<Person> personCollection){
        personCollection.forEach(System.out::println);
    }



}


