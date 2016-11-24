package Reactions;

import UI.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMovementAdapter extends MouseMotionAdapter{
    /*Hereda de MouseMotionAdapter, que es una clase que implementa MouseMotionListener,
      esto permite reaccionar a cualquier movimiento del mouse, en este caso se
      emplea para guardar las posciones una vez el usuario arrastra el mouse.*/
    private Pad pad;
    
    public MouseMovementAdapter(Pad pad){
        this.pad=pad;
    }
    //Lo asigna al Pad correspondiente
    
    @Override
    public void mouseDragged(MouseEvent e){
        pad.setActualX(e.getX());
        pad.setActualY(e.getY());
        
        if (pad.getGraphics() != null) {
            pad.getGraphics().drawLine(pad.getOldX(), pad.getOldY(), pad.getActualX(), pad.getActualY());
        }
        
        pad.repaint();
        pad.setOldX(pad.getActualX());
        pad.setOldY(pad.getActualY());
    }
    /*Cuando el mouse es arrastrado toma la posición de donde es arrastado
      (setActualX/Y) hasta la posición actual del mouse, (setOldX/Y) y entre esas
       dos coordenadas dibuja una linea*/
}
