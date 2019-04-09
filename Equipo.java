/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BracketSimulator;

import java.util.concurrent.ThreadLocalRandom; //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java


public class Equipo {
    public String nombre;
    protected int ranking;
    public int seed;
    public float synergy;
    protected Jugador[] jugadores;

    public Equipo(String nombre, float synergy, int seed, Jugador[] jugadores) {
        this.nombre = nombre;
        this.synergy = synergy;
        this.seed = seed;
        this.jugadores = jugadores;
        this.ranking = calcularRanking();
    }
    
    public int roll(){
        return ThreadLocalRandom.current().nextInt(0, this.ranking + 1);
    }
    
    private int calcularRanking(){
        float pr = 0;
        for(Jugador jugador : jugadores){
            pr += jugador.getRanking() * this.synergy/10;
        }
        return (int)Math.floor(pr);
    }
    
    public int getRanking(){
        return ranking;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setSynergy(int synergy) {
        this.synergy = synergy;
        this.ranking = calcularRanking();
    }

    public String getNombre() {
        return nombre;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.ranking = calcularRanking();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSeed() {
        return seed;
    }

    public float getSynergy() {
        return synergy;
    }
    
    private String getPlayerNames(){
        String finalString = "";
        for (Jugador jugador : jugadores){
            finalString += jugador.toString();
        }
        return finalString;
    }

    @Override
    public String toString() {
        return String.format("Equipo %s. jugadores[%s]", nombre, getPlayerNames());
    }
    
    
    
}
