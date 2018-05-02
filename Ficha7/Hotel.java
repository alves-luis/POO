
/**
 * Base Class for all the Hotel types
 *
 * @author Luís Alves
 * @version 1.3
 */



public class Hotel implements Comparable {
    // instance variables - replace the example below with your own
    private String cod;
    private String nome;
    private String local;
    private int categoria;
    private int quartosDisp;
    private double preco;



    /**
     * Constructor for objects of class Hotel
     */
    public Hotel() {
        this.cod = "";
        this.nome = "";
        this.local = "";
        this.categoria = 0;
        this.quartosDisp = 0;
        this.preco = 0;
    }

    public Hotel(String cod, String nome, String local, int cat, int quartos, double preco) {
        this.cod = cod;
        this.nome = nome;
        this.local = local;
        this.categoria = cat;
        this.quartosDisp = quartos;
        this.preco = preco;
    }

    public Hotel(Hotel h) {
        this.cod = h.getCod();
        this.nome = h.getNome();
        this.local = h.getLocal();
        this.categoria = h.getCategoria();
        this.quartosDisp = h.getDisponiveis();
        this.preco = h.getPreco();
    }

    public Hotel(double preco) {
        this.cod = "";
        this.nome = "";
        this.local = "";
        this.categoria = 0;
        this.quartosDisp = 0;
        this.preco = preco;
    }

    public String getCod() {
        return this.cod;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLocal() {
        return this.local;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public int getDisponiveis() {
        return this.quartosDisp;
    }


    public double getPreco() {
        return this.preco;
    }


    public void setCod(String c) {
        this.cod = c;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setCategoria(int c) {
        this.categoria = c;
    }

    public void setDisponiveis(int d) {
        this.quartosDisp = d;
    }

    public void setPreco(double p) {
        this.preco = p;
    }


    public boolean equals(Object o) {
    if (this == o)
        return true;

    if (o == null || this.getClass() != o.getClass())
        return false;

    Hotel h = (Hotel) o;
    return (this.getCod().equals(h.getCod()));
    }

    public Hotel clone() {
        return new Hotel(this);
    }

    public int compareTo(Object o) {
      Hotel h = (Hotel) o;
      int res = this.getCategoria() - h.getCategoria();
      return (res) == 0 ? 1 : res;
    }

    public String toString() {
      StringBuilder buf = new StringBuilder();
      buf.append("Código: ");buf.append(this.getCod());buf.append("\n");
      buf.append("Nome: ");buf.append(this.getNome());buf.append("\n");
      buf.append("Local: ");buf.append(this.getLocal());buf.append("\n");
      buf.append("Categoria: ");buf.append(this.getCategoria());buf.append("\n");
      buf.append("Quartos disp: ");buf.append(this.getDisponiveis());buf.append("\n");
      buf.append("Preço: ");buf.append(this.getPreco());buf.append("\n");
      return buf.toString();
    }

}
