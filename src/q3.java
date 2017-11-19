class InvalidWithdraw2 extends RuntimeException {	//RuntimeException을 상속받아 비체크예외를 함
	private static final long serialVersionUID = 1L;
	public InvalidWithdraw2(String msg) {
		super(msg);
	}
}

class BankAccount2 {
	int balance;	// 계좌 잔고
	
	public BankAccount2(int balance) {	//계좌 초기 잔고 생성자
		this.balance=balance;
	}
	
	void deposit(int money) throws InvalidWithdraw2 {	//입금 메소드
		balance+=money;	// 입금 
		System.out.printf("정상 입금처리: 입금금액=%d, 잔금=%6d%n",money,balance); // 출력문
		if(money < 0) {
			throw new InvalidWithdraw2("금액을 음수로 할 수 없습니다.");	// 금액을 음수로 입력할 경우 예외를 보냄
		}
	}
	
	void withdraw(int money) throws InvalidWithdraw2 {	//출금 메소드
		balance-=money;	// 출금
		System.out.printf("정상 출금처리: 인출금액=%d, 잔금=%6d%n",money,balance);
		if(balance < money) {
			throw new InvalidWithdraw2(" 초과출금 요구 예외" );	//금액이 잔고보다 많을 경우 예외를 보냄
		} else if(money < 0) {
			throw new InvalidWithdraw2("금액을 음수로 할 수 없습니다.");		//금액을 음수로 입력할 경우 예외를 보냄
		}
	}
}
public class q3 {
	public static void main(String[] args) {
		BankAccount2 ba = new BankAccount2(-100000);	//잔고 -100000인 계좌 생성
		ba.deposit(100000);	//100000 입금
		ba.withdraw(100000);//100000 출금
		ba.withdraw(200000);//200000 출금
	}
}