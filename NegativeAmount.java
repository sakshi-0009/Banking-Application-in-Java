package BankAssignment;

@SuppressWarnings("serial")
public class NegativeAmount extends Exception{

	public NegativeAmount() {
        super("Invalid Amount: Amount cannot be negative");
		System.out.println("Invalid Amount: Amount cannot be negative");
    }

}
