package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class Mensagem extends Comunicacao {
    private String assunto;
    private String texto;
    
    public Mensagem(Mensagem m) {
        super(m);
        this.assunto = m.getAssunto();
        this.texto = m.getTexto();
    }
    
    public String getAssunto() {
        return this.assunto;
    }
    
    public String getTexto() {
        return this.texto;
    }
    
    public Mensagem clone() {
        return new Mensagem(this);
    }
}

