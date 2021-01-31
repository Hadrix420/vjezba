package zadaca1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PersonChecker personChecker = new PersonChecker();
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.getAll();
        for (Person p : personList) {
            System.out.println(p);
        }
        RandomUtilGap.Gap();
        Set<Person> personListNoDupes = new LinkedHashSet<>(personList);
        for (Person p : personListNoDupes) {
            System.out.println(p);
        }
        RandomUtilGap.Gap();
        Set<Person> personListSorted = new TreeSet<>(personList);
        for (Person p : personListSorted) {
            System.out.println(p);
        }
        personChecker.setSurnameSearch(true);
        personChecker.setNameOrSurnameForTest("Benjamin");
        RandomUtilGap.Gap();

    }
}
