# Lab 11 — Bank Account Class

| | |
|---|---|
| **Week** | 12 |
| **Textbook** | Liang — **Chapter 9** (Objects and Classes) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Define a class with private instance variables and public methods (encapsulation).
2. Write overloaded constructors, including a no-argument constructor.
3. Distinguish instance members from `static` members.
4. Use `this` to resolve the shadowing of a field by a parameter.
5. Enforce business rules — no negative deposits, no overdrafts — inside the class.
6. Override `toString`.

---

## Files

| Path | Who edits it |
|---|---|
| `labs/lab11/src/BankAccount.java` | **You** — the class |
| `labs/lab11/src/Lab11AccountDemo.java` | **You** — the demonstration program |
| `labs/lab11/test/BankAccountTest.java` | Nobody |

---

## Background

**Encapsulation.** Fields are `private` so that no outside code can write `account.balance = 1000000;`.
Every change must pass through `deposit` or `withdraw`, where the rules are enforced. That
enforcement point is the entire reason the private keyword exists.

**Instance versus static.**

```java
private double balance;                          // INSTANCE: each account has its own
private static double annualInterestRate;        // STATIC: one value shared by all accounts
private static int accountCount;                 // STATIC: a population counter
```

Static members are accessed through the class — `BankAccount.getAccountCount()` — because they
belong to no particular object. The test driver confirms that a rate set once is visible from
every account.

**Shadowing and `this`.** When a parameter has the same name as a field, the parameter wins inside
the method. `this.id` reaches the field:

```java
public BankAccount(int id, String owner, double balance) {
    this.id = id;          // field = parameter
    this.owner = owner;
    this.balance = balance < 0 ? 0.0 : balance;   // reject a negative opening balance
    accountCount++;        // no 'this' needed: accountCount belongs to the class
}
```

`condition ? valueIfTrue : valueIfFalse` is the conditional operator from Chapter 3; a plain
`if` statement is equally acceptable.

**Returning `boolean` from a mutator.** `deposit` and `withdraw` report whether the operation was
permitted. A rejected operation must leave the balance **completely unchanged** — the driver
verifies the balance after each rejection.

---

## Instructions

### Part A — `BankAccount.java`

| Step | Member | Requirement |
|---|---|---|
| 1–2 | Fields | Three private instance fields; two private static fields |
| 3 | `BankAccount()` | id 0, owner `"Unknown"`, balance 0.0, increment the counter |
| 4 | `BankAccount(int, String, double)` | Copy the parameters using `this`; a negative balance becomes 0.0; increment the counter |
| 5 | `getId`, `getOwner`, `getBalance` | Return the matching field |
| 6 | `setId`, `setOwner` | Assign the parameter (note: there is **no** `setBalance` — that is deliberate) |
| 7 | `deposit(double)` | `false` and no change when amount ≤ 0; otherwise add and return `true` |
| 8 | `withdraw(double)` | `false` when amount ≤ 0 **or** amount > balance; otherwise subtract and return `true` |
| 9 | `getMonthlyInterestRate()` | `annualInterestRate / 12 / 100` |
| 10 | `getMonthlyInterest()` | `balance * getMonthlyInterestRate()` |
| 11 | Static methods | `getAccountCount`, `getAnnualInterestRate`, `setAnnualInterestRate` |
| 12 | `toString()` | Exactly `Account 1001 (Jane Doe): $250.00` via `String.format("...%.2f", ...)` |

Withdrawing the **entire** balance is allowed; only amounts *greater* than the balance are refused.

### Part B — `Lab11AccountDemo.java` (Step 13)

Set the annual rate, create at least two accounts, deposit, attempt an over-limit withdrawal,
print whether each operation succeeded, print the monthly interest, and print the account count.

---

## Commenting Standard (20 points)

```java
// WEAK
private static int accountCount = 0; // counter

// STRONG
// static: one counter shared by the whole class rather than one per object, so
// that it records how many BankAccount objects have ever been constructed.
private static int accountCount = 0;
```

---

## Compile, Run, and Test

```bash
bash tools/run_lab.sh lab11          # 28 official checks
python3 tools/comment_check.py labs/lab11
```

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 28 checks pass | 60 |
| Line comments explain every statement, including the instance/static distinction | 20 |
| Fields private, rules enforced inside the class, `toString` overridden | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab11` reports 28 of 28.
- [ ] Every field is `private`.
- [ ] A rejected deposit or withdrawal leaves the balance untouched.
- [ ] `Lab11AccountDemo` runs and prints sensible output.

```bash
git add . && git commit -m "Lab 11 complete - all 28 checks passing" && git push
```

---

## Stretch Goal

Add a `private java.util.ArrayList<String> transactions` field that records each successful
operation as `"DEPOSIT 100.00"` or `"WITHDRAW 50.00"`, plus a `printStatement()` method. Return a
**copy** of the list from any accessor — handing out the internal list would let outside code
modify it and defeat the encapsulation you just built.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| Fields are always 0 after construction | Assigned `id = id` (parameter to itself) | Use `this.id = id` |
| `non-static variable cannot be referenced from a static context` | A static method touched an instance field | Static methods may use only static members |
| Account count is wrong | The counter is not incremented in every constructor | Increment in both |
| `toString` prints `BankAccount@1b6d` | Method not overridden, or misspelled | Signature must be `public String toString()` |
| Balance changed after a refused withdrawal | Subtracted before validating | Validate first, then subtract |

