import java.util.Calendar;

class PrintTime implements Runnable {
	int count;	//Ƚ��
	
	public PrintTime(int count) {
		this.count=count;	//������
	}
	
	public void run() {
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(300);	//0.3�� ������ �ð����� ���.
				Calendar now = Calendar.getInstance();	//����ð��� �����Ѵ�.
				System.out.println("����: " + Thread.currentThread().getPriority() +" " + now.getTime() + " " + Thread.currentThread().getName() );
			} catch (InterruptedException e) {	//���� �߻� �� ó���ȴ�.
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
public class q7 {
	public static void main(String[] args) {
		PrintTime p1 = new PrintTime(3);	// Ƚ��3�� ������ ����
		Thread th1 = new Thread(p1, "�ȳ��ϼ���!");	//�������̸��� "�ȳ��ϼ���!"�� ������ ����
		th1.setPriority(Thread.MAX_PRIORITY-1); //�켱������ �ִ�켱�������� 1�� ����.
		th1.start();	//������ ����
		
		PrintTime p2 = new PrintTime(6);	//Ƚ�� 6�� ������ ����
		Thread th2 = new Thread(p2, "�ݰ����ϴ�.");//�������̸��� "�ݰ����ϴ�."�� ������ ����
		th2.setPriority(Thread.NORM_PRIORITY-1);//�⺻�켱�������� 1�� ����.
		th2.start();	//th2 ������ ����
	}
}
