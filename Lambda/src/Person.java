public class Person {
    private String firstNaame;
    private String lastName;
    private int age;

    public Person(String firstNaame, String lastName, int age) {
        this.firstNaame = firstNaame;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstNaame='" + firstNaame + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstNaame() {
        return firstNaame;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
