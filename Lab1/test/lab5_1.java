/*Завдання 1
Виміряти час додавання, пошуку і видалення об'єктів з колекцій  LinkedList, ArrayList, TreeSet, HashSet.
Порівняти час і зробити висновок про те, за яких умов яка колекція працює швидше.
*/

package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class lab5_1 {

	public static void main(String[] args) {
		//ARRAYLIST
		System.out.println("\nArrayList\n");
		ArrayList<String> countryArrayList = new ArrayList<String>();
		int j = 0;
		long it[] = new long[20];
		it[j] = System.nanoTime();
		j++;
		countryArrayList.add("Ukraine");
        it[j] = System.nanoTime();
        System.out.printf("Time ArrayList Add (%d): %d \n", j, it[j] - it[j-1]);
		j++;
		countryArrayList.add("Russia");
        it[j] = System.nanoTime();
        System.out.printf("Time ArrayList Add (%d): %d \n", j, it[j] - it[j-1]);
		j++;
		countryArrayList.add("Poland");
		it[j] = System.nanoTime();
		System.out.printf("Time ArrayList Add (%d): %d \n", j, it[j] - it[j-1]);
		j++;
		countryArrayList.add("Italy");
        it[j] =  System.nanoTime();
        System.out.printf("Time ArrayList Add (%d): %d \n", j, it[j] - it[j-1]);
		j++;
		countryArrayList.add("France");
        it[j] =  System.nanoTime();
        System.out.printf("Time ArrayList Add (%d): %d \n", j, it[j] - it[j-1]);
		j++;
		
		System.out.println(countryArrayList);

        countryArrayList.remove("Russia");
        it[j] = System.nanoTime();
        System.out.printf("Time ArrayList Remove: %d \n", it[j] - it[j-1]);
        j++;
        
        System.out.println(countryArrayList);
        
        if(countryArrayList.contains("Ukraine")){
            System.out.println("List contains Ukraine");
        }
        
        it[j] = System.nanoTime();
        System.out.printf("Time ArrayList Search: %d \n", it[j] - it[j-1]);
        j++;

        
        //HASHSET
		System.out.println("\nHashSet\n");
        HashSet<String> countryHashSet = new HashSet<>();
        int k = 0;
		long it2[] = new long[20];
		it2[k] = System.nanoTime();
		k++;
        countryHashSet.add("Ukraine");
        it2[k] = System.nanoTime();
		System.out.printf("Time HashSet Add (%d): %d \n", k, it2[k] - it2[k-1]);
		k++;
        countryHashSet.add("Russia");
        it2[k] = System.nanoTime();
        System.out.printf("Time HashSet Add (%d): %d \n", k, it2[k] - it2[k-1]);
		k++;
		countryHashSet.add("Poland");
        it2[k] = System.nanoTime();
        System.out.printf("Time HashSet Add (%d): %d \n", k, it2[k] - it2[k-1]);
		k++;
		countryHashSet.add("Italy");
        it2[k] = System.nanoTime();
        System.out.printf("Time HashSet Add (%d): %d \n", k, it2[k] - it2[k-1]);
		k++;
		countryHashSet.add("France");
        it2[k] = System.nanoTime();
        System.out.printf("Time HashSet Add (%d): %d \n", k, it2[k] - it2[k-1]);
		k++;
        System.out.println(countryHashSet);
        
        countryHashSet.remove("Russia");
        it2[k] = System.nanoTime();
        System.out.printf("Time HashSet Remove: %d \n", it2[k] - it2[k-1]);
        k++;
        System.out.println(countryHashSet);
        
        if(countryHashSet.contains("Ukraine")){
            System.out.println("List contains Ukraine");
        }
        
        it2[k] = System.nanoTime();
        System.out.printf("Time HashSet Search: %d \n", it2[k] - it2[k-1]);
        k++;
        
        //TREESET
        System.out.println("\nTreeSet\n");
        TreeSet<String> countryTreeSet = new TreeSet<>();
        int p = 0;
		long it3[] = new long[20];
		it3[p] = System.nanoTime();
		p++;
        countryTreeSet.add("Ukraine");
        it3[p] = System.nanoTime();
		System.out.printf("Time TreeSet Add (%d): %d \n", p, it3[p] - it3[p-1]);
		p++;
        countryTreeSet.add("Russia");
        it3[p] = System.nanoTime();
		System.out.printf("Time TreeSet Add (%d): %d \n", p, it3[p] - it3[p-1]);
		p++;
        countryTreeSet.add("Poland");
        it3[p] = System.nanoTime();
		System.out.printf("Time TreeSet Add (%d): %d \n", p, it3[p] - it3[p-1]);
		p++;
        countryTreeSet.add("Italy");
        it3[p] = System.nanoTime();
		System.out.printf("Time TreeSet Add (%d): %d \n", p, it3[p] - it3[p-1]);
		p++;
        countryTreeSet.add("France");
        it3[p] = System.nanoTime();
		System.out.printf("Time TreeSet Add (%d): %d \n", p, it3[p] - it3[p-1]);
		p++;
        
        System.out.println(countryTreeSet);
        
        countryTreeSet.remove("Russia");
        it3[p] = System.nanoTime();
        System.out.printf("Time TreeSet Remove: %d \n", it3[p] - it3[p-1]);
        p++;
        System.out.println(countryTreeSet);
        
        if(countryTreeSet.contains("Ukraine")){
            System.out.println("List contains Ukraine");
        }
        
        it3[p] = System.nanoTime();
        System.out.printf("Time TreeSet Search: %d \n", it3[p] - it3[p-1]);
        p++;
        
        //LINKEDLIST
        System.out.println("\nLinkedList\n");
        LinkedList<String> countryLinkedList = new LinkedList<>();
        int l = 0;
		long it4[] = new long[20];
		it4[l] = System.nanoTime();
		l++;
        countryLinkedList.add("Ukraine");
        it4[l] = System.nanoTime();
		System.out.printf("Time LinkedList Add (%d): %d \n", l, it4[l] - it4[l-1]);
		l++;
        countryLinkedList.add("Russia");
        it4[l] = System.nanoTime();
		System.out.printf("Time LinkedList Add (%d): %d \n", l, it4[l] - it4[l-1]);
		l++;
        countryLinkedList.add("Poland");
        it4[l] = System.nanoTime();
		System.out.printf("Time LinkedList Add (%d): %d \n", l, it4[l] - it4[l-1]);
		l++;
        countryLinkedList.add("Italy");
        it4[l] = System.nanoTime();
		System.out.printf("Time LinkedList Add (%d): %d \n", l, it4[l] - it4[l-1]);
		l++;
        countryLinkedList.add("France");
        it4[l] = System.nanoTime();
		System.out.printf("Time LinkedList Add (%d): %d \n", l, it4[l] - it4[l-1]);
		l++;
        
        System.out.println(countryLinkedList);
        
        countryLinkedList.remove("Russia");
        it4[l] = System.nanoTime();
        System.out.printf("Time LinkedList Remove: %d \n", it4[l] - it4[l-1]);
        l++;
        
        System.out.println(countryLinkedList);
        
        if(countryLinkedList.contains("Ukraine")){
            System.out.println("List contains Ukraine");
        }
        it4[l] = System.nanoTime();
        System.out.printf("Time LinkedList Search: %d \n", it4[l] - it4[l-1]);
        l++;
	}

}
