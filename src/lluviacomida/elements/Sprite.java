/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Clase abstracta que representa un sprite, es decir, un objeto visual en el juego con posición, tamaño,
 * color e imagen. Puede interactuar con otros sprites y detectar colisiones.
 *
 * @author SOFIA RUDAS
 * @since 19052025
 * @version 1.0.0
 */
public abstract class Sprite {
    
     //Coordenada horizontal del sprite 
    public int x;
    
     //Coordenada vertical del sprite
    public int y;
    
    //Alto del sprite
    public int height;
    
    //Ancho del sprite
    public int width;
    
     //Color del sprite 
    protected Color color;
    
    //Imagen del sprite
    protected ImageIcon image;
    
    //Contenedor gráfico al cual pertenece el sprite
    protected GraphicContainer gameContainer;
    
    /**
     * Constructor que inicializa la posición y tamaño del sprite.
     * 
     * @param x coordenada horizontal inicial
     * @param y coordenada vertical inicial
     * @param height altura del sprite
     * @param width ancho del sprite
     */
    
    public Sprite(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    /**
     * Verifica si el sprite está fuera de los límites de su contenedor gráfico.
     * 
     * @return true si está fuera del contenedor, false en caso contrario
     */
    
    public boolean isOutOfGraphicContainer(){
        return isOutOfGraphicContainer(x, y, width, height);
    }
    
    /**
     * Verifica si un área con coordenadas y dimensiones específicas está fuera del contenedor gráfico.
     * 
     * @param x coordenada X del área a verificar
     * @param y coordenada Y del área a verificar
     * @param width ancho del área
     * @param height alto del área
     * @return true si el área está fuera del contenedor, false en caso contrario
     */
    
    public boolean isOutOfGraphicContainer(int x, int y, int width, int height){
        if(gameContainer == null)
            return false;
        
        Rectangle bounds = gameContainer.getBoundaries();
        
        return !(x >= bounds.getX() &
                 y >= bounds.getY() &
                 x + width  <= bounds.getX() + bounds.getWidth() &
                 y + height <= bounds.getY() + bounds.getHeight());
    }
    
    /**
     * Verifica si este sprite colisiona con otro sprite dado.
     * 
     * @param other el otro sprite con el cual se desea verificar colisión
     * @return true si hay colisión, false si no la hay
     */
    
    public boolean checkCollision(Sprite other){
        
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
            this.getX() < other.getX() + other.getWidth();

        
        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
            this.getY() < other.getY() + other.getHeight();

        
        return collisionX && collisionY;        
    }
    
    /**
     * Método abstracto que debe implementar cada subclase para dibujar el sprite en pantalla.
     * 
     * @param g el contexto gráfico donde se pintará el sprite
     */
    
    public abstract void paint(Graphics g);
    
    //Metodos setters y getters
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public void setGraphicContainer(GraphicContainer gContainer) {
        this.gameContainer = gContainer;
    }
    
    public GraphicContainer getGraphicContainer(GraphicContainer gContainer) {
        return gContainer;
    }
    
}
