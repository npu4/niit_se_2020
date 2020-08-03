import java.util.Objects;
@XmlTypeName("Человек")
public class PersonAnot {
    @XmlName("Имя")
    String firstName;
    @XmlName("Фамилия")
    String surname;
    @XmlName("Возраст")
    Integer age;
    String address;
    @XmlIgnore("")
    String password;

    public PersonAnot() {
    }

    public PersonAnot(String firstName, String surname, Integer age, String address, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAnot that = (PersonAnot) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(age, that.age) &&
                Objects.equals(address, that.address) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, age, address, password);
    }

    @Override
    public String toString() {
        return "PersonAnot {" +
                "\n firstName='" + firstName + '\'' +
                "\n surname='" + surname + '\'' +
                "\n age=" + age +
                "\n address='" + address + '\'' +
                "\n password='" + password + '\'' +
                "\n}";
    }
}
