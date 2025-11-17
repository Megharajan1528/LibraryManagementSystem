// File: Book.java
public class Book {
private final int id;
private final String title;
private final String author;
private boolean issued;


public Book(int id, String title, String author) {
this.id = id;
this.title = title;
this.author = author;
this.issued = false;
}


public int getId() { return id; }
public String getTitle() { return title; }
public String getAuthor() { return author; }
public boolean isIssued() { return issued; }


public void setIssued(boolean issued) { this.issued = issued; }


@Override
public String toString() {
return String.format("[%d] %s by %s %s", id, title, author, (issued ? "(Issued)" : ""));
}
}