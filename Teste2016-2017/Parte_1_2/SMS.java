package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
public class SMS extends Mensagem implements Faturavel {
    private static int MAX_SIZE = 160;
    
    private long numberId;
    private int totalParts;
    private int number;
    
    public SMS(SMS s) {
        super(s);
        numberId = s.getId();
        totalParts = s.getTotalParts();
        number = s.getNumber();
    }
    
    public long getId() {
        return numberId;
    }
    
    public int getTotalParts() {
        return totalParts;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int getPreco() {
        return totalParts*7;
    }
}
