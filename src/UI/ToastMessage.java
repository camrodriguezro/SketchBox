package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ToastMessage extends JDialog {
    int miliseconds;
    //Tiempo que durará el componente
    
    public ToastMessage(String toastString, int time) {
        this.miliseconds = time;
        setUndecorated(true);
        getContentPane().setLayout(new BorderLayout(0, 0));
        /*Asigna un entero "time" a la variable atributo "miliseconds", este será
          la cantidad de tiempo durante la cual el componente será visible. El String
          "toastString" será el mensaje que se mostrará. Indica que el componente
          no tendrá decoraciones y luego a su contenedor le asigna un layout del
          tipo "BorderLayout"(Puntos cardinales) con una separación entre componentes
          de 0, tanto vertical como horizontalmente.*/
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        getContentPane().add(panel, BorderLayout.CENTER);
        /*Crea un JPanel (Contenedor), cuyo fondo es de color gris con un borde
          de color gris claro y grosor de 2 pixeles. Luego agrega este panel al
          contenedor,lo coloca en el centro. Dado que no se añaden más componentes,
          éste JPanel ocupará todo el componente*/
        
        JLabel toastLabel = new JLabel("");
        toastLabel.setText(toastString);
        toastLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        toastLabel.setForeground(Color.WHITE);
        setBounds(100, 100, toastLabel.getPreferredSize().width+20, 31);
        /*Crea un JLabel (texto) y le asigna el valor de la variable "toastString"
          la cual le es trasmitida desde el constructor (Mirar arriba). Al JLabel
          le asigna una fuente (llamada "Dialog" (Pudo ser cualquier nombre), 
          negrilla y de tamaño 12). Asigna el color blanco al frente del componente
          (sólo se ve en caso de ser seleccionado) y luego un tamaño minúsculo.*/
        
        setAlwaysOnTop(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int y = dim.height/2-getSize().height/2;
        int half = y/2;
        setLocation(dim.width/2-getSize().width/2, y+half);
        panel.add(toastLabel);
        setVisible(false);
        /*Este componente SIEMPRE estará por encima de los demás, de modo que sea
          visible. Define la posición basandose en el tamaño de la pantalla: Estará
          horizontalmente centrado y a 3/4 vertical (de arriba a abajo). Lo agrega 
          al contenedor y lo vuelve invisible (Cuando corra el thread (Mirar abajo)
          dejara de ser invisible por el tiempo determinado)*/
        
        new Thread(){
            
            @Override
            public void run() {
                try {
                    Thread.sleep(miliseconds);
                    dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        /*Crea un nuevo thread para poder correr en paralelo con los demás
          componentes y le asigna el tiempo que estará visible*/
    }
}