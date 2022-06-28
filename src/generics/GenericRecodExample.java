package generics;

public class GenericRecodExample {
    public static void main(String[] args) {
        var pair1 = Pair.<Integer, String>of(1, "one");

        var pair2 = Pair.of(2, "ttwo");

        //Here using lambda and type inference we are passing lef, right and expecting the return of right, left
        var pair3 = pair2.map((left, right) -> Pair.of(right, left));

        //Here without type inference
        var pair4 = pair2.<String, Integer> //specify the return type
                map((Integer left, String right) //specify the type of lambda
                -> Pair.<String , Integer> //specify the return type of of
                of(right, left));
    }
}
