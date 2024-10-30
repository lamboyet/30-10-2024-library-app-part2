public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;
    private String borrowedBy;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
        this.borrowedBy =null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public void borrowedBook(String borrower)
    {
        if(!isBorrowed)
        {
            this.isBorrowed = true;
            this.borrowedBy = borrower;
            System.out.println("the book " + title + " has been borrowed by " + borrower + ".");
        }
        else
            System.out.println("The book " + title + "is alreay borrowed");
    }

    public void returnBook()
    {
        if(isBorrowed)
        {
            this.isBorrowed = false;
            this.borrowedBy = null;
            System.out.println("the book" + title + " has been retuned ");
        }
        else
            System.out.println("the book" + title + "is not currently borrowed");
    }

    public boolean isAvailable()
    {
        return !isBorrowed;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? "(Borrowed by " + borrowedBy + ")" : "(Available)");
    }
}
