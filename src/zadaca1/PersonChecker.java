package zadaca1;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PersonChecker implements Predicate<Person> {
    int ageForTest;
    String nameOrSurnameForTest;
    LocalDate birthdayForTest;
    boolean higherThan;
    boolean isSurnameSearch;

    public PersonChecker() {

    }

    public PersonChecker(int ageForTest, boolean higherThan) {
        this.ageForTest = ageForTest;
        this.higherThan = higherThan;
    }

    public PersonChecker(String nameOrSurnameForTest, boolean isSurnameSearch) {
        this.nameOrSurnameForTest = nameOrSurnameForTest;
        this.isSurnameSearch = isSurnameSearch;
    }

    public PersonChecker(int dayOfBirthForTest, int monthOfBirthForTest, int yearOfBirthForTest) {
        this.birthdayForTest = LocalDate.of(yearOfBirthForTest, monthOfBirthForTest, dayOfBirthForTest);
    }

    public int getAgeForTest() {
        return ageForTest;
    }

    public void setAgeForTest(int ageForTest) {
        this.ageForTest = ageForTest;
    }

    public String getNameOrSurnameForTest() {
        return nameOrSurnameForTest;
    }

    public void setNameOrSurnameForTest(String nameOrSurnameForTest) {
        this.nameOrSurnameForTest = nameOrSurnameForTest;
    }

    public LocalDate getBithdayForTest() {
        return birthdayForTest;
    }

    public boolean isHigherThan() {
        return higherThan;
    }

    public void setHigherThan(boolean higherThan) {
        this.higherThan = higherThan;
    }

    public boolean isSurnameSearch() {
        return isSurnameSearch;
    }

    public void setSurnameSearch(boolean surnameSearch) {
        isSurnameSearch = surnameSearch;
    }

    public void setBithdayForTest(int dayOfBirthForTest, int monthOfBirthForTest, int yearOfBirthForTest) {
        this.birthdayForTest = LocalDate.of(yearOfBirthForTest, monthOfBirthForTest, dayOfBirthForTest);
    }

    @Override
    public boolean test(Person p) {
        if (ageForTest != 0 && higherThan) {
            return p.getAge() > ageForTest;
        }
        if (ageForTest != 0) {
            return p.getAge() < ageForTest;
        }
        if (nameOrSurnameForTest != null && !isSurnameSearch) {
            return p.getName().equals(nameOrSurnameForTest);
        }
        if (nameOrSurnameForTest != null) {
            return p.getSurname().equals(nameOrSurnameForTest);
        }
        if (!birthdayForTest.equals(LocalDate.of(0,0,0))||birthdayForTest!=null) {
            return p.getBirthday().equals(birthdayForTest);
        }
        setNameOrSurnameForTest(null);
        setAgeForTest(0);
        setBithdayForTest(0,0,0);
        return false;
    }
}
