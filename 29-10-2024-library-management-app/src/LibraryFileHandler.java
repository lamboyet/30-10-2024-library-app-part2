import java.io.*;

public class LibraryFileHandler {
    private String filename;

    public LibraryFileHandler(String filename) {
        this.filename = filename;
    }

    public void saveLibraryToFile(Library library)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Book book : library.getBooks().values())
            {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "," + book.isBorrowed() + "," + (book.getBorrowedBy() !=null ? book.getBorrowedBy() : ""));
                writer.newLine();
            }
            System.out.println("Library data saved to: " + filename);
        }catch (IOException e)
        {
            System.err.println("Error saving library to file: " + e.getMessage());
        }
    }

    public void loadLibraryFromFile(Library library)
    {
        File file = new File(filename);
        if(!file.exists())
        {
            System.out.println("File not found. Creating a new file: " + filename);
            saveLibraryToFile(library);
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String [] fields = line.split(",");
                if(fields.length >= 4)
                {
                    String title = fields [0];
                    String author = fields [1];
                    String isbn = fields [2];
                    boolean isBorrowed = Boolean.parseBoolean(fields[3]);
                    String borrowedBy = fields.length == 5 ? fields[4] : null;

                    Book book = new Book(title, author,isbn);
                    if(isBorrowed)
                    {
                        book.borrowedBook(borrowedBy);
                    }
                    library.addBook(book);
                }

            }
            System.out.println("Library data loaded from " + filename);
        }catch(IOException e){
            System.err.println("error loading from file " + e.getMessage());
        }
    }
}
