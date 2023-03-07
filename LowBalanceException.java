// @SuppressWarnings("serial")
public class LowBalanceException extends Exception{

	public LowBalanceException() {
        super("Low balance: balance is below the minimum requirement");
        System.out.println("Low balance: balance is below the minimum requirement");
    }
}
