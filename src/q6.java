class PrimeNumber03 implements Runnable {
	int max;	//�ִ� ����
	
	public PrimeNumber03(int max) {
		this.max= max;	//������ 
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+":");//���� �������� �̸��� ���
		for(int i=1;i<=max;i++) {	//�Ҽ����ϱ�
			int count = 0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2)
				System.out.print(i +" ");	//�Ҽ��� �������
		}
	}
}
public class q6 {
	public static void main(String[] args) {
		new Thread(new PrimeNumber03(25), "�Ҽ� ����� ������").start();	//������ ���� �� ��ŸƮ
	}
}