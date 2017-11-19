import java.util.InputMismatchException;
import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		int x = 0, y = 0, z = 0;
		Scanner input = new Scanner(System.in);	//값을 받아주는 스캐너 함수
		System.out.println("정수 두 개 입력: " );
		try {
		x = input.nextInt();	//정수형으로 받는다
		y = input.nextInt();
		z = x * y;
		System.out.printf("%d * %d = %d %n", x, y, z);
		} catch(InputMismatchException e) {	//예외일경우 처리해준다.
			e.printStackTrace();
		}
	}
}