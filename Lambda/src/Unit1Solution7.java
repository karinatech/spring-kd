import java.util.*;

public class Unit1Solution7 {
    public static void main(String[] args) {
        List<Person> people= Arrays.asList(
                new Person("Mike","Hunteer",44),
                new Person("Jack", "Sparrow",25),
                new Person("Rose", "Carson",27)

        );
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        printAll(people);
        printLastNameBeginingC(people);

    }
    public static void printAll(List<Person>peopple){
        for (Person p:peopple
             ) {
            System.out.println(p.toString());
        }
    }
    public static void printLastNameBeginingC(List<Person>people){
        for (Person p:people
             ) {
            if (p.getLastName().startsWith("C")){
                System.out.println(p.toString());
            }
        }
    }
}
