import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private LibraryFileHandler fileHandler;

    public Library(LibraryFileHandler fileHandler)
    {this.books = new HashMap<>();
    this.fileHandler = fileHandler;
    fileHandler.loadLibraryFromFile(this);}

    public Library() {
        this.books = new HashMap<>();
        this.fileHandler = null;

    }

    public Map<String, Book> getBooks()
    {
        return books;
    }

    public void addBook(Book book)
    {
        if(!books.containsKey(book.getISBN())){
            books.put(book.getISBN(), book);
            System.out.println("book added" + book.getTitle());
            if(fileHandler !=null){fileHandler.saveLibraryToFile(this);}
        }
        else {
            System.out.println("book with isbn " + book.getISBN() + "already exists");
        }
    }

    public void removeBook(String isbn)
    {
        if(books.containsKey(isbn))
        {
            books.remove(isbn);
            System.out.println("book with isbn" + isbn + "removed");
            if(fileHandler != null)
                fileHandler.saveLibraryToFile(this);
        }
        else {
            System.out.println("book with isbn " + isbn + " not found");
        }
    }

    public boolean isBookAvailable(String isbn)
    {
        Book book = books.get(isbn);
        if(book != null)
        {
            return book.isAvailable();
        }
        else{
            System.out.println("book with isbn " + isbn + " not found ");
            return false;
        }
    }

    public void getAllBooks(){
        System.out.println("Library Inventory: ");
        for (Book book : books.values())
            System.out.println(book);
    }

    public void getBorrowedBooks()
    {
        System.out.println("Borrowed Books:");
        for(Book book : books.values())
            if(book.isBorrowed())
            {
                System.out.println(book);
            }
    }

    public void borrowBook(String isbn, String borrower)
    {
        Book book = books. get(isbn);
        if(book!=null)
        {
            book.borrowedBook(borrower);
        }else
        {
            System.out.println("book with isbn " + isbn + "not found");
        }
    }

    public void returnBook(String isbn)
    {
        Book book = books.get(isbn);
        if(book != null)
        {
            book.returnBook();
        }else {
            System.out.println("book with isbn: " + isbn + " not found");
        }
    }
}
