package UI;

import Reactions.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LateralPanel extends JPanel{
    private JButton blackButton = new JButton();
    private JButton redButton = new JButton();        
    private JButton blueButton = new JButton();
    private JButton greenButton = new JButton();
    private JButton magentaButton = new JButton();
    private JButton whiteButton = new JButton();
    private JButton yellowButton = new JButton();
    private JButton clearButton = new JButton();
    private JButton undoButton = new JButton();
    private JButton save = new JButton();
    private JButton info = new JButton();
    private JButton aboutUs = new JButton();
    private Pad drawPad;
    /*Notese que en todos los métodos se mantiene el orden de los componentes a 
      fin de ser más claro*/
    
    public LateralPanel(Pad drawPad){
        this.drawPad = drawPad;
        this.setLook();
        this.setPreferredSize(new Dimension(35, 68));
        this.setMinimumSize(new Dimension(35, 68));
        this.setMaximumSize(new Dimension(35, 68));
        
        this.add(blackButton);
        this.add(redButton);
        this.add(blueButton);
        this.add(greenButton);
        this.add(magentaButton);
        this.add(whiteButton);
        this.add(yellowButton);
        this.add(clearButton);
        this.add(undoButton);
        this.add(save);
        this.add(info);
        this.add(aboutUs);
    }
    /*Constructor: Asocia el Pad respectivo, luego llama al método ".setLook()"
      que básicamente define la estetica de los compoenentes del panel. Fija el
      tamaño del panel a 35x68 pixeles y añade todos los botones: En el orden en
      que se agregan es el orden en que aparecen.*/
    
    private void setLook(){
        blackButton.setName("black");
        redButton.setName("red");
        blueButton.setName("blue");
        greenButton.setName("green");
        magentaButton.setName("magenta");
        whiteButton.setName("white");
        yellowButton.setName("yellow");
        clearButton.setName("clear");
        undoButton.setName("undo");
        save.setName("save");
        info.setName("info");
        aboutUs.setName("about");

        blackButton.setBackground(new Color(0, 0, 0));
        redButton.setBackground(new Color(255, 51, 51));
        blueButton.setBackground(new Color(0, 128, 255));
        greenButton.setBackground(new Color(0, 255, 0));
        magentaButton.setBackground(new Color(255, 0, 127));
        whiteButton.setBackground(new Color(255,255,255));
        yellowButton.setBackground(new Color(255,255,0));
        
        blackButton.setPreferredSize(new Dimension(30, 30));
        redButton.setPreferredSize(new Dimension(30, 30));
        blueButton.setPreferredSize(new Dimension(30, 30));
        greenButton.setPreferredSize(new Dimension(30, 30));
        magentaButton.setPreferredSize(new Dimension(30, 30));
        whiteButton.setPreferredSize(new Dimension(30, 30));        
        yellowButton.setPreferredSize(new Dimension(30,30));
        clearButton.setPreferredSize(new Dimension(30, 30));
        undoButton.setPreferredSize(new Dimension(30,30));
        save.setPreferredSize(new Dimension(30, 30));
        info.setPreferredSize(new Dimension(30, 30));
        aboutUs.setPreferredSize(new Dimension(30, 30));

        blackButton.addActionListener(new ButtonListener(drawPad,blackButton));
        redButton.addActionListener(new ButtonListener(drawPad,redButton));
        blueButton.addActionListener(new ButtonListener(drawPad,blueButton));
        greenButton.addActionListener(new ButtonListener(drawPad,greenButton));        
        magentaButton.addActionListener(new ButtonListener(drawPad,magentaButton));
        whiteButton.addActionListener(new ButtonListener(drawPad,whiteButton));
        yellowButton.addActionListener(new ButtonListener(drawPad,yellowButton));
        clearButton.addActionListener(new ButtonListener(drawPad,clearButton));
        undoButton.addActionListener(new ButtonListener(drawPad,undoButton));
        save.addActionListener(new ButtonListener(drawPad,save));
        info.addActionListener(new ButtonListener(drawPad,info));
        aboutUs.addActionListener(new ButtonListener(drawPad,aboutUs));
        
        clearButton.setBorder(BorderFactory.createEmptyBorder());
        undoButton.setBorder(BorderFactory.createEmptyBorder());
        save.setBorder(BorderFactory.createEmptyBorder());
        info.setBorder(BorderFactory.createEmptyBorder());
        aboutUs.setBorder(BorderFactory.createEmptyBorder());
        
        clearButton.setIcon(new ImageIcon(getClass().getResource("/Resources/eraserIcon.png")));
        undoButton.setIcon(new ImageIcon(getClass().getResource("/Resources/undoIcon.png")));
        save.setIcon(new ImageIcon(getClass().getResource("/Resources/saveIcon.png")));
        info.setIcon(new ImageIcon(getClass().getResource("/Resources/info.png")));
        aboutUs.setIcon(new ImageIcon(getClass().getResource("/Resources/aboutUs.png")));          
    }
    /*Estiliza los componentes del panel: Asigna un "Name" a cada botón, este
      identifica al botón y le permita al ButtonListener diferenciar botones. A 
      los botones de colores les asigna un icono pintado y luego define un tamaño
      de 30x30 pixeles para todos los botones. Agrega un ButtonListener a cada
      botón, éste se basará en el "Name" de cada botón para ejecutar la acción
      determinada. Finalmente a los últimos cinco (5) botones les borrar el margen
      y les asigna un icono basado en una imagen*/
}
