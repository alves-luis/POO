package Parte_4;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
import java.util.TreeSet;

public class ParqueFechado implements AcessoParque {
    private TreeSet<String> carros;
    private int lotacao;
    
    public ParqueFechado() {
        carros = new TreeSet<>();
        lotacao = 0;
    }
    
    public void setLotacao(int lot) {
        lotacao = lot;
    }
    
    public void entra(Carro v) throws ParqueCheioException {
        if (carros.size() == lotacao) throw new ParqueCheioException();
        else carros.add(v.getNumero());
    }
    public void sai(String numeroCarro) throws CarroNaoExisteException {
        if (!carros.remove(numeroCarro)) throw new CarroNaoExisteException(numeroCarro);
    }
}
