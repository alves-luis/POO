package Parte_3;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Corrida {
    private ArrayList<TreeMap<String,Tempo>> temposPorVolta;

    public List<String> classificacaoNaVolta(int volta) throws VoltaInvalidaException {
       TreeMap<String,Tempo> tempoTotal = new TreeMap<>();
       // Começa o TempoTotal de acordo com a primeira volta
       for(Map.Entry<String,Tempo> en : temposPorVolta.get(0).entrySet())
           tempoTotal.put(en.getKey(),en.getValue());
       if(volta < 0) throw new VoltaInvalidaException();
       for(int n = 1; n < volta; n++) {
           TreeMap<String,Tempo> resultadoDaVolta = temposPorVolta.get(volta);
           if (resultadoDaVolta == null) throw new VoltaInvalidaException();
           // Adiciona os manos que continuaram na volta
           for(Map.Entry<String,Tempo> en : resultadoDaVolta.entrySet()) {
               int prevMinutos = tempoTotal.get(en.getKey()).getMinutos();
               int prevSegundos = tempoTotal.get(en.getKey()).getSegundos();
               Tempo novoTempo = new Tempo();
               novoTempo.setTempo(prevMinutos + en.getValue().getMinutos(),prevSegundos + en.getValue().getSegundos());
               tempoTotal.put(en.getKey(),novoTempo);
           }
           // Coloca os que desistiram com MAX_INT
           for(Map.Entry<String,Tempo> en : tempoTotal.entrySet()) {
               Tempo tempoMax = new Tempo();
               tempoMax.setTempo(Integer.MAX_VALUE,n);
               if (!resultadoDaVolta.containsKey(en.getKey()))
                    tempoTotal.put(en.getKey(),tempoMax);
           }
       }
       
       Comparator<Map.Entry<String,Tempo>> c = (k1,k2) -> k1.getValue().compareTo(k2.getValue());
       return tempoTotal.entrySet().stream().sorted(c).map(entry -> entry.getKey()).collect(Collectors.toList());
           
    }
    
    public Tempo tempoRecorde() {
        Tempo result = new Tempo();
        result.setTempo(Integer.MAX_VALUE,Integer.MIN_VALUE);
        for(TreeMap<String,Tempo> tempo : temposPorVolta) {
            for(Map.Entry<String,Tempo> en : tempo.entrySet()) {
                if (en.getValue().compareTo(result) < 0)
                result = en.getValue().clone();
            }
        }
        return result; 
    }
}
