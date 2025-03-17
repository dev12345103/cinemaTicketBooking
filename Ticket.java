class Ticket{
    private int row;
    private int seat;
    private double price;
    private Person person;

    //Constructing a new Ticket object with the specified attributes
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getters and Setters
    //Getting the row of the ticket
    public int getRow() {
        return row;
    }

    //Setting the row of the ticket
    public void setRow(int row) {
        this.row = row;
    }

    //Getting the seat of the ticket
    public int getSeat() {
        return seat;
    }

    //Setting the seat of the ticket
    public void setSeat(int seat) {
        this.seat = seat;
    }

    //Getting the price of the ticket
    public double getPrice() {
        return price;
    }

    //Setting the price of the ticket
    public void setPrice(double price) {
        this.price = price;
    }

    //Getting the person of the ticket
    public Person getPerson() {
        return person;
    }

    //Setting the person of the ticket
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Ticket [Row: " + row + ", Seat: " + seat + ", Price: £" + price + ", Person: " + person + "]";
    }

    //Method that print tickets information
    public void printTicketInfo() {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: $" + price);
        System.out.println("Person Information:");
        person.printPersonInfo();
        System.out.println();

    }
}