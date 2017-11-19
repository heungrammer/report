class PrimeNumber03 implements Runnable {
	int max;	//최대 정수
	
	public PrimeNumber03(int max) {
		this.max= max;	//생성자 
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+":");//현재 스레드의 이름을 출력
		for(int i=1;i<=max;i++) {	//소수구하기
			int count = 0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2)
				System.out.print(i +" ");	//소수를 출력해줌
		}
	}
}
public class q6 {
	public static void main(String[] args) {
		new Thread(new PrimeNumber03(25), "소수 만드는 스레드").start();	//스레드 생성 후 스타트
	}
}