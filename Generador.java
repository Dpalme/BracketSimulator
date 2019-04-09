/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

https://stackoverflow.com/questions/5770990/sorting-tournament-seeds/45572051#45572051
 */

package BracketSimulator;

public class Generador {
    private Equipo[][][] bracket;
    
    public Equipo[][][] generar(Equipo[] equipos, int tipo){
        if(tipo == 0){
            return RoundRobin(equipos);
        }
        
        if(tipo == 1){
            return SingleElimination(equipos);
        }
        
        if(tipo == 2){
            return DoubleElimination(equipos);
        }
        else{
            return null;
        }
    }
    
    private Equipo[][][] RoundRobin(Equipo[] equipos){
        int rounds = equipos.length - 1;
        int size = (int)Math.ceil(equipos.length/2);
        bracket = new Equipo[rounds][size][2];
        
        return bracket;
    }
    
    private Equipo[][][] DoubleElimination(Equipo[] equipos){
        int rounds = (int)Math.ceil(Math.log(equipos.length)/Math.log(2));
        int size = (int)Math.ceil(equipos.length/2);
        bracket = new Equipo[size][rounds][2];
        for(int i = 0; i < size; i++){
            bracket[i][0][0] = equipos[i];
        } 
        for(int i = 0; i < size; i++){
            bracket[i][0][1] = equipos[i+(int)Math.floor(equipos.length/2)];
        }
        
        return bracket;
    }
    
    private Equipo[][][] SingleElimination(Equipo[] equipos){
        int rounds = (int)Math.ceil(Math.log(equipos.length)/Math.log(2));
        int size = (int)Math.ceil(equipos.length/2);
        bracket = new Equipo[size][rounds][2];
        for(int i = 0; i < size; i++){
            bracket[i][0][0] = equipos[i];
        } 
        for(int i = 0; i < size; i++){
            bracket[i][0][1] = equipos[i+(int)Math.floor(equipos.length/2)];
        }
        
        return bracket;
    }
}
