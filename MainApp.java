package prog5121;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login user = new Login();
        ChatManager chatManager = new ChatManager();

        System.out.println("=== USER REGISTRATION (PART 1) ===");

        System.out.print("Enter First Name: ");
        user.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        user.setLastName(scanner.nextLine());

        while (true) {
            System.out.print("Enter Username (must contain '_' and <= 5 chars): ");
            String inputUsername = scanner.nextLine();
            if (user.checkUserName(inputUsername)) {
                user.setUsername(inputUsername);
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        while (true) {
            System.out.print("Enter Password: ");
            String inputPassword = scanner.nextLine();
            if (user.checkPasswordComplexity(inputPassword)) {
                user.setPassword(inputPassword);
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }

        while (true) {
            System.out.print("Enter Cell Phone Number (+27xxxxxxxxx): ");
            String inputCell = scanner.nextLine();
            if (user.checkCellPhoneNumber(inputCell)) {
                user.setCellNumber(inputCell);
                System.out.println("Cell phone number successfully captured.");
                break;
            } else {
                System.out.println("Cell phone number is incorrectly formatted. Please ensure it includes the international code (+27) followed by 9 digits.");
            }
        }

        System.out.println("\n" + user.registerUser());

        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccess = user.loginUser(loginUsername, loginPassword);
        System.out.println(user.returnLoginStatus(loginSuccess));

        if (loginSuccess) {
            System.out.println("\n=== CHAT APPLICATION (PART 2) ===");
            System.out.print("Enter recipient's South African cell number (+27xxxxxxxxx): ");
            String recipient = scanner.nextLine();

            System.out.print("Enter message text payload: ");
            String payload = scanner.nextLine();

            boolean sent = chatManager.sendMessage(recipient, payload);
            if (sent) {
                Message msg = chatManager.getMessageStore().get(0);
                System.out.println("Message SENT successfully to: " + msg.getRecipientCellNumber());
                
                chatManager.receiveMessage(msg);
                System.out.println("Message status: RECEIVED");

                chatManager.readMessage(msg);
                System.out.println("Message status: READ");
            } else {
                System.out.println("Failed to send message.");
            }
        }

        scanner.close();
    }
}