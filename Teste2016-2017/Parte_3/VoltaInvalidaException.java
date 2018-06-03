package Parte_3;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class VoltaInvalidaException extends Exception {
    public VoltaInvalidaException() {
        super();
    }
    
    public VoltaInvalidaException(String msg) {
        super(msg);
    }
}
