/*
 * COSC 1173 Programming Lab - Lab 11 driver program.
 * Student name: [TYPE YOUR NAME HERE]
 *
 * STEP 13 - TODO: exercise the BankAccount class. Every statement needs a comment.
 */
public class Lab11AccountDemo {

    public static void main(String[] args) {

        BankAccount.setAnnualInterestRate(4.5); // one shared rate for all accounts

        BankAccount first = new BankAccount(1001, "Jane Doe", 250.00); // creates one object
        System.out.println(first); // println calls toString automatically

        // TODO: create a second account, deposit into it, attempt a withdrawal that is
        // too large, print whether each operation succeeded, print the monthly interest,
        // and print BankAccount.getAccountCount().
    }
}
