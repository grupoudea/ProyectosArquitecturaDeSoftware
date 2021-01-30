package co.udea.saetelbackend.util.exception;

public class ObjectNotFoundException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public ObjectNotFoundException(String mensaje){
        super(mensaje);
    }
}
