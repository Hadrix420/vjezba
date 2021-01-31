package zadaca1;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        PersonChecker personChecker = new PersonChecker();
        RandomUtilGap gap = new RandomUtilGap();
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.getAll();
        for (Person p : personList) {
            System.out.println(p);
        }
        gap.Gap();
        Set<Person> personListNoDupes = new LinkedHashSet<>(personList);
        for (Person p : personListNoDupes) {
            System.out.println(p);
        }
        gap.Gap();
        Set<Person> personListSorted = new TreeSet<>(personList);
        for (Person p : personListSorted) {
            System.out.println(p);
        }
        personChecker.setSurnameSearch(true);
        personChecker.setNameOrSurnameForTest("Benjamin");
        gap.Gap();

    }
}
