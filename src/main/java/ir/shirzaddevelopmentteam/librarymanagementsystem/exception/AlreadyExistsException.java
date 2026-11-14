package ir.shirzaddevelopmentteam.librarymanagementsystem.exception;

public class AlreadyExistsException extends RuntimeException{
    private String [] params;

    public AlreadyExistsException(String message,String...parameters) {
        super(message);
        this.params=parameters;
    }
    public String[] getParams() {
        return params;
    }
}
