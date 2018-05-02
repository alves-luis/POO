
/**
 * 
 *
 * @author Luis Alves
 * @version 1.0
 */

import java.util.Comparator;

public class ComparadorPorNumeroQuartos implements Comparator<Hotel> {
    public int compare(Hotel h1, Hotel h2) {
        return h1.getDisponiveis() - h2.getDisponiveis();
    }
}