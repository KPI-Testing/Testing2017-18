/*�������� 6
�������� ��������� ��������, ��� ��������� ����� ������� ����� (���������, �� ���� ���� �������������, 
�� ����� ������� ������������. �� ������������� �������� ������� reverse
*/

package test;

import java.util.Scanner;

public class lab5_6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("������� ���: ");
        String name = in.nextLine();
        in.close();
        char [] c = name.toCharArray ();
        int i = 0;
        for  (i = 0; i < c.length; i++) {
        	System.out.print(c[i]);
        }
        System.out.print("\n");
        for (i = c.length; i > 0; i--) {
        	System.out.print(c[i-1]);
        }
	}
}
