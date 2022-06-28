package intializerBlocks;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class InitializerExample {
    //Used in Instance Initializer
    private final byte[] randomBytes;

    //normal static field
    private static final String SOME_FIELD = "SOME_VALUE";
    private static final Properties CONFIG = new Properties();
    //It is useful when you need to handle checked exceptions and when you need more ttthan a simple expression like above
    //It is called when the first time this class is used in runtime
    static {
        try {
            CONFIG.load(InitializerExample.class.getResourceAsStream("/example.properties"));
        } catch (IOException e) {
            //You can throw a runTime exception
            throw new RuntimeException(e);
        }
    }

    //Instance initializer
    //Not very usefull, much easier to use constructors
    //Only used if we wnatt to share code wittth multiple constructors
    {
        randomBytes = new byte[16];
        new Random().nextBytes(randomBytes);
    }

    public static void main(String[] args) {
        var x = new InitializerExample();
        for (var item : x.randomBytes){
            System.out.println(item);
        }

    }
}
