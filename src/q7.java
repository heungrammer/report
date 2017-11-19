import java.util.Calendar;

class PrintTime implements Runnable {
	int count;	//횟수
	
	public PrintTime(int count) {
		this.count=count;	//생성자
	}
	
	public void run() {
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(300);	//0.3초 정도의 시간차를 줬다.
				Calendar now = Calendar.getInstance();	//현재시간을 저장한다.
				System.out.println("순위: " + Thread.currentThread().getPriority() +" " + now.getTime() + " " + Thread.currentThread().getName() );
			} catch (InterruptedException e) {	//예외 발생 시 처리된다.
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
public class q7 {
	public static void main(String[] args) {
		PrintTime p1 = new PrintTime(3);	// 횟수3인 생성자 생성
		Thread th1 = new Thread(p1, "안녕하세요!");	//스레드이름이 "안녕하세요!"인 스레드 생성
		th1.setPriority(Thread.MAX_PRIORITY-1); //우선순위를 최대우선순위에서 1을 뺐다.
		th1.start();	//스레드 시작
		
		PrintTime p2 = new PrintTime(6);	//횟수 6인 생성자 생성
		Thread th2 = new Thread(p2, "반갑습니다.");//스레드이름이 "반갑습니다."인 스레드 생성
		th2.setPriority(Thread.NORM_PRIORITY-1);//기본우선순위에서 1을 뺐다.
		th2.start();	//th2 스레드 시작
	}
}
