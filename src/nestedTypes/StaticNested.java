package nestedTypes;

import java.time.LocalDate;

public class StaticNested {

    private static int NUMBER = 23;

    private static LocalDate date = LocalDate.of(2023, 1, 1);

    private String name = "Nome";

    private static void printNumber(){
        //Here we cannot use name because its nott static
        //System.out.println(name);  <--------
        System.out.println(NUMBER);
    }

    //This one is for shadowing example, look at nested
    private static void printDate(){
        System.out.println(date);
    }

    public void printName(){
        //Here, because the method is not static, we have access to all fields
        System.out.println(NUMBER);
        System.out.println(name);
    }

    //This is the nested class
    static class Nested {
        //same field as enclosing class
        private LocalDate date = LocalDate.of(2023, 2, 2);

        //same method as enclosing class (StaticNested)
        private void printDate(){
            System.out.println(date);
        }

        void some(){
            //Here we still have access to static field of the main class, even if it is private
            System.out.println(NUMBER);
            printNumber();

            //These two calls doesnt work because we create a sttatic context when we defined the Nested class as static
            //so we cannot access instance members here
            //System.out.println(name); <--------
            //printName(); <--------

            //Here we can diferentiate the calls
            //This date is the nested class date
            System.out.println(date);
            //This call is also from nested class
            printDate();

            //This is how we call ttthe enclosing members
            System.out.println(StaticNested.date);
            StaticNested.printDate();

        }

    }
}
