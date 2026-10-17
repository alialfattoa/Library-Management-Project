class Student extends Member{
    private String studentId;
    private String major;

    // constructor
    Student(String name, String email, String memberId, int maxBooksAllowed){
        super(name, email, memberId, maxBooksAllowed);
    }

    // getter methods
    public String getStudentId(){
        return studentId;
    }

    public String getMajor(){
        return major;
    }

    // setter methods
    public void setMajor(String major){
        this.major = major;
    }

    // display student member info 
    @Override
    public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Member ID: " + getMemberId());
        System.out.println("Student ID: "+ getStudentId());
        System.out.println("Major: "+ getMajor());
        System.out.println("Max Books Allowed: " + getMaxBooksAllowed());
        System.out.println("Borrowed Books:  " + getBorrowedBooks());
    }   
}