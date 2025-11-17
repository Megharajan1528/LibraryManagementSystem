// File: User.java
import java.util.ArrayList;
import java.util.List;


public class User {
private final int id;
private final String name;
private final List<Integer> borrowedBookIds;


public User(int id, String name) {
this.id = id;
this.name = name;
this.borrowedBookIds = new ArrayList<>();
}


public int getId() { return id; }
public String getName() { return name; }
public List<Integer> getBorrowedBookIds() { return borrowedBookIds; }


public void borrowBook(int bookId) {
borrowedBookIds.add(bookId);
}


public boolean returnBook(int bookId) {
return borrowedBookIds.remove((Integer) bookId);
}


@Override
public String toString() {
return String.format("User[%d] %s - Borrowed: %d", id, name, borrowedBookIds.size());
}
}