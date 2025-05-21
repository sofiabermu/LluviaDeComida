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
 * La clase Comida representa un objeto que cae desde la parte superior de la pantalla.
 *  
 * @author sofia bermudez
 * @since 19052025
 * @version 1.0.0
 * 
 */
public class Comida extends SpriteContainer{
    
    /**
     * Crea un objeto Comida con las coordenadas y dimensiones especificadas.
     * 
     * @param x coordenada x de la comida
     * @param y coordenada y de la comida
     * @param height alto del objeto
     * @param width ancho del objeto
     */
    
    public Comida(int x, int y, int height, int width) {
        super(x, y, height, width);
    }
    
    /**
     * Crea un objeto Comida con una posición horizontal aleatoria  
     * 
     * La posición vertical inicial es 0, y las dimensiones son 50x50 píxeles.
     */
    
    public Comida() {
        super((int)(Math.random() * 400), 0, 50, 50); 
        this.image = new ImageIcon(getClass().getResource("/lluviacomida/images/Comida.png"));
    }
    
    /**
     * Dibuja la imagen del objeto comida en el componente gráfico.
     * 
     * @param g el contexto gráfico donde se dibuja la imagen
     */
  
    @Override
    public void paint(Graphics g) {
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
    
    /**
     * Actualiza el estado de la comida. No realiza ninguna acción en esta implementación
     * 
     */

    @Override
    public void refresh() {
    }
    
    /**
     * Retorna los límites del objeto Comida como un rectángulo.
     * Esto se utiliza para detectar colisiones.
     * 
     * @return un objeto Rectangle con los límites del objeto
     */

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);  
    }  
}
