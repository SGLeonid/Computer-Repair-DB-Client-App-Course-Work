public class User {
    public User() {}

    public User(String surname, String firstName, long phone)
    {
        this.surname = surname;
        this.firstName = firstName;
        this.phone = phone;
    }

    public User(int userId, String surname, String firstName, long phone)
    {
        this.userId = userId;
        this.surname = surname;
        this.firstName = firstName;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private int userId;
    private String surname;
    private String firstName;
    private long phone;

    @Override
    public String toString()
    {
        return "User " + "[ID: " + userId + ", Surname: " + surname + ", firstName: " + firstName + ", phone: " + phone;
    }
}
