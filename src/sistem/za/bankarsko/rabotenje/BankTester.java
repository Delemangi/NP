package sistem.za.bankarsko.rabotenje;

import java.util.*;
import java.util.stream.Collectors;

interface ToDouble {
    static double toDouble(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 1));
    }
}

public class BankTester {
    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        String test_type = jin.nextLine();
        switch (test_type) {
            case "typical_usage":
                testTypicalUsage(jin);
                break;
            case "equals":
                testEquals();
                break;
        }
        jin.close();
    }

    private static void testEquals() {
        Account a1 = new Account("Andrej", "20.00$");
        Account a2 = new Account("Andrej", "20.00$");
        Account a3 = new Account("Andrej", "30.00$");
        Account a4 = new Account("Gajduk", "20.00$");
        List<Account> all = Arrays.asList(a1, a2, a3, a4);
        if (!(a1.equals(a1) && !a1.equals(a2) && !a2.equals(a1) && !a3.equals(a1)
                && !a4.equals(a1)
                && !a1.equals(null))) {
            System.out.println("Your account equals method does not work properly.");
            return;
        }
        Set<Long> ids = all.stream().map(Account::getId).collect(Collectors.toSet());
        if (ids.size() != all.size()) {
            System.out.println("Different accounts have the same IDS. This is not allowed");
            return;
        }
        FlatAmountProvisionTransaction fa1 = new FlatAmountProvisionTransaction(10, 20, "20.00$", "10.00$");
        FlatAmountProvisionTransaction fa2 = new FlatAmountProvisionTransaction(20, 20, "20.00$", "10.00$");
        FlatAmountProvisionTransaction fa3 = new FlatAmountProvisionTransaction(20, 10, "20.00$", "10.00$");
        FlatAmountProvisionTransaction fa4 = new FlatAmountProvisionTransaction(10, 20, "50.00$", "50.00$");
        FlatAmountProvisionTransaction fa5 = new FlatAmountProvisionTransaction(30, 40, "20.00$", "10.00$");
        FlatPercentProvisionTransaction fp1 = new FlatPercentProvisionTransaction(10, 20, "20.00$", 10);
        FlatPercentProvisionTransaction fp2 = new FlatPercentProvisionTransaction(10, 20, "20.00$", 10);
        FlatPercentProvisionTransaction fp3 = new FlatPercentProvisionTransaction(10, 10, "20.00$", 10);
        FlatPercentProvisionTransaction fp4 = new FlatPercentProvisionTransaction(10, 20, "50.00$", 10);
        FlatPercentProvisionTransaction fp5 = new FlatPercentProvisionTransaction(10, 20, "20.00$", 30);
        FlatPercentProvisionTransaction fp6 = new FlatPercentProvisionTransaction(30, 40, "20.00$", 10);
        if (fa1.equals(fa1) &&
                !fa2.equals(null) &&
                fa2.equals(fa1) &&
                fa1.equals(fa2) &&
                fa1.equals(fa3) &&
                !fa1.equals(fa4) &&
                !fa1.equals(fa5) &&
                !fa1.equals(fp1) &&
                fp1.equals(fp1) &&
                !fp2.equals(null) &&
                fp2.equals(fp1) &&
                fp1.equals(fp2) &&
                fp1.equals(fp3) &&
                !fp1.equals(fp4) &&
                !fp1.equals(fp5) &&
                !fp1.equals(fp6)) {
            System.out.println("Your transactions equals methods do not work properly.");
            return;
        }
        Account accounts[] = new Account[]{a1, a2, a3, a4};
        Account accounts1[] = new Account[]{a2, a1, a3, a4};
        Account accounts2[] = new Account[]{a1, a2, a3};
        Account accounts3[] = new Account[]{a1, a2, a3, a4};

        Bank b1 = new Bank("Test", accounts);
        Bank b2 = new Bank("Test", accounts1);
        Bank b3 = new Bank("Test", accounts2);
        Bank b4 = new Bank("Sample", accounts);
        Bank b5 = new Bank("Test", accounts3);

        if (!(b1.equals(b1) &&
                !b1.equals(null) &&
                !b1.equals(b2) &&
                !b2.equals(b1) &&
                !b1.equals(b3) &&
                !b3.equals(b1) &&
                !b1.equals(b4) &&
                b1.equals(b5))) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        //accounts[2] = a1;
        if (!b1.equals(b5)) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        long from_id = a2.getId();
        long to_id = a3.getId();
        Transaction t = new FlatAmountProvisionTransaction(from_id, to_id, "3.00$", "3.00$");
        b1.makeTransaction(t);
        if (b1.equals(b5)) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        b5.makeTransaction(t);
        if (!b1.equals(b5)) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        System.out.println("All your equals methods work properly.");
    }

    private static void testTypicalUsage(Scanner jin) {
        String bank_name = jin.nextLine();
        int num_accounts = jin.nextInt();
        jin.nextLine();
        Account accounts[] = new Account[num_accounts];
        for (int i = 0; i < num_accounts; ++i)
            accounts[i] = new Account(jin.nextLine(), jin.nextLine());
        Bank bank = new Bank(bank_name, accounts);
        while (true) {
            String line = jin.nextLine();
            switch (line) {
                case "stop":
                    return;
                case "transaction":
                    String descrption = jin.nextLine();
                    String amount = jin.nextLine();
                    String parameter = jin.nextLine();
                    int from_idx = jin.nextInt();
                    int to_idx = jin.nextInt();
                    jin.nextLine();
                    Transaction t = getTransaction(descrption, from_idx, to_idx, amount, parameter, bank);
                    System.out.println("Transaction amount: " + t.getAmount());
                    System.out.println("Transaction description: " + t.getDescription());
                    System.out.println("Transaction successful? " + bank.makeTransaction(t));
                    break;
                case "print":
                    System.out.println(bank.toString());
                    System.out.println("Total provisions: " + bank.totalProvision());
                    System.out.println("Total transfers: " + bank.totalTransfers());
                    System.out.println();
                    break;
            }
        }
    }

    private static Transaction getTransaction(String description, int from_idx, int to_idx, String amount, String o, Bank bank) {
        switch (description) {
            case "FlatAmount":
                return new FlatAmountProvisionTransaction(bank.getAccounts()[from_idx].getId(),
                        bank.getAccounts()[to_idx].getId(), amount, o);
            case "FlatPercent":
                return new FlatPercentProvisionTransaction(bank.getAccounts()[from_idx].getId(),
                        bank.getAccounts()[to_idx].getId(), amount, Integer.parseInt(o));
        }
        return null;
    }
}

