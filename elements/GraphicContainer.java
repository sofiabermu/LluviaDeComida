/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lluviacomida.elements;

import java.awt.Rectangle;

/**
 *  Interfaz que define el comportamiento básico de un contenedor gráfico en el juego
 *
 * @author sofia bermudez
 * @since 19052025
 * @version 1.0.0
 */
public interface GraphicContainer {
    
    /**
     * Refresca o repinta visualmente el contenedor gráfico. 
     * Este método debe ser implementado para actualizar la visualización de los sprites.
     */
    public void refresh();
    
    /**
     * Devuelve los límites (dimensiones y posición) del contenedor gráfico, representados como un rectángulo.
     * 
     * @return un objeto Rectangle que representa los límites del contenedor
     */
    public Rectangle getBoundaries();
}
