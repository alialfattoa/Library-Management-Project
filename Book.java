class Book{

    private String title;
    private String author;
    private String isbn;
    private String type;
    private double price;
    private boolean isAvailable;

    // constructor
    public Book(String title, String author, String isbn, String type, double price, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // getter methods
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return isbn;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    public boolean getAvailability(){
        return isAvailable;
    }

    // setter methods
    public void setPrice(double price){
        this.price = price;
    }

    public void setAvailability(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    
}