import java.util.ArrayList;
public class LibraryManagement{
    public static void main(String[] args){
        Book comp2130_courseware = new Book("Theoretical Foundations of Computer Science", "Dr. Peter Tsin", "978-0134743356", "Textbook", 45.0, true);
        Member alice = new Member("Alice Johnson", "alicejohnson@gmail.com", "M001", 2);
        
        // Testing Library class
        
        Library myLibrary = new Library("City Library");
        System.out.println("\nTesting Library class...");
        myLibrary.addBook(comp2130_courseware);
        System.out.println("All Books in the Library:");
        myLibrary.displayAllBooks();
        System.out.println("Available Books in the Library:");
        myLibrary.displayAvailableBooks();
        Book searchedBook = myLibrary.getBookByTitle("Theoretical Foundations of Computer Science");
        if(searchedBook != null){
            System.out.println("Book found: " + searchedBook.getTitle() + " by " + searchedBook.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
        Book searchedBookByISBN = myLibrary.getBookByISBN("978-0134743356");
        if(searchedBookByISBN != null){
            System.out.println("Book found by ISBN: " + searchedBookByISBN.getTitle() + " by " + searchedBookByISBN.getAuthor());
        } else {
            System.out.println("Book not found by ISBN.");
        }
        ArrayList<Book> booksByAuthor = myLibrary.getBooksByAuthor("Dr. Peter Tsin");
        System.out.println("Books by Dr. Peter Tsin:");    
        for(Book book : booksByAuthor){
            System.out.println(book.getTitle());
        }
        myLibrary.addMember(alice);
        Member searchedMember = myLibrary.searchMember("M001");
        if(searchedMember != null){
            System.out.println("Member found: " + searchedMember.getName() + " with ID " + searchedMember.getMemberId());
        } else {
            System.out.println("Member not found.");
        }
        System.out.println("All Members in the Library:");
        myLibrary.displayAllMembers();
        boolean borrowSuccess = myLibrary.checkoutBook("M001", "978-0134743356");
        if(borrowSuccess){
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Failed to borrow book.");
        }
        boolean returnSuccess = myLibrary.returnBookToLibrary("M001", "978-0134743356");
        if(returnSuccess){
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Failed to return book.");
        }
        System.out.println("Member Info after borrowing and returning the book:");
        searchedMember.displayInfo();
        System.out.println("Book Info after borrowing and returning:");
        searchedBookByISBN = myLibrary.getBookByISBN("978-0134743356");
        if(searchedBookByISBN != null){
            System.out.println("Title: " + searchedBookByISBN.getTitle());
            System.out.println("Available: " + searchedBookByISBN.getAvailability());
        } else {
            System.out.println("Book not found.");
        }   
    
        // testing Faculty and Student classes
        Faculty profSmith = new Faculty("Dr. John Smith", "johnsmith@university", "F001", 5);
        profSmith.setDepartment("Computer Science");
        profSmith.setPosition("Professor");
        System.out.println("\nTesting Faculty class...");
        profSmith.displayInfo();
        Student studentBob = new Student("Bob Brown", "bobbrown@university", "S001", 4);
        studentBob.setMajor("Software Engineering");
        System.out.println("\nTesting Student class...");
        studentBob.displayInfo();

    }
}

