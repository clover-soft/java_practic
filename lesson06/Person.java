package lesson06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Person {

    public String name;
    public String lastName;
    public Integer age;

    public enum genderTypes {
        MALE, FEMALE, UNKNOWN
    }

    public genderTypes gender;
    private String email;
    private String mobile;

    @Override
    public String toString() {
        List<String> objStr = new ArrayList<>();
        objStr.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        objStr.add(lastName.substring(0, 1).toUpperCase() + lastName.substring(1));
        objStr.add(String.format("[%s|%s]", age, gender));
        if (email != null) {
            objStr.add("email:" + email);
        }
        if (mobile != null) {
            objStr.add("mob:" + mobile);
        }
        return String.join(" ", objStr);

    }

    /**
     * Функция возвращает объект результата слияния экземпляра класса Person
     * с входящим объектом Person либо просто объект
     * если он не подходит для слияния
     * 
     * @param obj Входящий объект для слияния двух экземлпяров класса Person
     * @return Person или любой непригодный к слиянию объект
     */
    public Object merge(Object obj) {
        if (equals(obj)) {
            Person anotherPerson = (Person) obj;
            if (anotherPerson.name == null && name != null)
                anotherPerson.name = name;
            if (anotherPerson.lastName == null && lastName != null)
                anotherPerson.lastName = lastName;
            if (anotherPerson.age == null && age != null)
                anotherPerson.age = age;
            if (anotherPerson.gender == genderTypes.UNKNOWN && gender != genderTypes.UNKNOWN)
                anotherPerson.gender = gender;
            if (anotherPerson.email == null && email != null)
                anotherPerson.email = email;
            if (anotherPerson.mobile == null && mobile != null)
                anotherPerson.mobile = mobile;
            return anotherPerson;
        }
        return obj;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person anotherPerson = (Person) obj;
        if (anotherPerson.getEmail() != null && email != null && anotherPerson.getEmail().equals(email))
            return true;
        if (anotherPerson.getMobile() != null && mobile != null && anotherPerson.getMobile().equals(email))
            return true;
        if (anotherPerson.getEmail() != null && anotherPerson.getMobile() != null) {
            return false;
        }
        // Здесь надо учитывать что некоторых экземпляров может отсутствовать гендер или
        // возраст, этот моент можно дополнительно проработать
        if ((anotherPerson.email == null && anotherPerson.mobile == null && anotherPerson.name.equals(name)
                && anotherPerson.lastName.equals(lastName) && anotherPerson.age.equals(age)
                && anotherPerson.gender.equals(gender))

        ) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (email != null) {
            return Objects.hash(email);
        }
        if (mobile != null) {
            return Objects.hash(mobile);
        }
        return Objects.hash(name, lastName, age, gender, mobile, email);
    }

    public void setMobile(String mobile) {
        mobile = mobile.replaceAll("[- \\(\\)]", "");
        Pattern p = Pattern.compile("^(8|\\+7)[9]{1}[0-9]{9}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(mobile);
        if (matcher.matches()) {
            mobile = mobile.replaceAll("^8", "+7");
            mobile = String.format("+7 (%s) %s-%s-%s", mobile.substring(2, 5), mobile.substring(5, 8),
                    mobile.substring(8, 10), mobile.substring(10, 12));
            this.mobile = mobile;
        } else
            throw new IllegalArgumentException("Wrong mobile phone");

    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(email);
        if (matcher.matches()) {
            this.email = email.toLowerCase();
        } else {
            throw new IllegalArgumentException("Wrong email");
        }
    }

    public String getEmail() {
        return email;
    }

    public Person(String name, String lastName, Integer age, genderTypes gender, String email, String mobile) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        if (email != null)
            setEmail(email);
        if (mobile != null)
            setMobile(mobile);
    }

}
