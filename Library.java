import java.util.ArrayList;

class Library{
    private static String libraryName = "My Library";
    private static ArrayList<Book> Books = new ArrayList<>();
    private static ArrayList<Member> Members = new ArrayList<>();

    // constructor
    public Library(String libraryName){
        Library.libraryName = libraryName;
    }

    // setter methods
    public void setLibraryName(String library_Name){
        Library.libraryName = library_Name;
    }

    // book management methods
    public void addBook(Book book){
        Books.add(book);
    }

    public void removeBook(Book book){
        Books.remove(book);
    }

    public void displayAllBooks(){
        for(Book book : Books){
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println(" ");
        }
    }

    public void displayAvailableBooks(){
        for(Book book : Books){
            if (book.getAvailability() == true) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println(" ");  
            }
        }
    }

    public Book getBookByTitle(String bookName){
        for(Book book : Books){
            if(bookName.equalsIgnoreCase(book.getTitle())){
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public Book getBookByISBN(String isbn){
        for(Book book : Books){
            if(isbn.equals(book.getISBN())){
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for(Book book : Books){
            if(author.equalsIgnoreCase(book.getAuthor())){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    // member management methods

    public void addMember(Member member){
        Members.add(member);
    }

    public void removeMember(Member member){
        Members.remove(member);
    }

    public void displayAllMembers(){
        for(Member member : Members){
            member.displayInfo();
            System.out.println(" ");
        }
    }

    public Member searchMember(String memberId){
        for(Member member : Members){
            if(member.getMemberId().equalsIgnoreCase(memberId)){
                return member;
            }
        }
        System.out.println("Member not found");
        return null;
    }

    // checkout & return operations

    public boolean checkoutBook(String memberId, String isbn){
        Member member = searchMember(memberId);
        if(member == null){
            System.out.println("Member not found");
            return false;
        }

        Book book = getBookByISBN(isbn);
        if(book == null){
            System.out.println("Book not found");
            return false;
        }

        if(book.getAvailability()==false){
            System.out.println("Book not available");
            return false;
        }
        else{
            if(member.borrowBook(book)==false){
                return false;
            }
            else{
                Books.remove(book);
                book.setAvailability(false);
                System.out.println("Checked out successfully");
                return true;
            }
        }
    }

    public boolean returnBookToLibrary(String memberId, String isbn){
        
        Book book = getBookByISBN(isbn);
        Member member = searchMember(memberId);

        if(member == null){
            System.out.println("Member not found");
            return false;
        }

        for(Book borrowedBooks : member.getBorrowedBooks()){
            if(book == (borrowedBooks)){
                break;
            }
            else{
                System.out.println("Member has not borrowed this book");
                return false;
            }
        }

        book.setAvailability(true); // set book as available
        member.returnBook(book); // remove book from member's borrowed books
        System.out.println("Book returned successfully");
        return true;
    }

    public void displayStats(){
        System.out.println("All Books: ");
        displayAllBooks();
        System.out.println(" ");
        System.out.println("Available Books: ");
        displayAvailableBooks();

    } 
}