class Account {
    private String name;
    private long ID;
    private String balance;

    public Account(String name, String balance) {
        this.name = name;
        this.balance = balance;

        Random r = new Random();
        ID = r.nextLong();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nBalance: " + balance + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ID == account.ID && name.equals(account.name) && balance.equals(account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID, balance);
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return ID;
    }
}

abstract class Transaction {
    private final long fromID;
    private final long toID;
    private final String description;
    private final String amount;

    public Transaction(long fromID, long toID, String description, String amount) {
        this.fromID = fromID;
        this.toID = toID;
        this.description = description;
        this.amount = amount;
    }

    public abstract double getProvision();

    public long getFromId() {
        return fromID;
    }

    public long getToId() {
        return toID;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}

class FlatAmountProvisionTransaction extends Transaction implements ToDouble {
    private final String flatProvision;

    public FlatAmountProvisionTransaction(long fromID, long toID, String amount, String flatProvision) {
        super(fromID, toID, "FlatAmount", amount);
        this.flatProvision = flatProvision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return flatProvision.equals(that.flatProvision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatProvision);
    }

    @Override
    public double getProvision() {
        return ToDouble.toDouble(flatProvision);
    }

    public String getFlatProvision() {
        return flatProvision;
    }
}

class FlatPercentProvisionTransaction extends Transaction implements ToDouble {
    private final int centsPerDollar;

    public FlatPercentProvisionTransaction(long fromID, long toID, String amount, int centsPerDollar) {
        super(fromID, toID, "FlatPercent", amount);
        this.centsPerDollar = centsPerDollar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return centsPerDollar == that.centsPerDollar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(centsPerDollar);
    }

    @Override
    public double getProvision() {
        return (int) ToDouble.toDouble(getAmount()) * (centsPerDollar / 100.0);
    }

    public int getCentsPerDollar() {
        return centsPerDollar;
    }
}

class Bank implements ToDouble {
    private final String name;
    private final Account[] accounts;
    private double totalTransfer;
    private double totalProvision;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.totalTransfer = 0;
        this.totalProvision = 0;
        this.accounts = new Account[accounts.length];
        System.arraycopy(accounts, 0, this.accounts, 0, accounts.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Double.compare(bank.totalTransfer, totalTransfer) == 0 && Double.compare(bank.totalProvision, totalProvision) == 0 && name.equals(bank.name) && Arrays.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, totalTransfer, totalProvision);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(name).append("\n\n");

        for (Account acc : accounts) {
            str.append(acc.toString());
        }

        return str.toString();
    }

    private int findIndex(long ID) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == ID) {
                return i;
            }
        }
        return -1;
    }

    public boolean makeTransaction(Transaction t) {
        int indexFrom = findIndex(t.getFromId());
        int indexTo = findIndex(t.getToId());

        if (indexFrom == -1 || indexTo == -1) {
            return false;
        }

        double balanceFrom = ToDouble.toDouble(accounts[indexFrom].getBalance());
        double transactionAmount = ToDouble.toDouble(t.getAmount());

        if (balanceFrom < transactionAmount) {
            return false;
        }

        double balanceTo = ToDouble.toDouble(accounts[indexTo].getBalance());
        double provisionAmount = t.getProvision();

        totalTransfer += transactionAmount;
        totalProvision += provisionAmount;

        if (indexFrom == indexTo) {
            accounts[indexFrom].setBalance(String.format("%.2f$", balanceFrom - provisionAmount));
        } else {
            accounts[indexFrom].setBalance(String.format("%.2f$", balanceFrom - provisionAmount - transactionAmount));
            accounts[indexTo].setBalance(String.format("%.2f$", balanceTo + transactionAmount));
        }

        return true;
    }

    public String totalTransfers() {
        return String.format("%.2f$", totalTransfer);
    }

    public String totalProvision() {
        return String.format("%.2f$", totalProvision);
    }

    public Account[] getAccounts() {
        return accounts;
    }
}