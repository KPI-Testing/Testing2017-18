import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        LinkedList<Journalist> editorialteamRead = new LinkedList<Journalist>();
        LinkedList<Journalist> editorialteamWrite = new LinkedList<Journalist>();
        editorialteamRead.add(new Journalist1(50, "Anna Solovei"));
        editorialteamRead.add(new Journalist1(50, "Gera Sulikov"));
        editorialteamRead.add(new Journalist1(60, "George Lazurenko"));
        editorialteamRead.add(new Journalist1(70, "Dima Entis"));
        editorialteamRead.add(new Journalist1(70, "Sandra Konopatksa"));
        Journalist.ComparatorJ cmp = new Journalist.ComparatorJ();
        editorialteamRead.sort(cmp);
        Iterator<Journalist> it = editorialteamRead.listIterator(0);
        int i=0;
        while (it.hasNext()) {
            Journalist j = it.next();
            System.out.println(i+" "+j.name+"  "+j.Salary());
            i++;
        }

        System.out.println ("______________________________________");
        it = editorialteamRead.listIterator(0);
        for (int j=0; j<5; j++){
            if (!it.hasNext()) break;
            System.out.println(it.next().name);
        }

        System.out.println ("______________________________________");

        it = editorialteamRead.descendingIterator();
        for (int j=i; j>i-3; j--){
            if (!it.hasNext()) break;
            System.out.println(j-1);
        }

        System.out.println ("______________________________________");
        System.out.print("Enter the file to write name with extension: ");
        Scanner input = new Scanner(System.in);
        Journalist.Write(input.nextLine(),editorialteamWrite);
        System.out.print("Enter the file to read name with extension: ");
        editorialteamRead=Journalist.Read(input.nextLine());
        System.out.println ("______________________________________");
        if (editorialteamRead!=null) {
            it = editorialteamRead.listIterator(0);
            i = 0;
            while (it.hasNext()) {
                Journalist w = it.next();
                System.out.println(i + " " + w.name + "  " + w.Salary());
                i++;
            }
        }

    }
}
