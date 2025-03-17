public class Person {
    private String name;
    private String surname;
    private String email;


    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;

    }

    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Email: " + email;
    }

    //Getters and Setters
    //Getting the name of the person
    public String getName() {
        return name;
    }

    //Setting the name of the person
    public void setName(String name) {
        this.name = name;
    }

    //Getting the surname of the person
    public String getSurname() {
        return surname;
    }

    //Setting the surname of the person
    public void setSurname() {
        this.surname = surname;
    }

    //Getting the email of the person
    public String email() {
        return email;
    }

    //Setting the email of the person
    public void setEmail() {
        this.email = email;
    }

    public void printPersonInfo() {
        System.out.println("name" + name);
        System.out.println("surname" + surname);
        System.out.println("email" + email);
    }
}
