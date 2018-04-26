
/**
 * Write a description of class HotelDiscount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotelDiscount extends HotelStandard{

    /**
     * Constructor for objects of class HotelStandard
     */
    public HotelDiscount() {
        super();
    }

    public HotelDiscount(HotelDiscount h) {
        super(h);
    }

    public HotelDiscount(String cod, String nome, String local, int cat, int quartos, int total, double preco) {
      super(cod,nome,local,cat,quartos,total,preco);
    }

    public double getPreco() {
        return super.getPreco()*(0.4*this.getOcupacao()+0.5);
    }

    public HotelDiscount clone() {
      return new HotelDiscount(this);
    }
}
