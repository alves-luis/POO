package Parte_3;


/**
 * @author Luís Alves
 * @version 03-06-2018
 */

public class Tempo implements Comparable<Tempo> {
    private int minutos;
    private int segundos;

    public Tempo() {
        minutos = 0;
        segundos = 0;
    }
    
    public Tempo(Tempo t) {
        minutos = t.getMinutos();
        segundos = t.getSegundos();
    }
    
    public int getMinutos() {
        return minutos;
    }
    
    public int getSegundos() {
        return segundos;
    }
    
    public Tempo clone() {
        return new Tempo(this);
    }
    
    public void setTempo(int minutos, int segundos) {
        minutos = minutos;
        segundos = segundos;
    }
    
    public int compareTo(Tempo t) {
        return (this.minutos - t.getMinutos() == 0 ? this.segundos - t.getSegundos() : this.minutos - t.getMinutos());
    }
}
