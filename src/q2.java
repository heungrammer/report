class InvalidWithdraw extends Exception {	//Exception �� ��ӹ޾� ���ο� ���ܸ� ����
	private static final long serialVersionUID = 1L;
	public InvalidWithdraw(String msg) {
		super(msg);
	}
}

class BankAccount {
	int balance;	// ���� �ܰ�
	
	public BankAccount(int balance) {	//���� �ʱ� �ܰ� ������
		this.balance=balance;
	}
	
	void deposit(int money) throws InvalidWithdraw {	//�Ա� �޼ҵ�
		if(money < 0) {
			throw new InvalidWithdraw("�ݾ��� ������ �� �� �����ϴ�.");	// �ݾ��� ������ �Է��� ��� ���ܸ� ����
		}
		balance+=money;	// �̻���� ��� ���������� �Աݵ�
	}
	
	void withdraw(int money) throws InvalidWithdraw {	//��� �޼ҵ�
		if(balance < money) {
			throw new InvalidWithdraw("�ܰ����: " + (money-balance) + " ���ڶ�" );	//�ݾ��� �ܰ��� ���� ��� ���ܸ� ����
		} else if(money < 0) {
			throw new InvalidWithdraw("�ݾ��� ������ �� �� �����ϴ�.");		//�ݾ��� ������ �Է��� ��� ���ܸ� ����
		}
		balance-=money;	// �̻���� ��� ���������� ��ݵ�
	}
}
public class q2 {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount(-100000);	//�ܰ� -100000�� ���� ����
		try {
			ba.withdraw(500000);	// 500000 ���
		} catch (InvalidWithdraw e) {
			System.out.println(e.getMessage());	// ���� �޽��� ���
		}
	}
}