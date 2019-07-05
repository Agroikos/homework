package DataModels;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    //public Contact (String )

    public Contact (String phoneNumber, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
