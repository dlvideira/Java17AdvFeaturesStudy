package nestedTypes;


public class InnerClass {
    private String name = "Joao";

    //Used mainly on classes that only have pourpose of the enclosing class
    //Not so commom to use, generarily it is static nested classes, use with caution
    class Inner {
        private String name = "Maria";

        void some(){
            //Shadowing works the same as static nested
            System.out.println(name); //Maria

            //To access our enclosing class member we need the keyword this
            System.out.println(InnerClass.this.name); //Joao
        }

    }
}
