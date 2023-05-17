import java.util.Scanner;
public class BankSystem {
    private Bank bank;
    private User currentUser;
    public  BankSystem() {
        bank = new Bank();
        currentUser = null;
        admin1bs();
    }
    private void admin1bs() {
        Admin admin = new Admin("admin", "password");
        bank.addUser(admin);
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bank FAIED ElMasry ELAfriqi ELMtrshem ELDawly");
        while (true) {
            System.out.println("---------------------------");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    signUp( scanner);
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        currentUser = bank.login(username, password);
        if (currentUser == null) {
            System.out.println("Invalid username or password. Please try again.");
        } else {
            System.out.println("Login successful!");

            if (currentUser.isAdmin()) {
                showAdminMenu(scanner);
            } else {
                showCustomerMenu(scanner);
            }

            currentUser = null;
        }
    }

    private void signUp(Scanner scanner) {

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Customer customer = new Customer(username, password);
        bank.addUser(customer);

        System.out.println("Sign up successful! You can now log in.");
    }

    private void showAdminMenu(Scanner scanner) {
        Admin admin = (Admin) currentUser;

        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("-----------");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Logout");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    signUp( scanner);
                    break;
                case 2:
                    admin.removeUser(bank);
                    break;
                case 3:
                    bank.displayAllAccounts();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void showCustomerMenu(Scanner scanner) {
        Customer customer = (Customer) currentUser;
    System.out.println(("Hello  ")+(customer.getUsername()));

        while (true) {
            System.out.println("\nCustomer Menu");
            System.out.println("--------------");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customer.createAccount(bank);
                    break;
                case 2:
                    performDeposit(customer, scanner);
                    break;
                case 3:
                    performWithdraw(customer, scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void performDeposit(Customer customer, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = bank.findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.deposit( amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void performWithdraw(Customer customer, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = bank.findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
}
