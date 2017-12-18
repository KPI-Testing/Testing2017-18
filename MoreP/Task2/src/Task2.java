public class Task2 {
    public static String DelDubl(String input){
        String temp = input.toLowerCase();
        StringBuilder StrTemp = new StringBuilder();
        char TempCh = temp.charAt(0);
        StrTemp.append(TempCh);

        for (int i = 1; i < temp.length(); i++){
            if (TempCh != temp.charAt(i)){
                StrTemp.append(temp.charAt(i));
                TempCh = temp.charAt(i);
            }


        }
        return StrTemp.toString();

    }
    public static void main(String[] args) {
        String Input = "aa dsv 111 gdvvv222";
        String Result = DelDubl(Input);
        System.out.println(Result);


    }
}
