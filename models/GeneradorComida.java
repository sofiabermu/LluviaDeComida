/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.models;

/**
 * es un hilo que genera periódicamente objetos de tipo Comida y los agrega al objeto Cielo, 
 * siempre y cuando el número total de objetos de comida en pantalla sea menor a 4.
 * 
 *
 * @author SOFIA RUDAS
 * @since 19052025
 * @version 1.0.0
 */
public class GeneradorComida extends Thread{
    
     // Referencia al objeto Cielo donde se generarán las comidas.
    private Cielo cielo;
    
    // Indica si el hilo debe seguir ejecutándose.
    private boolean ejecutando = true;

    /**
     * Crea una nueva instancia del generador de comida asociada a un cielo.
     *
     * @param cielo el objeto Cielo donde se agregarán las comidas
     */
    
    public GeneradorComida(Cielo cielo) {
        this.cielo = cielo;
    }
    
    /**
     * Mientras ejecutando sea verdadero, genera nuevos objetos de tipo Comida si hay menos de 4 en el cielo.
     * El hilo se duerme durante 100 milisegundos en cada iteración para controlar la frecuencia.
     */
    
    @Override
    public void run() {
        while (ejecutando) {
            
           if (cielo.getComida().size() < 4) {
                Comida nueva = new Comida();
                cielo.getComida().add(nueva); 
            }
            
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Detiene la ejecución del hilo de generación de comida.
     * Cambia el valor de ejecutando a false
     */
    
    public void detener() {
        ejecutando = false;
    }
    
}
