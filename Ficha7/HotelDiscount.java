
/**
 * Class that represents a Hotel, whose price is linearly related to its
 * occupation rate
 *
 * @author Luís Alves
 * @version 1.2
 */
public class HotelDiscount extends HotelStandard{

    private double ocupacao;
    /**
     * Constructor for objects of class HotelStandard
     */
    public HotelDiscount() {
        super();
        this.ocupacao = 0;
    }

    public HotelDiscount(HotelDiscount h) {
        super(h);
        this.ocupacao = h.getOcupacao();
        try {
            this.setPreco(h.getPreco()/(0.4*this.ocupacao+0.5));
        }
        catch (HotelParametersException e) {
            this.ocupacao = 0;
        }
    }

    public HotelDiscount(Hotel h) {
      super(h);
      this.ocupacao = 0;
    }

    public HotelDiscount(String cod, String nome, String local, int cat, int quartos, double ocup, double preco) throws HotelParametersException {
      super(cod,nome,local,cat,quartos,preco);
      this.ocupacao = ocup;
    }

    public double getOcupacao() {
      return this.ocupacao;
    }

    public void setOcupacao(double oc) throws HotelParametersException{
      if (oc < 0) throw new HotelParametersException("ocupação");
      else this.ocupacao = oc;
    }

    public double getPreco() {
        return super.getPreco()*(0.4*this.ocupacao+0.5);
    }

    public HotelDiscount clone() {
      return new HotelDiscount(this);
    }
}
