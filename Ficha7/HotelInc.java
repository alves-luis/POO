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
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * Class that implements a grouping of Hotels of different types
 *
 * @author Luís Alves
 * @version 1.5
 */
public class HotelInc implements Serializable {
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

    public HotelInc(HotelInc h) {
      this.hoteis = new HashMap<>();
      h.getHoteis().stream().forEach(t -> this.hoteis.put(t.getNome(),t.clone()));
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

    public Hotel getHotel(String cod) throws HotelException {
        if (this.existeHotel(cod))
          return this.hoteis.get(cod).clone();
        else
          throw new HotelException("Não existe Hotel com esse código!");
    }

    public void adiciona(Hotel h) throws HotelException {
      if (h == null)
        throw new HotelException("Hotel inválido!");
      if (!this.existeHotel(h.getCod()))
        this.hoteis.put(h.getCod(),h.clone());
      else
        throw new HotelException("Não é possível adicionar hoteis repetidos!");
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

    public void escreveEmFicheiroCSV(String ficheiro) throws IOException {
      PrintWriter fich = new PrintWriter(ficheiro);
      StringBuilder sb = new StringBuilder();
      sb.append("codigo"); sb.append(',');
      sb.append("nome"); sb.append(',');
      sb.append("local"); sb.append(',');
      sb.append("categoria"); sb.append(',');
      sb.append("quartos"); sb.append(',');
      sb.append("preço"); sb.append(',');
      sb.append("epoca"); sb.append(',');

      fich.println(sb.toString());
      this.hoteis.values().stream().forEach(h -> fich.println(h.toString()));
      fich.flush();
      fich.close();
    }

    public void guardaEstadoObject(String ficheiro) throws FileNotFoundException, IOException {
      FileOutputStream fos = new FileOutputStream(ficheiro);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.flush();
      oos.close();
    }

    public static HotelInc carregaEstadoObject(String ficheiro) throws FileNotFoundException, IOException, ClassNotFoundException {
      FileInputStream fich = new FileInputStream(ficheiro);
      ObjectInputStream ois = new ObjectInputStream(fich);
      HotelInc h = (HotelInc) ois.readObject();
      ois.close();
      return h;
    }

    public boolean equals(Object o) {
      if (o == this)
        return true;

      if (o == null || o.getClass() != this.getClass())
        return false;

      HotelInc i = (HotelInc) o;
      return this.hoteis.equals(i.getHoteis());
    }

    public String toString() {
      return this.hoteis.toString();
    }

    public HotelInc clone() {
      return new HotelInc(this);
    }
}
