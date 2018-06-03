package Parte_4;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */

public interface AcessoParque {
    public void entra(Carro v) throws ParqueCheioException;
    public void sai(String numeroCarro) throws CarroNaoExisteException;

}
