class InvalidWithdraw2 extends RuntimeException {	//RuntimeException�� ��ӹ޾� ��üũ���ܸ� ��
	private static final long serialVersionUID = 1L;
	public InvalidWithdraw2(String msg) {
		super(msg);
	}
}

class BankAccount2 {
	int balance;	// ���� �ܰ�
	
	public BankAccount2(int balance) {	//���� �ʱ� �ܰ� ������
		this.balance=balance;
	}
	
	void deposit(int money) throws InvalidWithdraw2 {	//�Ա� �޼ҵ�
		balance+=money;	// �Ա� 
		System.out.printf("���� �Ա�ó��: �Աݱݾ�=%d, �ܱ�=%6d%n",money,balance); // ��¹�
		if(money < 0) {
			throw new InvalidWithdraw2("�ݾ��� ������ �� �� �����ϴ�.");	// �ݾ��� ������ �Է��� ��� ���ܸ� ����
		}
	}
	
	void withdraw(int money) throws InvalidWithdraw2 {	//��� �޼ҵ�
		balance-=money;	// ���
		System.out.printf("���� ���ó��: ����ݾ�=%d, �ܱ�=%6d%n",money,balance);
		if(balance < money) {
			throw new InvalidWithdraw2(" �ʰ���� �䱸 ����" );	//�ݾ��� �ܰ��� ���� ��� ���ܸ� ����
		} else if(money < 0) {
			throw new InvalidWithdraw2("�ݾ��� ������ �� �� �����ϴ�.");		//�ݾ��� ������ �Է��� ��� ���ܸ� ����
		}
	}
}
public class q3 {
	public static void main(String[] args) {
		BankAccount2 ba = new BankAccount2(-100000);	//�ܰ� -100000�� ���� ����
		ba.deposit(100000);	//100000 �Ա�
		ba.withdraw(100000);//100000 ���
		ba.withdraw(200000);//200000 ���
	}
}