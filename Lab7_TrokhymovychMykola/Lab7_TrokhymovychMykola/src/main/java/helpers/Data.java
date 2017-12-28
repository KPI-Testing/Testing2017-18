package helpers;

public class Data {
    private String nameAndSurname;
    private String city;
    private String phone;
    private String email;

    public Data() {
        this.nameAndSurname = "Galina Blanka";
        this.city = "Київ";
        this.phone = "0987654328";
        this.email = "Rebnock_pens_thebest@ukr.net";
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
