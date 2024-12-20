import java.util.ArrayList;
import java.util.Scanner;

class Book {
   //..... YOUR CODE STARTS HERE .....
   
   private String title;
    private String author;
    private boolean isBorrowed;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
    public String getTitle() {
        return title;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void borrowBook() {
        isBorrowed = true;
    }
    public void returnBook() {
        isBorrowed = false;
    }
   
   //..... YOUR CODE ENDS HERE .....
}
class Library {
   //..... YOUR CODE STARTS HERE .....
   
   private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added");
    }
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("Book borrowed");
                    return;
                } else {
                    System.out.println("Book not available");
                    return;
                }
            }
        }
        System.out.println("Book not found");
    }
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("Book returned");
                    return;
                } else {
                    System.out.println("Book was not borrowed");
                    return;
                }
            }
        }
        System.out.println("Book not found");
    }
   
   //..... YOUR CODE ENDS HERE .....
}
public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
   
   Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int N = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        for (int i = 0; i < N; i++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            String command = parts[0];
            switch (command) {
                case "add":
                    String title = parts[1];
                    String author = parts[2];
                    library.addBook(title, author);
                    break;
                case "borrow":
                    title = parts[1];
                    library.borrowBook(title);
                    break;
                case "return":
                    title = parts[1];
                    library.returnBook(title);
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }
        scanner.close();
    
   
        //..... YOUR CODE ENDS HERE .....
    }
}
