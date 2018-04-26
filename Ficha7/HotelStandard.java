
/**
 * Class that represents a hotel whose price changes by +20 given a season
 * (high or low)
 *
 * @author Luís Alves
 * @version 1.1
 */
public class HotelStandard extends Hotel{
    public static final boolean ALTA = true;
    public static final boolean BAIXA = false;
    private boolean epoca;

    /**
     * Constructor for objects of class HotelStandard
     */
    public HotelStandard() {
        super();
        this.epoca = ALTA;
    }

    public HotelStandard(String cod, String nome, String local, int cat, int quartos, int total, double preco) {
      super(cod,nome,local,cat,quartos,total,preco);
      this.epoca = BAIXA;
    }

    public HotelStandard(boolean epoca, String cod, String nome, String local, int cat, int quartos, int total, double preco) {
      super(cod,nome,local,cat,quartos,total,preco);
      this.epoca = epoca;
    }

    public HotelStandard(boolean epocaAlta) {
        super();
        this.epoca = epocaAlta;
    }

    public HotelStandard(HotelStandard h) {
        super(h);
        this.epoca = h.getEpoca();
    }

    public boolean getEpoca() {
        return this.epoca;
    }

    public void setEpoca(boolean epoca) {
        this.epoca = epoca;
    }

    public double getPreco() {
        return this.epoca == ALTA ? super.getPreco()+20 : super.getPreco();
    }

    public HotelStandard clone() {
      return new HotelStandard(this);
    }

    public String toString() {
      String epoca = this.getEpoca() == ALTA ? "Alta" : "Baixa";
      String result = "Epoca: " + epoca + "\n";
      return super.toString() + result;

    }
}
