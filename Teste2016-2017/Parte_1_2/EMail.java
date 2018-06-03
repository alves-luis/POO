package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class EMail extends Mensagem implements Faturavel {
    private String format;
    
    public EMail(EMail e) {
        super(e);
        format = e.getFormat();
    }
    
    public String getFormat() {
        return format;
    }
    
    public int getPreco() {
        return format.length();
    }
}
