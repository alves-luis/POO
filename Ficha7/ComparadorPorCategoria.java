
/**
 * Comparador por Categoria.
 *
 * @author Luis Alves
 * @version 1.1
 */
import java.util.Comparator;

public class ComparadorPorCategoria implements Comparator<Hotel> {
  public int compare(Hotel h1, Hotel h2) {
    int res = h1.getCategoria() - h2.getCategoria();
    return (res) == 0 ? 1 : res ; 
  }
}
