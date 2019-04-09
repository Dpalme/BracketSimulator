/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BracketSimulator;

public class Jugador {
    private int ranking;
    private final String nombre;

    public Jugador(int ranking, String nombre) {
        this.ranking = ranking;
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString(){
        return String.format("Nombre: %s",(this.nombre));
    }
}
