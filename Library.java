

// File: Library.java
import java.util.*;

public class Library {
    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, User> users = new HashMap<>();

    // Add book
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    // Add user
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    // Issue book to user
    public boolean issueBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return false;
        }
        book.setIssued(true);
        user.borrowBook(bookId);
        return true;
    }

    // Return book from user
    public boolean returnBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        boolean removed = user.returnBook(bookId);
        if (!removed) {
            System.out.println("This user did not borrow that book.");
            return false;
        }
        book.setIssued(false);
        return true;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        books.values().stream()
                .sorted(Comparator.comparing(Book::getId))
                .forEach(System.out::println);
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        users.values().stream()
                .sorted(Comparator.comparing(User::getId))
                .forEach(u -> System.out.println(u + " -> " + u.getBorrowedBookIds()));
    }

    public Optional<Book> findBook(int id) {
        return Optional.ofNullable(books.get(id));
    }

    public Optional<User> findUser(int id) {
        return Optional.ofNullable(users.get(id));
    }
}



