
/**
 * Class that represents a hotel whose price changes by +20 given a season
 * (high or low)
 *
 * @author Luís Alves
 * @version 1.2
 */
public class HotelStandard extends Hotel implements CartaoHoteis{
    public static final boolean ALTA = true;
    public static final boolean BAIXA = false;
    private boolean epoca;
    private int pontosPorEuro;

    /**
     * Constructor for objects of class HotelStandard
     */
    public HotelStandard() {
        super();
        this.epoca = ALTA;
        this.pontosPorEuro = 0;
    }

    public HotelStandard(String cod, String nome, String local, int cat, int quartos, double preco) {
      super(cod,nome,local,cat,quartos,preco);
      this.epoca = BAIXA;
      this.pontosPorEuro = 0;
    }

    public HotelStandard(boolean epoca, String cod, String nome, String local, int cat, int quartos, double preco) {
      super(cod,nome,local,cat,quartos,preco);
      this.epoca = epoca;
      this.pontosPorEuro = 0;
    }

    public HotelStandard(boolean epocaAlta) {
        super();
        this.epoca = epocaAlta;
        this.pontosPorEuro = 0;
    }

    public HotelStandard(HotelStandard h) {
        super(h);
        this.epoca = h.getEpoca();
        this.pontosPorEuro = h.getPontosPorEuro();
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
    
    public void setPontosPorEuro(int ppe) {
        this.pontosPorEuro = ppe;
    }
    
    public int getPontosPorEuro() {
        return this.pontosPorEuro;
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
