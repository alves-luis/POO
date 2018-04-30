import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Map;
import java.util.Iterator;

/**
 * Class that implements a grouping of Hotels of different types
 *
 * @author Luís Alves
 * @version 1.2
 */
public class HotelInc {
    private static Map<String,Comparator<Hotel>> comparadores = new HashMap<>();

    public static void addComparador(Comparator<Hotel> c, String nome) {
        comparadores.put(nome,c);
    }

    public static Comparator<Hotel> getComparador(String nome) {
        return comparadores.get(nome);
    }

    private HashMap<String,Hotel> hoteis;

    /**
     * Constructor for objects of class HotelInc
     */
    public HotelInc() {
        this.hoteis = new HashMap<>();
    }

    public boolean existeHotel(String cod) {
        return this.hoteis.containsKey(cod);
    }

    public int quantos() {
        return this.hoteis.size();
    }

    public int quantos(String loc) {
        return (int) this.hoteis.values().stream().filter(h -> h.getLocal().equals(loc)).count();
    }

    public int quantosT(String tipo) {
      return (int) this.hoteis.values().stream().filter(h -> h.getClass().getSimpleName().equals(tipo)).count();
    }

    public Hotel getHotel(String cod) {
        return this.hoteis.get(cod).clone();
    }

    public void adiciona(Hotel h) {
        this.hoteis.put(h.getCod(),h.clone());
    }

    public List<Hotel> getHoteis() {
        return this.hoteis.values().stream().map(h -> h.clone()).collect(Collectors.toList());
    }

    public void adiciona(Set<Hotel> hs) {
        hs.stream().forEach(h -> this.hoteis.put(h.getCod(),h.clone()));
    }

    public void mudaPara(boolean epoca) {
      this.hoteis.values().stream()
          .filter(h -> h instanceof HotelStandard)
          .map(h -> (HotelStandard) h)
          .forEach(h -> h.setEpoca(epoca));
    }

    public double getMaxReceitaDiaria() {
      return this.hoteis.values().stream().mapToDouble(h -> h.getPreco()*h.getDisponiveis()).sum();
    }

    public List<CartaoHoteis> daoPontos() {
        return this.hoteis.values().stream()
        .filter(h -> h instanceof CartaoHoteis)
        .map(Hotel :: clone)
        .map(h -> (CartaoHoteis) h)
        .collect(Collectors.toList());
    }

    public TreeSet<Hotel> ordenarHoteis() {
      return this.hoteis.values().stream().map(Hotel :: clone).collect(Collectors.toCollection(TreeSet :: new));
    }

    public TreeSet<Hotel> ordenarHoteis(Comparator<Hotel> c) {
      return this.hoteis.values().stream().map(Hotel :: clone).collect(Collectors.toCollection(() -> new TreeSet(c)));
    }

    public Iterator<Hotel> ordenarHoteis(String criterio) {
        return ordenarHoteis(getComparador(criterio)).iterator();
    }
}
