package Task1;
import java.util.*;

public class Task1 {

	public static void main(String[] args) {
		
		LinkedList<String> MyLinkedList = new LinkedList<String>();
		
		System.out.println("LinkedList :");
		long start = System.nanoTime();
		MyLinkedList.add("str1");
		MyLinkedList.add("str2");
		MyLinkedList.add("str3");
		MyLinkedList.add("str4");
		MyLinkedList.add("str5");
		long finish = System.nanoTime();
		
		System.out.println("Addition time = " + (finish - start)/5);
		
		start = System.nanoTime();
		MyLinkedList.contains("str5");
		MyLinkedList.contains("str4");
		MyLinkedList.contains("str3");
		MyLinkedList.contains("str2");
		MyLinkedList.contains("str1");
		finish = System.nanoTime();
		
		System.out.println("Search time = " + (finish - start)/5);
		
		start = System.nanoTime();
		MyLinkedList.remove();
		MyLinkedList.remove();
		MyLinkedList.remove();
		MyLinkedList.remove();
		MyLinkedList.remove();
		finish = System.nanoTime();
		
		System.out.println("Removal time = " + (finish - start)/5);
//--------------------------------------------------------------------
		
		ArrayList<String> MyArrayList = new ArrayList<String>();
		
		System.out.println("ArrayList :");
		start = System.nanoTime();
		MyArrayList.add("str1");
		MyArrayList.add("str2");
		MyArrayList.add("str3");
		MyArrayList.add("str4");
		MyArrayList.add("str5");
		finish = System.nanoTime();
		
		System.out.println("Addition time = " + (finish - start)/5);
		start = System.nanoTime();
		MyArrayList.contains("str5");
		MyArrayList.contains("str4");
		MyArrayList.contains("str3");
		MyArrayList.contains("str2");
		MyArrayList.contains("str1");
		finish = System.nanoTime();
		
		System.out.println("Search time = " + (finish - start)/5);
		
		start = System.nanoTime();
		MyArrayList.remove(4);
		MyArrayList.remove(3);
		MyArrayList.remove(2);
		MyArrayList.remove(1);
		MyArrayList.remove(0);
		finish = System.nanoTime();
		
		System.out.println("Removal time = " + (finish - start)/5);
//--------------------------------------------------------------------
		
		TreeSet<String> MyTreeSet = new TreeSet<String>();
		
		System.out.println("TreeSet :");
		start = System.nanoTime();
		MyTreeSet.add("str1");
		MyTreeSet.add("str2");
		MyTreeSet.add("str3");
		MyTreeSet.add("str4");
		MyTreeSet.add("str5");
		finish = System.nanoTime();
		
		System.out.println("Addition time = " + (finish - start)/5);
		start = System.nanoTime();
		MyTreeSet.contains("str5");
		MyTreeSet.contains("str4");
		MyTreeSet.contains("str3");
		MyTreeSet.contains("str2");
		MyTreeSet.contains("str1");
		finish = System.nanoTime();
		
		System.out.println("Search time = " + (finish - start)/5);
		
		start = System.nanoTime();
		MyTreeSet.remove("str1");
		MyTreeSet.remove("str2");
		MyTreeSet.remove("str3");
		MyTreeSet.remove("str4");
		MyTreeSet.remove("str5");
		finish = System.nanoTime();
			
		System.out.println("Removal time = " + (finish - start)/5);		
		
//--------------------------------------------------------------------

		HashSet<String> MyHashSet = new HashSet<String>();
		
		System.out.println("HashSet :");
		start = System.nanoTime();
		MyHashSet.add("str1");
		MyHashSet.add("str2");
		MyHashSet.add("str3");
		MyHashSet.add("str4");
		MyHashSet.add("str5");
		finish = System.nanoTime();
		
		System.out.println("Addition time = " + (finish - start)/5);
		start = System.nanoTime();
		MyHashSet.contains("str5");
		MyHashSet.contains("str4");
		MyHashSet.contains("str3");
		MyHashSet.contains("str2");
		MyHashSet.contains("str1");
		finish = System.nanoTime();
		
		System.out.println("Search time = " + (finish - start)/5);
		
		start = System.nanoTime();
		MyHashSet.remove("str1");
		MyHashSet.remove("str2");
		MyHashSet.remove("str3");
		MyHashSet.remove("str4");
		MyHashSet.remove("str5");
		finish = System.nanoTime();
					
		System.out.println("Removal time = " + (finish - start)/5);
	}

}

/*За результатами роботи програми можна зробити такі висновки:
 * Найшвидшим для додавання є ArrayList найповільнішим LinkedList
 * Найшвидшим для пошуку є HashSet найповільнішим LinkedList
 * Найшвидшим для видалення є ArrayList найповільнішим TreeSet*/
