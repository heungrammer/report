class InvalidWithdraw extends Exception {	//Exception 을 상속받아 새로운 예외를 만듬
	private static final long serialVersionUID = 1L;
	public InvalidWithdraw(String msg) {
		super(msg);
	}
}

class BankAccount {
	int balance;	// 계좌 잔고
	
	public BankAccount(int balance) {	//계좌 초기 잔고 생성자
		this.balance=balance;
	}
	
	void deposit(int money) throws InvalidWithdraw {	//입금 메소드
		if(money < 0) {
			throw new InvalidWithdraw("금액을 음수로 할 수 없습니다.");	// 금액을 음수로 입력할 경우 예외를 보냄
		}
		balance+=money;	// 이상없을 경우 정상적으로 입금됨
	}
	
	void withdraw(int money) throws InvalidWithdraw {	//출금 메소드
		if(balance < money) {
			throw new InvalidWithdraw("잔고부족: " + (money-balance) + " 모자람" );	//금액이 잔고보다 많을 경우 예외를 보냄
		} else if(money < 0) {
			throw new InvalidWithdraw("금액을 음수로 할 수 없습니다.");		//금액을 음수로 입력할 경우 예외를 보냄
		}
		balance-=money;	// 이상없을 경우 정상적으로 출금됨
	}
}
public class q2 {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount(-100000);	//잔고 -100000인 계좌 생성
		try {
			ba.withdraw(500000);	// 500000 출금
		} catch (InvalidWithdraw e) {
			System.out.println(e.getMessage());	// 예외 메시지 출력
		}
	}
}