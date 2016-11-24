package Reactions;

import UI.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ButtonListener implements ActionListener {
    /*Esta clase implementa "ActionListener", lo cual le permite reaccionar a
      determinadas acciones, en este caso se asigno para reaccionar a cualquier
      botón del LateralPanel. La variable buttton REPRESENTA el botón sobre el
      cual se hizo click, para saber qué acción debe ejecutar, se basa en el
      "Name" del botón, así lo identifica y puede saber la acción asociada a ese
       botón.*/
    private Pad drawPad;
    private JButton button;

    public ButtonListener(Pad drawPad, JButton button) {
        this.drawPad = drawPad;
        this.button = button;
    }
    //Constructor: Asigna las respectivas variables a sus parametros.

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.getName().equals("black")) {
            drawPad.getGraphics().setPaint(Color.black);
            drawPad.repaint();
        } else if (button.getName().equals("red")) {
            drawPad.getGraphics().setPaint(Color.red);
            drawPad.repaint();
        } else if (button.getName().equals("blue")) {
            drawPad.getGraphics().setPaint(Color.blue);
            drawPad.repaint();
        } else if (button.getName().equals("green")) {
            drawPad.getGraphics().setPaint(Color.green);
            drawPad.repaint();
        } else if (button.getName().equals("magenta")) {
            drawPad.getGraphics().setPaint(Color.magenta);
            drawPad.repaint();
        } else if (button.getName().equals("white")) {
            drawPad.getGraphics().setPaint(Color.white);
            drawPad.repaint();
        } else if (button.getName().equals("yellow")) {
            drawPad.getGraphics().setPaint(Color.yellow);
            drawPad.repaint();
            
            /*Para los botones identificados como colores, simplemente define el
              "Graphics" del Pad en su respectivo color. (Graphics del Pad = pen)*/
            
        } else if (button.getName().equals("clear")) {
            drawPad.clear();
            /*Llama al método ".clear()" del Pad, que simplemente dibujo un 
              rectangulo blanco sobre todo el Pad, simulando que todo ha sido
              borrado. (Mirar la clase Pad para más)*/
            
        } else if (button.getName().equals("undo")) {
            drawPad.undo();
            /*Llama al método ".undo()", el cual basicamente devuelve y asigna una
              imagen al componente "image" del Pad. Basicamente se guarda cada cambio
              (representado como imagen)en una pila y si se necesita volver, se 
              saca el último elemento de la pila, es decir, el cambio más reciente
              (Mirar la clase Pad para más)*/
            
        } else if (button.getName().equals("info")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("C:\\Users\\Estudiante\\Documents\\NetBeansProjects\\SketchBox\\src\\Resources\\Documentation.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
 
                }
            }
            /*Abre un archivo ".pdf", lo que hace esto es pedir al sistema que abra
              el archivo por uno, para lo cual el sistema usa sus propios recursos.
              Se puede presentar una excepción si en este caso, el sistema no tiene
              recursos para abrir el archivo, es decir, por ejemplo, no tuviera un
              lector de ".pdf"*/
        } else if (button.getName().equals("about")) {
            AboutPanel aboutUs = new AboutPanel();
            aboutUs.initiate();
            /*Instancia un AboutPanel y llama a su método ".initiate()", el cual
              básicamente coloca un "Look" del estilo "Nimbus" y luego ejecuta la instancia*/
        } else if (button.getName().equals("save")) {
            try {
                BufferedImage bufferedImage = (BufferedImage) drawPad.getImage();
                File outputFile = new File("SketchImage.png");
                ImageIO.write(bufferedImage, "png", outputFile);
                ToastMessage toastMessage = new ToastMessage("Saved as \"SketchImage.png\"", 3000);
                toastMessage.setVisible(true);
            } catch (IOException T) {

            }
        }
        /*Toma la imagen del Pad y la convierte en un BufferedImage, esta permite
          un mayor manejo. Luego crea un archivo con una ruta especifica y mediante
          un flujo envia al archivo la imagen. Luego crea un "Toast-like" con el fin
          de mostrar al usuario un mensaje indicandole que la imagen ha sido guardada.*/
    }
    

}
