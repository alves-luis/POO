/**
 * Exception handler for a HotelParameter
 *
 * @author Luís Alves
 * @version 1.0
 */
public class HotelParametersException extends Exception{
  public HotelParametersException(String msg) {
    super("Parametro invalido a criar Hotel: " + msg);
  }
}
