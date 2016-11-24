package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMovementAdapter extends MouseMotionAdapter{
    private Pad pad;
    
    public MouseMovementAdapter(Pad pad){
        this.pad=pad;
    }
    
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
}
