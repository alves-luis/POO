import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

/**
 * Class that implements a grouping of Hotels of different types
 *
 * @author Luís Alves
 * @version 1.1
 */
public class HotelInc {
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
      if (tipo == "Standard")
        return (int)this.hoteis.values().stream().filter(h -> h.getClass().equals(HotelStandard.class)).count();
      if (tipo == "Premium")
        return (int)this.hoteis.values().stream().filter(h -> h.getClass().equals(HotelPremium.class)).count();
      if (tipo == "Discount")
        return (int)this.hoteis.values().stream().filter(h -> h.getClass().equals(HotelDiscount.class)).count();
      if (tipo == "Hotel")
        return (int)this.hoteis.values().stream().filter(h -> h.getClass().equals(Hotel.class)).count();
      else return 0;
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
      return this.hoteis.values().stream().mapToDouble(h -> h.getPreco()*h.getCapacidade()).sum();
    }

}
