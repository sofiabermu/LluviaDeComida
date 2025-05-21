/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.models;

import java.awt.Point;
import java.util.ArrayList;

/**
 * representa un mecanismo de interacción que permite
 * al jugador eliminar objetos del cielo (comida o veneno) mediante clics.
 * 
 * Si el jugador hace clic sobre una comida, se suma un punto al puntaje.
 * Si hace clic sobre un veneno, se restan dos puntos.
 *
 * @author sofia bermudez
 * @since 19052025
 * @version 1.0.0
 */
public class Arma {
    
    //Constructor por defecto

    public Arma() {
    }
    
     /**
     * Usa el arma en una posición específica del juego.
     * Si se detecta una colisión con una Comida, esta se elimina del cielo y se incrementa el puntaje en 1. 
     * Si se detecta una colisión con un Veneno, este se elimina y se reduce el puntaje en 2.
     *
     * @param cielo el objeto Cielo que contiene la comida y el veneno
     * @param x coordenada X del clic del jugador
     * @param y coordenada Y del clic del jugador
     */
    
    public void usar(Cielo cielo, int x, int y){
        
        Point click = new Point(x, y);
        ArrayList<Comida> comidas = cielo.getComida();
        ArrayList<Veneno> venenos = cielo.getVeneno();
        
        for (int i = 0; i < comidas.size(); i++) {
            Comida comida = comidas.get(i);
            if (comida.getBoundaries().contains(click)) {
                cielo.aumentarPuntaje(1);
                comidas.remove(i);
                return;
            }
        }
        
        for (int i = 0; i < venenos.size(); i++) {
            Veneno veneno = venenos.get(i);
            if (veneno.getBoundaries().contains(click)) {
                cielo.disminuirPuntaje(2);
                venenos.remove(i);
                return;
            }
        }
        
    }
    
}
