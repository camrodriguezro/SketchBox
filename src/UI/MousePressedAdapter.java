package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MousePressedAdapter extends MouseAdapter{
    private Pad pad;
    
    public MousePressedAdapter(Pad pad){
        this.pad=pad;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        pad.saveToStack(pad.getImage());
        pad.setOldX(e.getX());
        pad.setOldY(e.getY());
    }
        
}
