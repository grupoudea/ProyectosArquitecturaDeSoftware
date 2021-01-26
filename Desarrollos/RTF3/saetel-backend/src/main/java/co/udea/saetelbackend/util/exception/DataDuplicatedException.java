package co.udea.saetelbackend.util.exception;

public class DataDuplicatedException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public DataDuplicatedException(String message){
        super(message);
    }
}
