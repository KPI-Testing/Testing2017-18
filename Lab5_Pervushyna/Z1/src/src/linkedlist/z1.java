package src.linkedlist;

import java.util.*;


public class z1 {

   public static long[] lll= new long[3] ;
   public static long[] all= new long[3];
   public static long[] hsl= new long[3];
   public static long[] tsl= new long[3];

    public static void Time (Collection<String> var, String st, long[] arr){

        long starttime;
        long endtime;



        starttime = System.nanoTime();
        var.add("Object");
        endtime = System.nanoTime();
        arr[0]=endtime-starttime;
        System.out.println("Adding element to the end of "+ st + ":    "+ arr[0] + " nanoseconds.");

        starttime = System.nanoTime();
        var.contains("Object");
        endtime = System.nanoTime();
        arr[1]=endtime-starttime;
        System.out.println("Checking for element in " +st+ ":   "+ arr[1] + " nanoseconds.");

        starttime = System.nanoTime();
        var.remove("Objt");
        endtime = System.nanoTime();
        arr[2]=endtime-starttime;
        System.out.println("Deleting middle element from" +st+ ": " + arr[2] + " nanoseconds.\n\n");




    }


    public static void main(String args[]) {
        LinkedList<String> ll = new LinkedList<>();
        ArrayList<String> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        TreeSet<String> ts = new TreeSet<>();




        Time((ll), "LinkedList",lll);


        Time((al), "ArrayList",all);


        Time((hs), "HashSet",hsl);


        Time((ts), "TreeSet",tsl);


        if (lll[0] < all[0] && lll[0]<hsl[0] && lll[0]<tsl[0]) {
            System.out.print("LinkesList adding element speed is the fastest\n\n");
        };
        if (lll[1] < all[1] && lll[1]<hsl[1] && lll[1]<tsl[1]) {
            System.out.print("LinkesList finding element speed is the fastest\n\n");
        };
        if (lll[2] < all[2] && lll[2]<hsl[2] && lll[2]<tsl[2]) {
            System.out.print("LinkesList deleting element speed is the fastest\n\n");
        };



        if (all[0] < lll[0]&&all[0]<tsl[0]&& all[0]<hsl[0]) {
            System.out.print("ArrayList adding element speed is the fastest\n\n");
        };
        if (all[1] < lll[1]&&all[1]<tsl[1]&& all[1]<hsl[1]) {
            System.out.print("ArrayList finding element speed is the fastest\n\n");
        };
        if (all[2] < lll[2]&&all[2]<tsl[2]&& all[2]<hsl[2]) {
            System.out.print("ArrayList deleting element speed is the fastest\n\n");
        };


        if (hsl[0] < lll[0] && hsl[0]<all[0]&&hsl[0]<tsl[0]) {
            System.out.print("HashSet adding element speed is the fastest\n\n");
        };
        if (hsl[1] < lll[1] && hsl[1]<all[1]&&hsl[1]<tsl[1]) {
            System.out.print("HashSet finding element speed is the fastest\n\n");
        };
        if (hsl[2] < lll[2] && hsl[2]<all[2]&&hsl[2]<tsl[2]) {
            System.out.print("HashSet deleting element speed is the fastest\n\n");
        };


        if(tsl[0]<lll[0]&&tsl[0]<all[0]&&tsl[0]<hsl[0]){

            System.out.print("TreeSet adding element speed is the fastest\n\n");
        };
        if(tsl[1]<lll[1]&&tsl[1]<all[1]&&tsl[1]<hsl[1]){

            System.out.print("TreeSet finding element speed is the fastest\n\n");
        };
        if(tsl[2]<lll[2]&&tsl[2]<all[2]&&tsl[2]<hsl[2]){

            System.out.print("TreeSet deleting element speed is the fastest\n\n");
        };



    }
    }