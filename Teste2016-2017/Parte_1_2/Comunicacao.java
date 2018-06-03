package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
import java.time.LocalDate;

public class Comunicacao {
    private String remetente;
    private String destinatario;
    private LocalDate data;
    
    public Comunicacao(Comunicacao c) {
        remetente = c.getRemetente();
        destinatario = c.getDestinatario();
        data = c.getData();
    }
    
    public String getDestinatario() {
        return this.destinatario;
    }
    
    public LocalDate getData() {
        return this.data;
    }
    
    public String getRemetente() {
        return this.remetente;
    }
    
    public Comunicacao clone() {
        return new Comunicacao(this);
    }
    
    public boolean equals(Object o) {
        if (o == this)
        return true;
        
        if(o == null || o.getClass() != this.getClass())
        return false;
        
        Comunicacao c = (Comunicacao) o;
        return c.getDestinatario().equals(destinatario) && c.getData().equals(data) && c.getRemetente().equals(remetente);
    }
}
