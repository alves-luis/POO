import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

/**
 * Write a description of class HotelInc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotelInc {
    private HashMap<String,Hotel> hoteis;
    private HashMap<String,Set<Hotel>> hoteisPorTipo;

    /**
     * Constructor for objects of class HotelInc
     */
    public HotelInc() {
        this.hoteis = new HashMap<>();
        this.hoteisPorTipo = new HashMap<>();
        this.hoteisPorTipo.put("Standard",new HashSet<Hotel>());
        this.hoteisPorTipo.put("Premium",new HashSet<Hotel>());
        this.hoteisPorTipo.put("Hotel",new HashSet<Hotel>());
        this.hoteisPorTipo.put("Discount",new HashSet<Hotel>());
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
      return this.hoteisPorTipo.get(tipo).size();
    }

    public Hotel getHotel(String cod) {
        return this.hoteis.get(cod).clone();
    }

    public void adiciona(Hotel h) {
        this.hoteis.put(h.getCod(),h.clone());
        String s = null;
        if (h instanceof Hotel)
          s = "Hotel";
        if (h instanceof HotelStandard)
            s = "Standard";
        if (h instanceof HotelDiscount)
            s = "Discount";
        if (h instanceof HotelPremium)
            s = "Premium";
        HashSet<Hotel> res = (HashSet) this.hoteisPorTipo.get(s);
        res.add(h.clone());
        this.hoteisPorTipo.put(s,res);
    }

    public List<Hotel> getHoteis() {
        return this.hoteis.values().stream().map(h -> h.clone()).collect(Collectors.toList());
    }

    public void adiciona(Set<Hotel> hs) {
        hs.stream().forEach(h -> this.hoteis.put(h.getCod(),h.clone()));
        String s = null;
        for(Hotel h : hs) {
          if (h instanceof Hotel)
            s = "Hotel";
          if (h instanceof HotelStandard)
              s = "Standard";
          if (h instanceof HotelDiscount)
              s = "Discount";
          if (h instanceof HotelPremium)
              s = "Premium";
          HashSet<Hotel> res = (HashSet) this.hoteisPorTipo.get(s);
          res.add(h.clone());
          this.hoteisPorTipo.put(s,res);
        }
    }

    public void mudaPara(boolean epoca) {
      this.hoteis.values().stream()
          .filter(h -> h instanceof HotelStandard)
          .map(h -> (HotelStandard) h)
          .forEach(h -> h.setEpoca(epoca));
      this.hoteisPorTipo.get("Standard").stream()
          .filter(h -> h instanceof HotelStandard)
          .map(h -> (HotelStandard) h)
          .forEach(h -> h.setEpoca(epoca));
    }

    public double getMaxReceitaDiaria() {
      return this.hoteis.values().stream().mapToDouble(h -> h.getPreco()*h.getCapacidade()).sum();
    }

}
