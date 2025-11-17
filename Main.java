

// File: Main.java
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": addBookInteractive(); break;
                case "2": addUserInteractive(); break;
                case "3": issueBookInteractive(); break;
                case "4": returnBookInteractive(); break;
                case "5": library.listBooks(); break;
                case "6": library.listUsers(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        }
        System.out.println("Exiting. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("=== Library Management ===");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. List Books");
        System.out.println("6. List Users");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addBookInteractive() {
        try {
            System.out.print("Enter book id (integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Enter author: ");
            String author = scanner.nextLine().trim();
            library.addBook(new Book(id, title, author));
            System.out.println("Book added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid id.");
        }
    }

    private static void addUserInteractive() {
        try {
            System.out.print("Enter user id (integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();
            library.addUser(new User(id, name));
            System.out.println("User added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid id.");
        }
    }

    private static void issueBookInteractive() {
        try {
            System.out.print("Enter book id to issue: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter user id: ");
            int userId = Integer.parseInt(scanner.nextLine().trim());
            boolean ok = library.issueBook(bookId, userId);
            if (ok) System.out.println("Book issued successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid id.");
        }
    }

    private static void returnBookInteractive() {
        try {
            System.out.print("Enter book id to return: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter user id: ");
            int userId = Integer.parseInt(scanner.nextLine().trim());
            boolean ok = library.returnBook(bookId, userId);
            if (ok) System.out.println("Book returned successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid id.");
        }
    }

    private static void seedData() {
        library.addBook(new Book(101, "Clean Code", "Robert C. Martin"));
        library.addBook(new Book(102, "Introduction to Algorithms", "Cormen, Leiserson"));
        library.addBook(new Book(103, "Effective Java", "Joshua Bloch"));

        library.addUser(new User(1, "Alice"));
        library.addUser(new User(2, "Bob"));
    }
}

