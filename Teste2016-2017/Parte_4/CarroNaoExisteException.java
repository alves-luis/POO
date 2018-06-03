package Parte_4;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class CarroNaoExisteException extends Exception {
    public CarroNaoExisteException() {
        super();
    }
    
    public CarroNaoExisteException(String msg) {
        super(msg);
    }

}
