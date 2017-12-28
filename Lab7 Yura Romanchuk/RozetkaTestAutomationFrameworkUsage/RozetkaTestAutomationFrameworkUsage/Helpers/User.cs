namespace RozetkaTestAutomationFrameworkUsage.Helpers
{
    public class User
    {
        private string name;
        private string numberphone;
        private string email;

        public User()
        {
            name = "Юра";
            numberphone = "0931873395";
            email = "kartofka@ukr.net";         
        }

        public User(string name,string numberphone,string email)
        {
            this.name = name;
            this.numberphone = numberphone;
            this.email = email;
        }

        public string getname()
        {
            return name;
        }

        public string getphone()
        {
            return numberphone;
        }

        public string getemail()
        {
            return email;
        }
    }
}
