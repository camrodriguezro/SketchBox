package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame {
    private JFrame frame;
    //Representa el cuadro general del programa, aquí se guardan todos los demás componentes.
    
    public Frame(){
        frame = new JFrame("Sketch Box");
        //Fija el titulo de la ventana
        Image image = new ImageIcon(this.getClass().getResource("/Resources/iconImage.png")).getImage();
        frame.setIconImage(image);
        //Asigna el icono de la ventana

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

        final Pad drawPad = new Pad();
        LateralPanel lateralPanel = new LateralPanel(drawPad);
        /*Asigna una variable contenedor al contenedor del cuadro y se le asigna
          un BorderLayout (Puntos cardinales), se crea un Pad de dibujo y un menú
          lateral asociado al Pad*/
        
        content.add(drawPad, BorderLayout.CENTER);
        content.add(lateralPanel, BorderLayout.EAST);

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        /*Agrega el pad al centro y el menú lateral a la derecha, fija el tamaño
          de la ventana a 500 pixeles, selecciona la operación de cierre para la
          ventana, centra el marco, hace que no se pueda cambiar el tamaño y lo 
          vuelve visible.*/
    }
    
    public static void main(String[] args) {
         Frame App = new Frame();    
    }
    /*Crea una instancia de un objeto App, la cual corre el programa*/
    
}