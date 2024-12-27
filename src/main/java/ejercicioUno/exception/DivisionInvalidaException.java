package ejercicioUno.exception;

public class DivisionInvalidaException extends ArithmeticException{
    private String mensaje;

    public DivisionInvalidaException(String m){
        this.mensaje = m;
    }
}
