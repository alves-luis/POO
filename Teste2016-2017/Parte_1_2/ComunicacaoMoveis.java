package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class ComunicacaoMoveis {
    private HashMap<String,ArrayList<Comunicacao>> comms;
    
    public ComunicacaoMoveis() {
        comms = new HashMap<>();
    }
    
    public void addComunicacao(Comunicacao com) throws ComunicacaoExiste {
        if(!comms.containsKey(com.getRemetente()))
            comms.put(com.getRemetente(),new ArrayList<Comunicacao>());
        ArrayList<Comunicacao> remetenteComs = comms.get(com.getRemetente());
        if (remetenteComs.contains(com)) throw new ComunicacaoExiste();
        else remetenteComs.add(com.clone());
    }
    
    public int factura(String numeroOriginador, LocalDate inicio, LocalDate fim) {
        ArrayList<Comunicacao> comunicacoes = comms.get(numeroOriginador);
        if (comunicacoes == null) return 0;
        return comunicacoes.stream()
        .filter(com -> com.getData().isAfter(inicio) && com.getData().isBefore(fim) && com instanceof Faturavel)
        .map(com -> (Faturavel) com)
        .mapToInt(com -> com.getPreco())
        .sum();
    }
}
