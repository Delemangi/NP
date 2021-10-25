package lab1.sistemZaBankarskoRabotenje;

import java.util.Arrays;
import java.util.Objects;

public class Bank implements ToDouble {
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
