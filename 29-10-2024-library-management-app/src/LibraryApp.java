public class LibraryApp {
    public static void main(String[] args) {
        String filename = "library_data.csv";
        Library library = new Library();
        LibraryFileHandler fileHandler = new LibraryFileHandler(filename);
        //Library libraryWithFile = new Library(fileHandler);

        //Librarian librarianWithFile = new Librarian(libraryWithFile);
        //librarianWithFile.displayMenu();

        //Library libraryInMemory = new Library();
        //Librarian librarianInMemory = new Librarian(libraryInMemory);
        //librarianInMemory.displayMenu();


        fileHandler.loadLibraryFromFile(library);

        Librarian librarian = new Librarian(library);
       librarian.displayMenu();

        fileHandler.saveLibraryToFile(library);
    }
}
