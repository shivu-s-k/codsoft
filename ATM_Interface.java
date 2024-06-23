import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            return false;
        }
    }
}


class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        userAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your account balance: $" + balance);
    }

    public void depositFunds() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the deposit amount: $");
        double amount = input.nextDouble();
        userAccount.deposit(amount);
    }

    public void withdrawFunds() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: $");
        double amount = input.nextDouble();
        userAccount.withdraw(amount);
    }
}

public class ATM_Interface {
    public static void main(String[] args) {



        BankAccount userAccount = new BankAccount(0);


        ATM atm = new ATM(userAccount);


        atm.run();
    }
}