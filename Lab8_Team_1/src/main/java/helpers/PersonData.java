package helpers;

public class PersonData {
    private String nameAndSurname;
    private String city;
    private String phone;
    private String email;

    public PersonData() {
        this.nameAndSurname = "Гришко Олег";
        this.city = "Київ";
        this.phone = "0939577862";
        this.email = "chupakabara@ukr.net";
    }

    public PersonData(String nameAndSurname, String city, String phone, String email) {
        this.nameAndSurname = nameAndSurname;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
