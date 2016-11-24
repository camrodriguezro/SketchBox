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

    private void readComments() {
        try {
            reader = new Scanner(fileOnComments);
            while (reader.hasNextLine()) {
                    builder.append(reader.nextLine() + "\n");
            }
            JOptionPane.showMessageDialog(null, builder, "", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {}
    }

}
