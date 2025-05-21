/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;
import lluviacomida.elements.SpriteContainer;
import javax.swing.ImageIcon;

/**
 * La clase Veneno representa un objeto visual que cae desde la parte superior de la pantalla
 * y simboliza un elemento dañino para el jugador.
 *
 * @author SOFIA RUDAS
 * @since 19052025
 * @version 1.0.0
 */
public class Veneno extends SpriteContainer {
    
    /**
     * Crea un objeto Veneno con las coordenadas y dimensiones especificadas.
     * 
     * @param x coordenada x del veneno
     * @param y coordenada y del veneno
     * @param height alto del objeto
     * @param width ancho del objeto
     */
    
    public Veneno(int x, int y, int height, int width){
        super(x, y, height, width);
    }
    
    /**
     * Crea un objeto Veneno con una posición horizontal aleatoria
     * La posición vertical inicial es 0, y las dimensiones son 50x50 píxeles.
     */
    
    public Veneno() {
        super((int)(Math.random() * 400), 0, 50, 50); 
        this.image = new ImageIcon(getClass().getResource("/lluviacomida/images/Veneno.png"));
    }
    
    /**
     * Dibuja la imagen del objeto veneno en el componente gráfico.
     * 
     * @param g el contexto gráfico donde se dibuja la imagen
     */

    @Override
    public void paint(Graphics g) {
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
    
    /**
     * Actualiza el estado del veneno. No realiza ninguna acción en esta implementación
     * 
     */

    @Override
    public void refresh() {
    }
    
    /**
     * Retorna los límites del objeto Veneno como un rectángulo.
     * Esto se utiliza para detectar colisiones.
     * 
     * @return un objeto {@link Rectangle} con los límites del objeto
     */

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);  
    } 
    
}
