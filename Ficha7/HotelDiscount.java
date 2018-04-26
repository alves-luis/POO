
/**
 * Class that represents a Hotel, whose price is linearly related to its
 * occupation rate
 *
 * @author Luís Alves
 * @version 1.1
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
