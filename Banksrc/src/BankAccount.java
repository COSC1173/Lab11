/*
 * COSC 1173 Programming Lab - Lab 11: Bank Account Class
 * Textbook reference: Liang, Chapter 9 (Objects and Classes)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * DO NOT change any member name, parameter list, or return type.
 * REQUIREMENT: every executable statement you write must carry a line comment.
 */
public class BankAccount {

    // STEP 1 - INSTANCE VARIABLES (one copy per object). All are private, so that
    // outside code must go through the methods below. That is encapsulation.
    private int id;              // account number
    private String owner;        // name of the account holder
    private double balance;      // current balance in dollars

    // STEP 2 - STATIC VARIABLES (one copy shared by every object of this class).
    private static double annualInterestRate = 0.0; // percent, e.g. 4.5 means 4.5%
    private static int accountCount = 0;            // how many accounts have been created

    /**
     * STEP 3 - No-argument constructor.
     * TODO: set id to 0, owner to "Unknown", balance to 0.0, and increase accountCount by 1.
     */
    public BankAccount() {
        // TODO: write the four statements described above.
    }

    /**
     * STEP 4 - Constructor that accepts starting values.
     * TODO: copy each parameter into the matching instance variable and increase
     * accountCount by 1. Because the parameters shadow the fields, you must write
     * this.id = id (and so on) to reach the field.
     * A negative starting balance must be stored as 0.0.
     */
    public BankAccount(int id, String owner, double balance) {
        // TODO
    }

    // STEP 5 - ACCESSORS (getters). TODO: return the matching field.
    public int getId() { return 0; }
    public String getOwner() { return null; }
    public double getBalance() { return 0.0; }

    // STEP 6 - MUTATORS (setters). TODO: assign the parameter to the matching field.
    public void setId(int id) { }
    public void setOwner(String owner) { }

    /**
     * STEP 7 - Adds money to the account.
     * Return false and change nothing when amount is zero or negative;
     * otherwise add it to balance and return true.
     */
    public boolean deposit(double amount) {
        return false; // placeholder
    }

    /**
     * STEP 8 - Removes money from the account.
     * Return false and change nothing when amount is zero or negative,
     * or when amount is greater than the balance (no overdrafts).
     * Otherwise subtract it and return true.
     */
    public boolean withdraw(double amount) {
        return false; // placeholder
    }

    /** STEP 9 - Returns the monthly interest rate as a fraction: annual percent / 12 / 100. */
    public double getMonthlyInterestRate() {
        return 0.0; // placeholder
    }

    /** STEP 10 - Returns balance multiplied by the monthly interest rate. */
    public double getMonthlyInterest() {
        return 0.0; // placeholder
    }

    // STEP 11 - STATIC MEMBERS. These belong to the class, not to any one object,
    // so they are declared static and are called as BankAccount.getAccountCount().
    public static int getAccountCount() { return 0; }               // TODO: return accountCount
    public static double getAnnualInterestRate() { return 0.0; }    // TODO: return annualInterestRate
    public static void setAnnualInterestRate(double rate) { }       // TODO: assign annualInterestRate

    /**
     * STEP 12 - Returns a readable description of this account in exactly this form:
     *     Account 1001 (Jane Doe): $250.00
     * Use String.format with %.2f so the balance always shows two decimals.
     */
    @Override
    public String toString() {
        return ""; // placeholder
    }
}
