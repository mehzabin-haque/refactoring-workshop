package workshop;

public class FizzBuzz {
    public static String say(int number) {
        for(Type t : Type.values()){
            if(number%t.divisor==0) {
                return t.type;
            }
        }

        return String.valueOf(number);

    }
}
