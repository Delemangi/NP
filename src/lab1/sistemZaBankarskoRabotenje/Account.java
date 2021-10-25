package lab1.sistemZaBankarskoRabotenje;

import java.util.Objects;
import java.util.Random;

public class Account {
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
