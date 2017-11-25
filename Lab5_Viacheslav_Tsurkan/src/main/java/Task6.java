public class Task6 {
    static void rever(){

        System.out.println(revers("«йцукенгшщзх»"));
    }

    private static String revers(String s) {


        char[] charArray = s.toCharArray();
        char[] charArray2 = new  char[charArray.length];
        for (int i = 0; i<charArray.length; i++){
            charArray2[charArray.length-i-1]=charArray[i];
        }

        s = new String(charArray2);

        return s;
    }
}
