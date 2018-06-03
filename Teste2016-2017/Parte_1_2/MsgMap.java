package Parte_1_2;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public class MsgMap {
    private TreeMap<String,ArrayList<Mensagem>> msgBox;
    
    public MsgMap(MsgMap p) {
        this.msgBox = p.getMsgBox();
    }
    
    public TreeMap<String,ArrayList<Mensagem>> getMsgBox() {
        TreeMap<String,ArrayList<Mensagem>> result = new TreeMap<>();
        for (Map.Entry<String,ArrayList<Mensagem>> e : this.msgBox.entrySet()) {
            ArrayList<Mensagem> temp = e.getValue()
            .stream()
            .map(Mensagem::clone)
            .collect(Collectors.toCollection(ArrayList::new));
            result.put(e.getKey(),temp);
        }
        return result;
    }
    
    public int tamanho() {
        return (int)this.msgBox.values().stream()
        .mapToInt(a -> a.size())
        .sum();
    }
    
    public int quantosDe(String remetente) {
        return (int)this.msgBox.values()
        .stream()
        .mapToInt(a -> (int)a.stream()
            .map(msg -> msg.getRemetente())
            .filter(rem -> rem.equals(remetente))
            .count()).sum();
    }
    
    public void antiSpam(String palavra) {
        this.msgBox.values()
        .stream()
        .forEach(a -> a
            .stream()
            .filter(msg -> msg.getAssunto().equals(palavra))
            .forEach(msg -> a.remove(msg)));
    }
    
    public Map<String,List<Mensagem>> msgDeRemetente() {
        TreeMap<String,List<Mensagem>> result = new TreeMap<>();
        for (Map.Entry<String,ArrayList<Mensagem>> en : this.msgBox.entrySet()) {
            for(Mensagem m : en.getValue()) {
                if (!result.containsKey(m.getRemetente()))
                    result.put(m.getRemetente(),new ArrayList<>());
                result.get(m.getRemetente()).add(m.clone());
            }
        }
        return result;
    }
}
