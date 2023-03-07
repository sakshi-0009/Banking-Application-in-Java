package BankAssignment;

@SuppressWarnings("serial")
public class InsufficientFunds extends Exception{

	public InsufficientFunds() {
        super("Insufficient funds: minimum balance requirement not met");
        System.out.println("Insufficient funds: minimum balance requirement not met");
	}
}
