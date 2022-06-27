package anonymousClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousExample {

    public static void main(String[] args) {
        //Create a list of names that we want to sort by name length, not the default
        var names = new ArrayList<>(List.of("Josefina", "Maria", "Joao", "Antonio"));

        //Here we can use new Interface and create the body of the class with the override methods
        //Our anonymous class will not have a name, neither constructos
        //Do not use, prefer to use method reference or lambdas like example whenever you can
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        });

        //Lambda version of the same code. Using functional interface
        names.sort((first, second) -> Integer.compare(first.length(), second.length()));

        //Method reference using factory method comparingInt
        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names);
    }
}
