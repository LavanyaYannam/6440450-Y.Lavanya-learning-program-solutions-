package Exercise7;

public class BookService {
    private String owner;
    private BookRepository bookRepository;

    // Constructor for owner injection
    public BookService(String owner) {
        this.owner = owner;
    }

    // Setter for BookRepository injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println(owner + " is adding book: " + title);
        bookRepository.saveBook(title);
    }
}
