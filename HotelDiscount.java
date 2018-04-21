
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

    public double getTaxaDeLuxo() {
      return this.taxaDeLuxo;
    }

    public void setTaxaDeLuxo(double tax) {
      this.taxaDeLuxo = tax;
    }

    public double getPreco() {
        return super.getPreco()*(1+this.taxaDeLuxo);
    }

    public HotelDiscount clone() {
      return new HotelDiscount(this);
    }
}
