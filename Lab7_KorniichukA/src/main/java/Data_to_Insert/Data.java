package Data_to_Insert;

public class Data {
    private String name;
    private String City;
    private String PhoneNumb;
    private String Email;

    public Data() {
        this.name = "Byon BackHyun";
        this.City = "Київ";
        this.PhoneNumb = "0975554798";
        this.Email = "I_love_exo@gmail.com";
    }

    public String get_Name_Surname() {
        return name;
    }

    public String getCity() {
        return City;
    }

    public String getPhone() {
        return PhoneNumb;
    }

    public String getEmail() {
        return Email;
    }
}