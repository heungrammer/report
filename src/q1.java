import java.util.InputMismatchException;
import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		int x = 0, y = 0, z = 0;
		Scanner input = new Scanner(System.in);	//���� �޾��ִ� ��ĳ�� �Լ�
		System.out.println("���� �� �� �Է�: " );
		try {
		x = input.nextInt();	//���������� �޴´�
		y = input.nextInt();
		z = x * y;
		System.out.printf("%d * %d = %d %n", x, y, z);
		} catch(InputMismatchException e) {	//�����ϰ�� ó�����ش�.
			e.printStackTrace();
		}
	}
}