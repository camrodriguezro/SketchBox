package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame {
    private JFrame frame;
    
    public Frame(){
        frame = new JFrame("Sketch Box");
        Image image = new ImageIcon(this.getClass().getResource("/Resources/iconImage.png")).getImage();
        frame.setIconImage(image);

        Container content = frame.getContentPane();

        content.setLayout(new BorderLayout());

        final Pad drawPad = new Pad();
        
        LateralPanel lateralPanel = new LateralPanel(drawPad);
        
        content.add(drawPad, BorderLayout.CENTER);
        content.add(lateralPanel, BorderLayout.EAST);

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
    
    public static void main(String[] args) {
         Frame App = new Frame();    
    }
    
}