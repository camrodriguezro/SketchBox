package UI;

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

    private Pad drawPad;
    private JButton button;

    public ButtonListener(Pad drawPad, JButton button) {
        this.drawPad = drawPad;
        this.button = button;
    }

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
        } else if (button.getName().equals("clear")) {
            drawPad.clear();
        } else if (button.getName().equals("undo")) {
            drawPad.undo();
        } else if (button.getName().equals("info")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    
                    File myFile = new File("C://Users//Estudiante//Documents//NetBeansProjects//SketchBox//src//Resources//Documentation.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        } else if (button.getName().equals("about")) {
            AboutPanel aboutUs = new AboutPanel();
            aboutUs.initiate();
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
    }

}
