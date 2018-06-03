package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class Telefonema extends Comunicacao implements Faturavel {
    private int duracao;
    
    public Telefonema(Telefonema t) {
        super(t);
        duracao = t.getDuracao();
    }
    
    public int getDuracao() {
        return duracao;
    }
    
    public int getPreco() {
        return duracao;
    }
}
