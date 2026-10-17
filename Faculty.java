class Faculty extends Member{
    private String department;
    private String position;

    // getter methods
    public String getPosition(){
        return position;
    }

    public String getDepartment(){
        return department;
    }

    // setter methods
    public void setPosition(String position){
        this.position = position;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    // display faculty member info 
    @Override
    public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Member ID: " + getMemberId());
        System.out.println("Position: " + getPosition());
        System.out.println("Department: "+ getDepartment());
        System.out.println("Max Books Allowed: " + getMaxBooksAllowed());
        System.out.println("Borrowed Books:  " + getBorrowedBooks());
    }

    // constructor
    Faculty(String name, String email, String memberId, int maxBooksAllowed){
        super(name, email, memberId, maxBooksAllowed);
    }

}
