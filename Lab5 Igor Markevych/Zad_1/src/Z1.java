import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Z1 {
    public static void main(String args[]) {
        LinkedList<String> ll = new LinkedList<>();
        ArrayList<String> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        TreeSet<String> ts = new TreeSet<>();
//_____________________________________________________________________________________________

        long startTime;
        long endTime;
        startTime = System.nanoTime();
        ll.add("Object");
        endTime = System.nanoTime();
        long afll = endTime - startTime;
        System.out.println("Adding first element to Linked List: " + afll + " nanoseconds.");

        startTime = System.nanoTime();
        al.add("Object");
        endTime = System.nanoTime();
        long afal = endTime - startTime;
        System.out.println("Adding first element to Array List:  " + afal + " nanoseconds.");

        startTime = System.nanoTime();
        hs.add("Object");
        endTime = System.nanoTime();
        long afhs = endTime - startTime;
        System.out.println("Adding first element to Hash Set:    " + afhs + " nanoseconds.");

        startTime = System.nanoTime();
        ts.add("Object");
        endTime = System.nanoTime();
        long afts = endTime - startTime;
        System.out.println("Adding first element to Tree Set:    " + afts + " nanoseconds.");
        System.out.println("_________________");
//_____________________________________________________________________________________________

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            ll.add("Object" + i);
        endTime = System.nanoTime();
        long adll = endTime - startTime;
        System.out.println("Adding 10000 element to the end of Linked List: " + adll + " nanoseconds.");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            al.add("Object" + i);
        endTime = System.nanoTime();
        long adal = endTime - startTime;
        System.out.println("Adding 10000 element to the end of Array List:  " + adal + " nanoseconds.");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            hs.add("Object" + i);
        endTime = System.nanoTime();
        long adhs = endTime - startTime;
        System.out.println("Adding 10000 element to the end of Hash Set:    " + adhs + " nanoseconds.");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            ts.add("Object");
        endTime = System.nanoTime();
        long adts = endTime - startTime;
        System.out.println("Adding 10000 element to the end of Tree Set:    " + adts + " nanoseconds.");
        System.out.println("_________________");
//_____________________________________________________________________________________________


        startTime = System.nanoTime();
        ll.add(500, "Object00");
        endTime = System.nanoTime();
        long amll = endTime - startTime;
        System.out.println("Adding element in the middle of Linked List: " + amll + " nanoseconds.");

        startTime = System.nanoTime();
        al.add(500, "Object00");
        endTime = System.nanoTime();
        long amal = endTime - startTime;
        System.out.println("Adding element in the middle of Array List:  " + amal + " nanoseconds.");
        System.out.println("_________________");


//_____________________________________________________________________________________________
        startTime = System.nanoTime();
        ll.indexOf("Object500");
        endTime = System.nanoTime();
        long ioll = endTime - startTime;
        System.out.println("Searching for index of element in a Linked List: " + ioll + " nanoseconds.");

        startTime = System.nanoTime();
        al.indexOf("Object500");
        endTime = System.nanoTime();
        long ioal = endTime - startTime;
        System.out.println("Searching for index of element in an Array List: " + ioal + " nanoseconds.");

        startTime = System.nanoTime();
        ll.contains("Object500");
        endTime = System.nanoTime();
        long cll = endTime - startTime;
        System.out.println("Checking for element in a Linked List: " + cll + " nanoseconds.");

        startTime = System.nanoTime();
        al.contains("Object500");
        endTime = System.nanoTime();
        long cal = endTime - startTime;
        System.out.println("Checking for element in an Array List: " + cal + " nanoseconds.");

        startTime = System.nanoTime();
        hs.contains("Object500");
        endTime = System.nanoTime();
        long chs = endTime - startTime;
        System.out.println("Checking for element in a Hash Set:    " + chs + " nanoseconds.");

        startTime = System.nanoTime();
        ts.contains("Object500");
        endTime = System.nanoTime();
        long cts = endTime - startTime;
        System.out.println("Checking for element in a Tree Set:    " + cts + " nanoseconds.");
        System.out.println("_________________");

//_____________________________________________________________________________________________


        startTime = System.nanoTime();
        ll.remove("Object500");
        endTime = System.nanoTime();
        long dll = endTime - startTime;
        System.out.println("Deleting middle element from Linked List: " + dll + " nanoseconds.");

        startTime = System.nanoTime();
        al.remove("Object500");
        endTime = System.nanoTime();
        long dal = endTime - startTime;
        System.out.println("Deleting middle element from Array List:  " + dal + " nanoseconds.");

        startTime = System.nanoTime();
        hs.remove("Object500");
        endTime = System.nanoTime();
        long dhs = endTime - startTime;
        System.out.println("Deleting middle element from Hash Set:    " + dhs + " nanoseconds.");

        startTime = System.nanoTime();
        ts.remove("Object500");
        endTime = System.nanoTime();
        long dts = endTime - startTime;
        System.out.println("Deleting middle element from Tree Set:    " + dts + " nanoseconds.");
        System.out.println("_________________");


//_____________________________________________________________________________________________
//I tut menya uporolo.
        if (afal < afhs && afal < afll && afal < afts) System.out.println("Array List has the fastest adding first element.");
        if (afll < afhs && afll < afal && afll < afts) System.out.println("Linked List has the fastest adding first element.");
        if (afhs < afal && afhs < afll && afhs < afts) System.out.println("Hash Set has the fastest adding first element.");
        if (afts < afal && afts < afll && afts < afhs) System.out.println("Tree Set has the fastest adding first element.");

        if (adal < adhs && adal < adll && adal < adts) System.out.println("Array List has the fastest adding 1000 elements.");
        if (adll < adhs && adll < adal && adll < adts) System.out.println("Linked List has the fastest adding 1000 elements.");
        if (adhs < adal && adhs < adll && adhs < adts) System.out.println("Hash Set has the fastest adding 1000 elements.");
        if (adts < adal && adts < adll && adts < adhs) System.out.println("Tree Set has the fastest adding 1000 elements.");

        if (amal < amll) System.out.println("Array List has the fastest adding middle element.");
        if (amll < amal) System.out.println("Linked List has the fastest adding middle element.");

        if (ioal < ioll) System.out.println("Array List has the fastest searching for index of element.");
        if (ioll < ioal) System.out.println("Linked List has the fastest searching for index of element.");

        if (cal < chs && cal < cll && cal < cts) System.out.println("Array List has the fastest checking for element.");
        if (cll < chs && cll < cal && cll < cts) System.out.println("Linked List has the fastest checking for element.");
        if (chs < cal && chs < cll && chs < cts) System.out.println("Hash Set has the fastest checking for element.");
        if (cts < cal && cts < cll && cts < chs) System.out.println("Tree Set has the fastest checking for element.");

        if (dal < dhs && dal < dll && dal < dts) System.out.println("Array List has the fastest deleting middle element.");
        if (dll < dhs && dll < dal && dll < dts) System.out.println("Linked List has the fastest deleting middle element.");
        if (dhs < dal && dhs < dll && dhs < dts) System.out.println("Hash Set has the fastest deleting middle element.");
        if (dts < dal && dts < dll && dts < dhs) System.out.println("Tree Set has the fastest deleting middle element.");
    }
}
