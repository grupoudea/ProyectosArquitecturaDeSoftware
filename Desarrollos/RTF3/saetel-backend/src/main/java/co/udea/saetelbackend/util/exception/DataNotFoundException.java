package co.udea.saetelbackend.util.exception;

public class DataNotFoundException extends GeneralRuntimeException{

    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message){
        super(message);
    }

}
