public class ReverseString {

    public static void main(String [] args){
        String s = "IAmAtHomeNow";
        System.out.println(s);
        char ac[] = s.toCharArray();

        for (int i = 0; i < s.length() / 2; i++){
            char tmp = ac[i];
            ac[i] = ac[s.length()-i-1];
            ac[s.length()-i-1] = tmp;
        }

        System.out.println(new String(ac));
    }
}
