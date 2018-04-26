
/**
 * Class that represents a Hotel whose price is increased by a luxury tax
 *
 * @author Luís Alves
 * @version 1.1
 */
public class HotelPremium extends Hotel{
    public double taxaDeLuxo;

    /**
     * Constructor for objects of class HotelStandard
     */
    public HotelPremium() {
        super();
        this.taxaDeLuxo = 0;
    }

    public HotelPremium(double taxa) {
        super();
        this.taxaDeLuxo = taxa;
    }

    public HotelPremium(double taxa, String cod, String nome, String local, int cat, int quartos, int total, double preco) {
      super(cod,nome,local,cat,quartos,total,preco);
      this.taxaDeLuxo = taxa;
    }

    public HotelPremium(HotelPremium h) {
        super(h);
        this.taxaDeLuxo = h.getTaxaDeLuxo();
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

    public HotelPremium clone() {
      return new HotelPremium(this);
    }

}
