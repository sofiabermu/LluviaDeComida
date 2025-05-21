/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lluviacomida.models;

/**
 * representa un hilo que se encarga de generar objetos de tipo Veneno periódicamente 
 * y agregarlos al objeto Cielo. Asegura que como máximo haya 4 objetos de veneno en pantalla a la vez.
 *
 * @author sofia bermudez
 */
public class GeneradorVeneno extends Thread{
    
    //Referencia al objeto cielo donde se generaran los venenos
    private Cielo cielo;
    
    //Bandera que indica si el hilo debería seguir ejecutándose.
    private boolean ejecutando = true;

    /**
     * Crea una nueva instancia del generador de veneno asociado a un cielo.
     *
     * @param cielo el objeto Cielo en el que se agregan los objetos de veneno
     */
    
    public GeneradorVeneno(Cielo cielo) {
        this.cielo = cielo;
    }
    
    /**
     * Cada segundo intenta generar un nuevo objeto de tipo Veneno, si hay menos de 4 actualmente en el cielo. 
     * El hilo se duerme durante 100 milisegundos en cada iteración para controlar la frecuencia.
     */
    
    public void run() {
        while (ejecutando) {

            if (cielo.getVeneno().size() < 4) {
                Veneno nuevo = new Veneno();
                cielo.getVeneno().add(nuevo);
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
