package Parte_4;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class Carro {
    private String numero;
    
    public Carro() {
        numero = "";
    }
    
    public Carro(String n) {
        numero = n;
    }
    
    public Carro(Carro c) {
        numero = c.getNumero();
    }
    
    public String getNumero() {
        return numero;
    }
    
    public Carro clone() {
        return new Carro(this);
    }

}
