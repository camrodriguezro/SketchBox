package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ReviewListener extends MouseAdapter {
    /*Hereda de la clase MouseAdapter. Uno de estos es una simple clase que emplea
      un mouseListener o similar de modo que ahorra el trabajo de implementar todos
      los métodos de la interfaz. Para cada ___Listener existe un ___Adapter.
    
      Esta clase maneja la escritura y analisis de las puntuaciones.*/
    
    private JButton button;
    private JButton statusIcon;
    private FileWriter writer;
    private Scanner reader;
    private ArrayList<Integer> puntuations;

    public ReviewListener(JButton one, JButton statusIcon) {
        this.button = one;
        this.statusIcon = statusIcon;
        reader = new Scanner("puntuation.ser");
        puntuations = new ArrayList<Integer>();
    }
    /*Constructor: Asigna los botones a sus respectivas variables atributos. 
      Asigna a la variable "reader" de tipo Scanner un archivo llamada "puntuation.ser"
      y crea un arreglo de enteros. El "reader" leerá el archivo (En donde se 
      encuentra únicamente una serie de números) y añadirá cada elemento que
      encuentre al arreglo, dem modo que el arreglo quedará con todas las puntuaciones
      que hay en el archivo. La variable "button" REPRESENTA uno de los botones
      que permiten puntuar (Mirar la clase AboutPanel: Botones rate#) y la variable
      "statusIcon" hace referencia al mismo boton de la clase AboutPanel y que 
       muestra el promedio de puntuaciones (Ubicado encima del cuadro de texto, derecha)*/

    @Override
    public void mousePressed(MouseEvent e) {
        button.setBorder(BorderFactory.createLoweredBevelBorder());
        try {
            writer = new FileWriter("puntuation.ser", true);
            writer.write(button.getText() + " ");
            writer.close();
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    /*Cuando el botón es presionado le cambia el borde (Esto es una mera medida
      estetica, sin embargo es de vital importancia, pues de no aplicarse no sé
      sabría si se ha pulsado o no el botón). Luego mediante "writer" escribe al
      archivo "puntuation.ser" (el "true" al lado indica que es reeditable) el
      texto de cada botón y un espacio (En este caso, el texto de cada botón es un
      número: Mirar los botones rate# de la clase AboutPanel) Por ejemplo, si
      pulsará el botón "rate5" el texto que escribiría sería "5 ". Finalmene cierra
      "writer" (Esto garantiza que lo que se escriba quede grabado) y está listo
      por si sale una excepción.*/

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setBorder(null);
        this.getPuntuation();
        this.updateImagePuntuation();
    }
    /*Cuando el mouse de presionar el boton, coloca el borde del botón normal.
      Llama al método ".getPuntuation()" (lee el archivo y asigna los valores al
      vector) y luego llama al método ".updateImagePuntuation()", el cual actualiza
      la imagen del botón "statusIcon" basado en una escala del promedio de puntuaciones*/
    
    private void getPuntuation(){
        try{
            puntuations.clear();
            File file = new File("puntuation.ser");
            reader = new Scanner(file);
            while(reader.hasNext()){
                puntuations.add(reader.nextInt());
            }
            reader.close();
        }catch(FileNotFoundException e){
             e.getStackTrace();
        }
    }
    /*Vacía el vector (Para contar desde cero); luego lee el archivo y va agragando
      cada valor que esté en el archivo al vector "puntuations". Está listo por 
      si aparece una excepción.*/
    
    private double status(){
        if(puntuations.isEmpty()){
            return 0;
        }
        int total=0;
        for(int base : puntuations){
            total+=base;
        }
        double average=((double)total/puntuations.size());
        return round(average);
    }
    /*Devuelve el promedio de puntuaciones. Si no hay ninguna puntuación, entonces
      devuelve cero (0); en otro caso, hace un promedio aritmetico y posteriormente
      usa el método ".round()" para redondear el valor a un sólo digito decimal.*/
    
    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    /*Redondea un valor double a dos digitos: Toma "value" y lo convierte a 
      "BigDecimal", que es un valor númerico que permite tomar todos los decimales
      que tenga el número. Luego lo redondea (Hacia arriba) a 2 digitos y devuelve
      el resultado.*/
    
    private void updateImagePuntuation(){
        double value = this.status();
        if(value>=1.0 && value<=2.0){
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated1.png")));
        }else if(value>2.0 && value<=3.0){
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated2.png")));
        }else if(value>3.0 && value<=3.7){
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated3.png")));
        }else if(value>3.7 && value<=4.4){
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated4.png")));
        }else if(value>4.4 && value<=5.0){
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated5.png")));
        }else{
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated5.png")));
        }
        statusIcon.setToolTipText(value + "/5");
    }
    /*Permite actualizar la imagen del botón "statusIcon" mediante una escala y 
      sabiendo el valor promedio de las puntuaciones (Sacado usando los anteriores
      métodos) Luego añade un texto de ayuda, con el cual se puede visualizar la
      calificación (Para visualizar el texto, hay que mantener el mouse sobre el
      botón algún tiempo). A continuación se muestra la escala: 
    
      Promedio      Imagen
      [1.0 - 2.0]     X_X
      [2.1 - 3.0]     :(
      [3.1 - 3.7]     ._.
      [3.8 - 4.4]     :)
      [4.5 - 5.0]     :D
      Otro caso       :D
    */

}
