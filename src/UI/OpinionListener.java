package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OpinionListener implements ActionListener {
      /*Implementa la interfaz ActionListener. Esta clase maneja todo lo que
        tiene que ver con comentarios (Escritura, formato y lectura)
        La idea es que cuando presione el botón "Send", se toma el comentario de
        la caja de texto y se escribe en el archivo definido + la fecha en que se
        hizo el comentario. Finalmente se leen los comentarios del archivo, se
        colocan en un StringBuilder y se muestran mediante un JDialogBox (Una caja
        simple). Se utiliza un StringBuilder en vez de un String por dos razones:
        es mutable, por lo que no consumirá tantos recursos para crearse y por el
        tamaño o cantidad de comentarios.*/
    
    private JButton send;
    private FileWriter opinionWriter;
    private JTextField comments;
    private Scanner reader;
    private File fileOnComments;
    private StringBuilder builder;
    private DateFormat dateFormat;

    public OpinionListener(JButton send, JTextField comments) {
        this.send = send;
        this.comments = comments;
        this.fileOnComments = new File("Opinion.ser");
        this.builder = new StringBuilder();
        this.dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    }
    /*Asigna al botón "send" y al campo de texto "comments" con sus homonimos.
      Estos son únicos. Luego define un archivo llamado "Opinion.ser", instancia
      un StringBuilder y define un formato para fechas.*/

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            opinionWriter = new FileWriter("Opinion.ser", true);
            if (!comments.getText().isEmpty()) {
                Date date = new Date();
                opinionWriter.write("[" + dateFormat.format(date) + "]  " + comments.getText() + System.lineSeparator());
                opinionWriter.close();
                comments.setText("");
            }
            this.readComments();
        } catch (IOException IOError) {
            IOError.getStackTrace();
        } catch (NullPointerException NPEx) {
            NPEx.getStackTrace();
        }
    }
    /*Cuando se haga click en el botón, sólo si ésta no está vacía, se tomará el
      texto de la caja de texto y se escribirá en un archivo predefinido (Y reeditable)
      junto con la fecha y un separador de linea. Así cada línea guardada tendrá
      una fecha y un comentario. Finalmente llama al método ".readComments" que
      lee los comentarios y los muestra. Está lista para recibir excepciones.*/
    
    private void readComments() {
        try {
            reader = new Scanner(fileOnComments);
            while (reader.hasNextLine()) {
                    builder.append(reader.nextLine() + "\n");
            }
            JOptionPane.showMessageDialog(null, builder, "", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {}
    }
    /*Lee cada comentario que encuentre en el archivo y los va agregando al StringBuilder
      más un salto de línea. Finalmente muestra el StringBuilder (es decir, todos
      los comentarios) en una ventana plana y está lista para recibir cualquier excepción.*/

}
