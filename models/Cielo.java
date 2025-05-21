/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import lluviacomida.elements.SpriteContainer;

/**
 *  La clase Cielo representa el entorno en el que cae comida y veneno en el juego.
 *
 * @author SOFIA RUDAS
 * @since 19052025
 * @version 1.0.0
 */
public class Cielo extends SpriteContainer{
    
    /**
     * Lista de Comida activa en el juego
     */
    private ArrayList<Comida> comida;
    
    /**
     * Lista de Veneno activo en el juego
     */
    private ArrayList<Veneno> veneno;
    
    // Puntaje del jugador
    int puntaje = 0;
    
    //Puntaje maximo alcanzado (cargado y guardadoen un archivo
    int puntajeMaximo = 0;
    
    //Hilo encargado de generar el veneno
    private GeneradorVeneno generarVeneno;
    
    //Hilo encargado de generar la comida
    private GeneradorComida generarComida;
    
    //Ruta donde se guarda el puntaje maximo
    private final String archivoPuntaje = "C:/Users/sofia/OneDrive/Desktop/LluviaComida/puntaje_maximo.txt";
    
    private Random random = new Random();
    public static final int SPEED = 4;
    
     /**
     * Constructor que inicializa el objeto Cielo
     * 
     * @param x coordenada x del cielo
     * @param y coordenada y del cielo
     * @param height alto del cielo
     * @param width ancho del cielo
     */
    
    public Cielo(int x, int y, int height, int width){
        super(x,y,height, width);
        comida = new ArrayList<>();
        veneno = new ArrayList<>();
        cargarPuntajeMaximo();
        generarVeneno = new GeneradorVeneno(this);
        generarComida = new GeneradorComida(this);
        generarVeneno.start();
        generarComida.start();
    }
    
    /**
     * Agrega un nuevo objeto Comida en una posición aleatoria 
     */
    
    public void agregarComida(){
        
        Comida nueva;
        boolean colision;
        
        do{
            int comida_x = random.nextInt(width - 50);
            int comida_y = random.nextInt(height - 50);
            
            nueva = new Comida(comida_x, comida_y, 50,50);
            colision = false;
          
        }while(colision);
        
        comida.add(nueva);    
    }
    
    /**
     * Agrega un nuevo objeto Veneno en una posición aleatoria 
     */
    
    public void agregarVeneno(){
        
        Veneno nuevo;
        boolean colision;
        
        do{
            int veneno_x = random.nextInt(width - 50);
            int veneno_y = random.nextInt(height - 50);
            
            nuevo = new Veneno(veneno_x, veneno_y, 50,50);
            colision = false;
            
        }while(colision);
        
        veneno.add(nuevo);      
    }
    
    /**
     * Devuelve la lista de objetos Comida
     * 
     * @return lista de comida
     */

    public ArrayList<Comida> getComida() {
        return comida;
    }
    
    /**
     * Devuelve la lista de objetos Veneno
     * 
     * @return lista de veneno
     */

    public ArrayList<Veneno> getVeneno() {
        return veneno;
    }
    
    /**
     * Retorna el puntaje actual del jugador.
     * 
     * @return puntaje actual
     */

    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Retorna el puntaje máximo alcanzado.
     * 
     * @return puntaje máximo
     */

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    } 
    
    /**
     * Aumenta el puntaje del jugador y actualiza el puntaje máximo si es necesario.
     * 
     * @param puntos cantidad de puntos a agregar
     */
    
    public void aumentarPuntaje(int puntos) {
        puntaje += puntos;
        if (puntaje > puntajeMaximo) {
            puntajeMaximo = puntaje;
            guardarPuntajeMaximo();
        }
    }
    
     /**
     * Disminuye el puntaje del jugador y guarda el puntaje máximo.
     * 
     * @param puntos cantidad de puntos a restar
     */
    
    public void disminuirPuntaje(int puntos){
        puntaje -= puntos;
        guardarPuntajeMaximo();
    }
    
    /**
     * Guarda el puntaje máximo en un archivo.
     */
    
    public void guardarPuntajeMaximo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPuntaje))) {
            bw.write(String.valueOf(puntajeMaximo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Carga el puntaje máximo desde un archivo.
     */
    
    private void cargarPuntajeMaximo() {
        
        File archivo = new File(archivoPuntaje);
        if (!archivo.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
            if (linea != null) {
                puntajeMaximo = Integer.parseInt(linea);
            }
        } catch (IOException | NumberFormatException e) {
            puntajeMaximo = 0;
        }
    }
    
    /**
     * Detiene los hilos de generación de comida y veneno, y guarda el puntaje máximo.
     */
    
    public void detenerJuego() {
        if (generarComida != null && generarVeneno != null) {
            generarComida.detener();
            generarVeneno.detener();
        }
        guardarPuntajeMaximo();
    }
    
    /**
     * Dibuja todos los objetos de comida y veneno en el contexto gráfico.
     * 
     * @param g el contexto gráfico donde se dibujan los elementos
     */

    @Override
    public void paint(Graphics g) {
        
        for(int i = 0; i < comida.size(); i++ ){
            comida.get(i).paint(g);
        }
        
        for(int i = 0; i < veneno.size(); i++ ){
            veneno.get(i).paint(g);
        } 
    }
    
    /**
     * Actualiza la posición de todos los elementos de comida y veneno, y elimina los que salen de la pantalla.
     */

    @Override
    public void refresh() {
        
        for(int i = 0; i < comida.size(); i++ ){
            Comida c = comida.get(i);
            moverComida(c);
            if (comida.get(i).getY() > height) {
                comida.remove(i);
                i--; 
            }
        }   
        
        for(int i = 0; i < veneno.size(); i++ ){
            Veneno v = veneno.get(i);
            moverVeneno(v);
            if (veneno.get(i).getY() > height) {
                veneno.remove(i);
                i--;
            }
        }
    }
    
    /**
     * Mueve un objeto Comida hacia abajo y lo elimina si sale del límite.
     * 
     * @param comida el objeto de comida a mover
     */
    
    public void moverComida(Comida comida){
        comida.setY(comida.getY() + 4);
        if (comida.getY() > this.height) {
            comida.setY(-1000); 
        }
    }
    
    /**
     * Mueve un objeto Veneno hacia abajo y lo elimina si sale del límite.
     * 
     * @param veneno el objeto de veneno a mover
     */
    
    public void moverVeneno(Veneno veneno){
        veneno.setY(veneno.getY() + 4);
        if (veneno.getY() > this.height) {
            veneno.setY(-1000);
        } 
    }
    
    /**
     * Retorna los límites rectangulares del cielo.
     * 
     * @return un {@link Rectangle} representando los límites
     */

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);    
    }
}
