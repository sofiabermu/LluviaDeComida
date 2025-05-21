/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lluviacomida.main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import lluviacomida.ui.GameWindow;

/**
 * Clase principal del juego. Esta clase contiene el método main que lanza la aplicación.
 * Se encarga de inicializar la ventana principal del juego y colocar el panel de juego GameWindow dentro de ella.
 *
 * @author SOFIA RUDAS
 * @since 19052025
 * @version 1.0.0
 */
public class LLuviaComida {
    
    /**
     * Método principal que inicia la aplicación.
     * Crea una ventana JFrame, le añade el panel de juego GameWindow y la muestra en el centro de la pantalla. 
     * También asegura que la ventana no sea redimensionable y que el juego reciba el foco de entrada.
     *
     * @param args los argumentos de la línea de comandos 
     */

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Lluvia de comida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameWindow gameWindow = new GameWindow();
        frame.add(gameWindow);

        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setResizable(false);
        frame.setVisible(true);

        gameWindow.requestFocusInWindow();
        });
        
    }  
}
