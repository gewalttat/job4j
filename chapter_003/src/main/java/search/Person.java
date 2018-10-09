package search;

public class Person {
    private String name;
    private String surname;
    private String adress;
    private String phone;

    public Person(String name, String surname, String phone, String adress) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("%s, %s, %s", getAdress(), getName(), getPhone(), getSurname());
    }
}

