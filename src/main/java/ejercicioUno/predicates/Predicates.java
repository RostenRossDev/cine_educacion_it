package ejercicioUno.predicates;

import java.util.function.Predicate;

public class Predicates {

    public static Predicate<String> StringEqualAnotherString(String otherString){
        return str -> str != null && str.equals(otherString);
    }
}
