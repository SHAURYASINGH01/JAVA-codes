Ques 3:
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Book {
    private int id;
    private String title;
    private String author;
    private int year;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

class Library {
    private Map<Integer, Book> booksById;
    private TreeMap<String, Book> booksByTitle;

    public Library() {
        booksById = new HashMap<>();
        booksByTitle = new TreeMap<>();
    }

    public void addBook(Book book) {
        booksById.put(book.getId(), book);
        booksByTitle.put(book.getTitle(), book);
    }

    public void removeBookById(int id) {
        Book book = booksById.remove(id);
        if (book != null) {
            booksByTitle.remove(book.getTitle());
        }
    }

    public Book searchById(int id) {
        return booksById.get(id);
    }

    public Book searchByTitle(String title) {
        return booksByTitle.get(title);
    }

    public void displayBooksSortedByTitle() {
        for (Map.Entry<String, Book> entry : booksByTitle.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Read the number of books to add
        int numBooks = Integer.parseInt(scanner.nextLine().trim());
        
        // Add books
        for (int i = 0; i < numBooks; i++) {
            String[] bookDetails = scanner.nextLine().split(", ");
            int id = Integer.parseInt(bookDetails[0].split("=")[1].trim());
            String title = bookDetails[1].split("=")[1].trim();
            String author = bookDetails[2].split("=")[1].trim();
            int year = Integer.parseInt(bookDetails[3].split("=")[1].trim());
            library.addBook(new Book(id, title, author, year));
        }

        // Display books sorted by title
        System.out.println("Books sorted by title:");
        library.displayBooksSortedByTitle();

        // Search books by ID
        int searchId = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Search ID " + searchId + ":");
        System.out.println(library.searchById(searchId));

        // Remove a book by ID
        int removeId = Integer.parseInt(scanner.nextLine().trim());
        library.removeBookById(removeId);
        System.out.println("Removed book with ID " + removeId);

        // Display books sorted by title again
        System.out.println("Books sorted by title after removal:");
        library.displayBooksSortedByTitle();

        scanner.close();
    }
}
