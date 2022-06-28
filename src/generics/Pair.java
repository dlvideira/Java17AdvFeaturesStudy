package generics;

import java.util.function.BiFunction;

public record Pair<T, U>(T first, U second) {

    //We have to use <V, W> after static, because itt is static method. Itt cannot acces type parameter of ir enclosing Pair
    public static <V, W> Pair<V, W> of(V first, W second){
        return new Pair<>(first, second);
    }

    //Because its not static method, it can access the type parameter (T, U) of the enclosing record.
    //Thats because they will always be called by on a instance of the object new Pair().withFirst().withSecond()
    public Pair<T, U> withFirst(T newFirst){
        return Pair.of(newFirst, second);
    }
    public Pair<T, U> withSecond(U newSecond){
        return Pair.of(first, newSecond);
    }

    //Bifunction takes 2 values T, U and return V, W
    public <V, W> Pair<V, W> map(BiFunction<T, U, Pair<V, W>> function){
        return  function.apply(first, second);
    }
}
