
import java.util.Scanner;
class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
        setIsAdmin(true);
    }

    public void addUser(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username of the user to add: ");
        String newUserUsername = scanner.nextLine();

        System.out.print("Enter password of the user to add: ");
        String newUserPassword = scanner.nextLine();

        User newUser = new User(newUserUsername, newUserPassword);
        bank.addUser(newUser);
    }

    public void removeUser(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username of the user to remove: ");
        String userToRemove = scanner.nextLine();

        boolean removed = bank.removeUser(userToRemove);
        if (removed) {
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}
