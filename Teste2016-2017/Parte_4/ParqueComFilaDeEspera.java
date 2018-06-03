package Parte_4;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ParqueComFilaDeEspera implements AcessoParque {
    private TreeSet<String> carros;
    private int lotacao;
    private ArrayList<String> espera;
    
    public void entra(Carro v) throws ParqueCheioException{
        if (carros.size() == lotacao) {
            espera.add(v.getNumero());
            throw new ParqueCheioException();
        }
        else
            carros.add(v.getNumero());
    }
    
    public void sai(String numeroCarro) throws CarroNaoExisteException{
        if (!carros.remove(numeroCarro)) throw new CarroNaoExisteException(numeroCarro);
        if (!espera.isEmpty()) carros.add(espera.get(0));
    }
    
    public Collection<String> getElementosEmFila() {
        return espera.stream().collect(Collectors.toCollection(() -> new ArrayList()));
    }
}
