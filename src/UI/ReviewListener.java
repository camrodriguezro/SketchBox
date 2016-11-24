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

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setBorder(null);
        this.getPuntuation();
        this.updateImagePuntuation();
    }
    
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
    
    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
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
        }else if(value>4.0 && value<=5.0){
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated5.png")));
        }else{
            statusIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Rated5.png")));
        }
        statusIcon.setToolTipText(value + "/5");
    }

}
