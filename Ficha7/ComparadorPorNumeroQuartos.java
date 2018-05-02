
/**
 *
 *
 * @author Luis Alves
 * @version 1.1
 */

import java.util.Comparator;

public class ComparadorPorNumeroQuartos implements Comparator<Hotel> {
    public int compare(Hotel h1, Hotel h2) {
        int res = h1.getDisponiveis() - h2.getDisponiveis();
        return (res) == 0 ? 1 : res ;
    }
}
