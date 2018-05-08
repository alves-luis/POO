
/**
 * Class that represents a Hotel whose price is increased by a luxury tax
 *
 * @author Luís Alves
 * @version 1.3
 */
public class HotelPremium extends Hotel implements CartaoHoteis{
    private double taxaDeLuxo;
    private int pontosPorEuro;

    /**
     * Constructor for objects of class HotelStandard
     */
    public HotelPremium() {
        super();
        this.taxaDeLuxo = 0;
        this.pontosPorEuro = 0;
    }

    public HotelPremium(double taxa) {
        super();
        this.taxaDeLuxo = taxa;
        this.pontosPorEuro = 0;
    }

    public HotelPremium(double taxa, String cod, String nome, String local, int cat, int quartos, double preco) throws HotelParametersException {
      super(cod,nome,local,cat,quartos,preco);
      this.taxaDeLuxo = taxa;
      this.pontosPorEuro = 0;
    }

    public HotelPremium(Hotel h) {
      super(h);
      this.taxaDeLuxo = 0;
      this.pontosPorEuro = 0;
    }

    public HotelPremium(HotelPremium h) {
        super(h);
        this.taxaDeLuxo = h.getTaxaDeLuxo();
        this.pontosPorEuro = h.getPontosPorEuro();
    }

    public double getTaxaDeLuxo() {
      return this.taxaDeLuxo;
    }

    public void setTaxaDeLuxo(double tax) throws HotelParametersException {
      if (tax < 0) throw new HotelParametersException("taxa de luxo");
      else this.taxaDeLuxo = tax;
    }

    public double getPreco() {
        return (super.getPreco())*(1+this.taxaDeLuxo);
    }

    public int getPontosPorEuro() {
        return this.pontosPorEuro;
    }

    public void setPontosPorEuro(int ppe) {
        this.pontosPorEuro = ppe;
    }

    public HotelPremium clone() {
      return new HotelPremium(this);
    }
    

}
