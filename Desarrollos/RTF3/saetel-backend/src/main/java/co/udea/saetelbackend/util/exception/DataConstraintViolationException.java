package co.udea.saetelbackend.util.exception;

public class DataConstraintViolationException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public DataConstraintViolationException(String message){
        super(message);
    }
}
