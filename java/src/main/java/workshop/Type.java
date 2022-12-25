package workshop;

public enum Type{
    FizzBuzz("FizzBuzz",15),Fizz("Fizz",3),Buzz("Buzz",5);
     final String type;
    final int divisor;
    Type (String type, int divisor){
        this.type = type;
        this.divisor = divisor;
    }

}
