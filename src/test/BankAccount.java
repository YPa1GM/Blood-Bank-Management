/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Pavan
 */
public class BankAccount {

    // Below are the instance variables with private access specifier
    //Private would make these variable's scope to be restricted to this class
    private double balance;
    private double deposit;
    private  double withdrawal_Amount;

    //For displaying balance
    private double getBalance() {
        return balance;
    }
    // For setting the balance to the instance variable  balance
    private void setBalance(double balance) {
        this.balance = balance;
    }
    //For displaying deposit
    private double getDeposit() {
        return deposit;
    }
    // For setting the deposited value to the instance variable deposit
    private void setDeposit(double deposit) {
        this.deposit = deposit;
    }
    // For displaying the withdrawn amount
    private double getWithdrawal_Amount() {
        return withdrawal_Amount;
    }
    // For setting the value of withdrawn amount to the instance variable
    private void setWithdrawal_Amount(double withdrawal_Amount) {
        this.withdrawal_Amount = withdrawal_Amount;
    }

    //Deposit class to handle the operations and functioning related to deposition
    protected static class Deposit{

        // Method for adding the deposited amount of the user to his balance
        //And updating the balance
        public double userDeposit(double deposit, double balance) {

            BankAccount b =new BankAccount();//Creating an object b for the BankAccount class
            b.setDeposit(deposit);//setting the deposit
            b.setBalance(balance);//setting the balance

            if(deposit<0){
                //If the deposited amount is negative
                System.out.println("Invalid amount");
                System.out.println("You must deposit a positive amount");
                System.out.println("You may choose withdraw option if you would like to withdraw some amount");
            }
            else if (deposit==0){
                //For no deposition
                System.out.println("You haven't deposited any amount");
            }
            else {
                //When a valid amount is deposited
                //Displaying the Balance before deposition
                System.out.print("Your Current Balance : ");
                System.out.print(b.getBalance());

                //Displaying the amount deposited by the user
                System.out.print("\nThe amount you deposited : ");
                System.out.print(b.getDeposit());

                //updating the balance basing upon the deposited value
                balance += deposit;
                b.setBalance(balance);

                System.out.print("\n Your Current Balance after deposition: ");
                System.out.print(b.getBalance());

                // Try block for checking if exceptions are present or not
                try {

                    // Making the thread to sleep for 1 second
                    Thread.sleep(1000);
                }

                // Below is the catch block for handling exception
                catch (InterruptedException e) {

                    // Below we are using printStacktrace() method
                    //Will display exception along with the lines
                    e.printStackTrace();
                }
            }


            return balance;
        }
    }

    //Withdrawal class to handle the operations and functioning related to deposition
    protected static class Withdrawal{

        public double userWithdrawal(double withdrawal_Amount, double balance) {

            BankAccount b= new BankAccount();
            b.setWithdrawal_Amount(withdrawal_Amount);
            b.setBalance(balance);

            System.out.println("Your current balance :" + balance);
            System.out.println("The amount you are trying to withdraw :" + withdrawal_Amount);

            // When invalid amount is tried to be withdrawn then following if block will start functioning
            if(withdrawal_Amount>balance || withdrawal_Amount>=1000000){ //Condition for invalid withdrawal amount is stated in the condition
                System.out.println("Invalid amount ");
                System.out.println("Try to withdraw valid amount ");

                // Try block for checking if exceptions are present or not
                try {

                    // Making thread to sleep for 1 second
                    Thread.sleep(1000);
                }

                // Below is the catch block for handling exception
                catch (InterruptedException e) {

                    // Below we are using printStacktrace() method
                    //Will display exception along with the lines
                    e.printStackTrace();
                }
            }
            else {
                //When valid amount is tried to be withdrawn
                // Modifying the balance (i.e balance will be decreased)
                balance -= withdrawal_Amount;
                //Displaying the withdrawn amount
                System.out.println("The withdrawn amount : " + b.getWithdrawal_Amount());
                //Displaying the current balance
                System.out.println("Your current balance :"+ b.getBalance());

                // Try block for checking if exceptions are present or not
                try {

                    // Making the thread to sleep for 1 second
                    Thread.sleep(1000);
                }

                // Below is the catch block for handling exception
                catch (InterruptedException e) {

                    // Below we are using printStacktrace() method
                    //Will display exception along with the lines
                    e.printStackTrace();
                }
            }
            return balance;//returning the current balance
        }
    }

}