import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Mike", "Hunter", 44),
                new Person("Jack", "Sparrow", 25),
                new Person("Rose", "Carson", 27)

        );

        Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));

        printAll(people,p->true);
        printAll(people, p->p.getLastName().startsWith("C"));

    }

    public static void printAll(List<Person>people, Predicate<Person> con){
        for (Person p:people
        ) {
            if (con.test(p)){
                System.out.println(p.toString());
            }
        }
    }
}

