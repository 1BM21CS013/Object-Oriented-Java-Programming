import java.util.Scanner;
import java.lang.*;

class InputScanner {
    Scanner s;
    InputScanner(){s = new Scanner(System.in);}
}

class Account extends InputScanner {
    String customerName = new String();
    String accountNumber = new String();
    char typeOfAccount;

    void getInput(char ch) {        
        System.out.print("Enter customer name: ");
        customerName = s.next();
        System.out.print("Enter account Number: ");
        accountNumber = s.next();        
        typeOfAccount = ch;
    }
    void displayDetails() {
        System.out.println("\nCustomer name: " + customerName);
        System.out.println("Account number: " + accountNumber);
        if(typeOfAccount == 's')        
            System.out.println("Type of Account: Savings account");
        else       
            System.out.println("Type of Account: Current account");
    }
}
class Sav_acct extends Account {
    double balance;
    void deposit() {
        double depositAmount;
        System.out.print("Enter the deposit amount: ");
        depositAmount = s.nextDouble();
        balance += depositAmount;
    }
    void withdraw() {
        double withdrawalAmount;
        int choice;
        System.out.print("Enter the withdrawal amount: ");
        withdrawalAmount = s.nextDouble();
        balance -= withdrawalAmount;
    }
    void computeCompundInterest()
    {
        int t;
        System.out.print("Enter the time period: ");
        t = s.nextInt();
        for(int i = 0;i<t;i++)        
            balance += (balance*0.02);        
    }
    void displayDetails()
    {
        super.displayDetails();
        System.out.println("balance = " + balance + "\n");
    }
}
class Curr_acct extends Account {
    static int minimumBalance;
    double balance;
    double penalty;
    static {
        minimumBalance = 500;
    }
    void deposit() {
        double depositAmount;
        System.out.print("Enter the deposit amount: ");
        depositAmount = s.nextDouble();
        balance += depositAmount;
        if(balance + penalty >= minimumBalance)
            balance += penalty;
    }
    void withdraw() {
        double withdrawalAmount;
        int choice;
        System.out.print("Enter the withdrawal amount: ");
        withdrawalAmount = s.nextDouble();
        if(balance - withdrawalAmount < 500)
        {
            System.out.println("Withdrawing an amount of " + withdrawalAmount + " will reduce the balance beyond minimum balance");
            System.out.println("Enter 1 to continue withdrawal with penalty imposed");
            System.out.println("Enter 0 to cancel withdrawal");
            choice = s.nextInt();
            if(choice==1)
            {
                balance -= withdrawalAmount;
                penalty = -(minimumBalance*0.1);
            }
        }        
    }
    void displayDetails()
    {
        super.displayDetails();
        System.out.println("balance = " + balance + "\n");
    }
}

class Main 
{
    public static void main(String args[])
    {
        Scanner ss = new Scanner(System.in);
        Sav_acct savingsAccountHolder = new Sav_acct();
        Curr_acct currentAccountHolder = new Curr_acct();
        savingsAccountHolder.getInput('s');
        currentAccountHolder.getInput('c');
        while(true)
        {
            char c;
            int choice;            
            System.out.println("-----MENU-----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute interest for SavingsAccount");
            System.out.println("4. Display account details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = ss.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter the type of account: ");
                    c = ss.next().charAt(0);
                    if(c=='s')
                        savingsAccountHolder.deposit();
                    else    
                        currentAccountHolder.deposit();
                    break;
                case 2:
                    System.out.print("Enter the type of account: ");
                    c = ss.next().charAt(0);
                    if(c=='s')
                        savingsAccountHolder.withdraw();
                    else    
                        currentAccountHolder.withdraw();
                    break;
                case 3:
                    savingsAccountHolder.computeCompundInterest();
                    break;
                case 4:
                    System.out.print("Enter the type of account: ");
                    c = ss.next().charAt(0);
                    if(c=='s')
                        savingsAccountHolder.displayDetails();
                    else    
                        currentAccountHolder.displayDetails();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}