import java.util.ArrayList;

class Member{
    private String name;
    private String email;
    private String memberId;
    private ArrayList<Book> borrowedBooks;
    private int maxBooksAllowed;

    // constructor
    public Member(String name, String email, String memberId, int maxBooksAllowed){
        this.name = name;
        this.email = email;
        this.memberId = memberId;
        this.maxBooksAllowed = maxBooksAllowed;
        this.borrowedBooks = new ArrayList<>();
    }

    // getter methods
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getMemberId(){
        return memberId;
    }

    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public int getMaxBooksAllowed(){
        return maxBooksAllowed;
    }

    // setter methods
    public void setEmail(String email){
        this.email = email;
    }

    public void setMaxBooksAllowed(int maxBooksAllowed){
        this.maxBooksAllowed = maxBooksAllowed;
    }

    // Borrowing/Returning book methods
    public boolean borrowBook(Book book){
        if(borrowedBooks.size() >= maxBooksAllowed){
            System.out.println("User has reached max books allowed");
            return false;
        }
        else{
            borrowedBooks.add(book);
            return true;
        }
    }

    // removes returned book from member's borrowed books 
    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    public boolean canBorrowMore(){

        if(borrowedBooks.size() < maxBooksAllowed){
            return true;
        }

        else{
            return false;
        }

    }

    // display member info method
    public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Member ID: " + getMemberId());
        System.out.println("Max Books Allowed: " + getMaxBooksAllowed());
        System.out.println("Borrowed Books:  " );
        displayBorrowedBooks();
    }

    public void displayBorrowedBooks(){
        if(borrowedBooks.isEmpty()){
            System.out.println("No books borrowed.");
            return;
        }
        for(Book book : borrowedBooks){
            System.out.println("- "+book.getTitle());

        }
    }
}