import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;
    private List<Account> accounts;
    private static String bankName = "Bank FAIED ElMasry ELAfriqi ELMtrshem ELDawly";

    public Bank() {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public boolean addUser(User user) {
        users.add(user);
//        System.out.println("User added successfully.");
        return true;
    }

    public static String getBankName() {
        return bankName;
    }

    public boolean removeUser(String username) {
        try {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    users.remove(user);
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\nAll Accounts");
            System.out.println("-------------");
            for (Account account : accounts) {
                account.displayAccountInfo();
                System.out.println("----------------");
            }
        }
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

