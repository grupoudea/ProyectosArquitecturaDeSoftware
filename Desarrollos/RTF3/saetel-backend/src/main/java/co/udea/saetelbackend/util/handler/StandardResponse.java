package co.udea.saetelbackend.util.handler;

public class StandardResponse<T> {

    private int status;
    private String message;
    private String devMessage;
    private T body;

    public StandardResponse(StatusStandardResponse status, T body){
        this.status = status.getStatus();
        this.body = body;
    }

    public StandardResponse(StatusStandardResponse status, String message){
        this.status = status.getStatus();
        this.message = message;
    }

    public StandardResponse(StatusStandardResponse status, String message, T body){
        this.status = status.getStatus();
        this.message = message;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public enum StatusStandardResponse{
        OK(1),
        ERROR(0);

        private int status;

        StatusStandardResponse(int status){
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
