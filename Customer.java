import java.util.Scanner;
class Customer extends User {
    private String firstName;
    private String lastName;
    private String address;

    public Customer(String username, String password) {//getters
        super(username, password);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public void createAccount(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();



        Account newAccount = new Account(accountNumber, accountHolderName);
        bank.addAccount(newAccount);
        System.out.println("Account created successfully.");
    }
}
