import java.util.HashMap;
import java.util.Scanner;

class BankAccount {

    int accountNo;
    String name;
    double balance;

    BankAccount(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    void display() {
        System.out.println("\nAccount Number : " + accountNo);
        System.out.println("Customer Name  : " + name);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class BMS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        System.out.print("How many accounts do you want to create? : ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details for Account " + (i + 1));

            System.out.print("Enter Account Number : ");
            int acc = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance : ");
            double bal = sc.nextDouble();

            BankAccount account = new BankAccount(acc, name, bal);

            accounts.put(acc, account);
        }

        int choice;

        do {

            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank You...");
                break;
            }

            System.out.print("Enter Account Number : ");
            int searchAcc = sc.nextInt();

            BankAccount account = accounts.get(searchAcc);

            if (account == null) {
                System.out.println("Account Not Found.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount : ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter Withdraw Amount : ");
                    double with = sc.nextDouble();
                    account.withdraw(with);
                    break;

                case 3:
                    System.out.println("Current Balance :" + account.balance);
                    break;

                case 4:
                    account.display();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}