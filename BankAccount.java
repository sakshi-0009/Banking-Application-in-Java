
package BankAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankAccount {
    private int accNo;
    private String custName;
    private String accType;
    private float balance;

    public BankAccount(int accNo, String custName, String accType, float balance) throws LowBalanceException, NegativeAmount {
        this.accNo = accNo;
        this.custName = custName;
        this.accType = accType;
        
			if (balance < 0) {
			    throw new NegativeAmount();
			} else if (accType.equals("Savings") && balance < 1000) {
			    throw new LowBalanceException();
			} else if (accType.equals("Current") && balance < 5000) {
			    throw new LowBalanceException();
			} else {
			    this.balance = balance;
			}
		
    }
    

    public int getAccNo() {
		return accNo;
	}


	public String getCustName() {
		return custName;
	}


	public String getAccType() {
		return accType;
	}

	 

	public void deposit(float amount) throws NegativeAmount {
        try {
			if (amount < 0) {
			    throw new NegativeAmount();
			} else {
			    this.balance += amount;
			}
		} catch (NegativeAmount e) {
			//e.printStackTrace();
		}
    }

    public void withdraw(float amount) throws InsufficientFunds, NegativeAmount {
        try {
			if (amount < 0) {
			    throw new NegativeAmount();
			} else if (accType.equals("Savings") && this.balance - amount < 1000) {
			    throw new InsufficientFunds();
			} else if (accType.equals("Current") && this.balance - amount < 5000) {
			    throw new InsufficientFunds();
			} else {
			    this.balance -= amount;
			}
		} catch (NegativeAmount e) {
			//e.printStackTrace();
		} catch (InsufficientFunds e) {
			//e.printStackTrace();
		}
    }

    public float getBalance() throws LowBalanceException {
        try {
			if (accType.equals("Savings") && this.balance < 1000) {
			    throw new LowBalanceException();
			} else if (accType.equals("Current") && this.balance < 5000) {
			    throw new LowBalanceException();
			} else {
			    return this.balance;
			}
		} catch (LowBalanceException e) {
			//e.printStackTrace();
		}
        return 0;
    }
    
    public static void main(String[] args) {
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BankAccount account[] = new BankAccount[10];
    	int x = 1;
    	
    	
    	 try {
			while (true) {
			     System.out.println("Choose an option:");
			     System.out.println("1. Create Bank Account");
			     System.out.println("2. Get Balance");
			     System.out.println("3. Withdraw");
			     System.out.println("4. Deposit");
			     System.out.println("5. Exit");

			     int choice = Integer.parseInt(br.readLine());

			     switch (choice) {
			         case 1:
			             System.out.print("Enter account number: ");
			             int accNo = Integer.parseInt(br.readLine());
			             System.out.print("Enter Account holder name: ");
			             String custName = br.readLine();
			             System.out.println("Enter account Type (Current or Savings): ");
			             String accType = br.readLine();
			             System.out.println("Enter Balance of your Account: ");
			             
			             
			             float balance = Float.parseFloat(br.readLine());
			             if(x <= 10) {
			            	 account[x] = new BankAccount(accNo, custName, accType, balance);
			            	 x++;
			             } else {
			            	 System.out.println("The maximum number of accounts has been reached !!!");
			             }
			             break;
			         case 2:
			             if (account[x-1] == null) {
			                 System.out.println("Account has not been created yet, first create the account.");
			             } else {
			            	 System.out.println("Enter the account number to get balance : ");
			            	 int Ac = Integer.parseInt(br.readLine());
			            	 int count = 0;
			            	 for(BankAccount account1 : account ) {
			            		 try {
									if(account1.getAccNo() == Ac && account1.getBalance() != 0) {
									     System.out.println("Current balance: " + account1.getBalance());
									     count = 1;
									     break;
									 }
									if(account1.getBalance() == 0) {
										count = 1;
									}
								} catch (NullPointerException e) {
									//e.printStackTrace();
								}
			            	 }
			            	 if(count == 0) {
			            		 System.out.println("Enter valid account no !!");
			            	 }
			             }

			             break;
			         case 3:
			             if (account == null) {
			                 System.out.println("Account has not been created yet, First create the account.");
			             } else {
			            	 System.out.println("Enter the account number to withdraw amount : ");
			            	 int Ac = Integer.parseInt(br.readLine());
			            	 int count = 0;
			            	 for(BankAccount account1 : account) {
			            		 try {
									if(account1.getAccNo() == Ac) {
										 System.out.print("Enter amount to withdraw: ");
									     float amount = Float.parseFloat(br.readLine());
									     count = 1;
									     account1.withdraw(amount);
									     break;
									 }
								} catch (NullPointerException e) {
									//e.printStackTrace();
								}
			            		
			            	 }
			            	 if(count == 0) {
			            		 System.out.println("Enter valid account no !!");
			            	 }
			            	 
			             }
			             
			             break;
			         case 4:
			             if (account == null) {
			                 System.out.println("Account has not been created yet, First create the account.");
			             } else {
			            	 System.out.println("Enter the account number to deposit amount : ");
			            	 int Ac = Integer.parseInt(br.readLine());
			            	 int count = 0;
			            	 for(BankAccount account1 : account) {
			            		 try {
									if(account1.getAccNo() == Ac) {
										 System.out.print("Enter amount to deposit: ");
									     float amount = Float.parseFloat(br.readLine());
									     count = 1;
									     account1.deposit(amount);
									 }
								} catch (NullPointerException e) {
									//e.printStackTrace();
								}
			            	 }
			            	 if(count == 0) {
			            		 System.out.println("Enter valid account no !!");
			            	 }
			             }
			             break;
			         case 5:
			             System.out.println("Exiting program");
			             System.exit(0);
			         default:
			             System.out.println("Invalid choice ! Please enter valid choice.");
			             break;
			     }
			 }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LowBalanceException e) {
			e.printStackTrace();
		} catch (NegativeAmount e) {
			e.printStackTrace();
		} catch (InsufficientFunds e) {
			e.printStackTrace();
		}
	}
}

