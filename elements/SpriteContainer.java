/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.elements;

import java.util.ArrayList;

/**
 * Clase abstracta que representa un contenedor de sprites
 * Esta clase extiende Sprite e implementa la interfaz GraphicContainer
 *
 * @author sofia bermudez
 * @since 19052025
 * @version 1.0.0
 */
public abstract class SpriteContainer extends Sprite implements GraphicContainer{
    
    //Lista de sprites contenidos dentro de este contenedor.
    protected ArrayList<Sprite> sprites;
    
    /**
     * Constructor que inicializa la posición y tamaño del contenedor, y crea la lista de sprites internos.
     *
     * @param x coordenada horizontal del contenedor
     * @param y coordenada vertical del contenedor
     * @param height altura del contenedor
     * @param width ancho del contenedor
     */
    
    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        sprites = new ArrayList<Sprite>();
    }
    
    /**
     * Obtiene la coordenada vertical (Y) del contenedor.
     *
     * @return la posición vertical del contenedor
     */
    
    @Override
    public int getY() {
        return y;
    }
    
    /**
     * Establece la coordenada vertical (Y) del contenedor.
     *
     * @param y nueva posición vertical del contenedor
     */

    @Override
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Añade un sprite a la lista de sprites contenidos.
     *
     * @param sprite el sprite que se desea añadir
     * @return true si el sprite se añadió correctamente
     */
    
    public boolean add(Sprite sprite){
        return sprites.add(sprite);
    }
    
    /**
     * Elimina un sprite del contenedor por índice.
     *
     * @param index el índice del sprite a eliminar
     */
    
    public void remove(int index){
        sprites.remove(index);
    }
    
    /**
     * Elimina un sprite específico del contenedor.
     *
     * @param sprite el sprite que se desea eliminar
     */
    
    public void remove(Sprite sprite){
        sprites.remove(sprite);
    }
    
    /**
     * Devuelve la cantidad de sprites contenidos actualmente.
     *
     * @return número de sprites en el contenedor
     */
    
    public int size(){
        return sprites.size();
    }
    
}
