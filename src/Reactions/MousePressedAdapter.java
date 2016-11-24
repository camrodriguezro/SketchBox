package Reactions;

import UI.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MousePressedAdapter extends MouseAdapter{
    /*Hereda de MouseAdapter, la cual es una clase que implementa la interfaz 
      mouseListener, lo que permite reaccionar cuando el mouse se mueve.*/
    private Pad pad;
    
    public MousePressedAdapter(Pad pad){
        this.pad=pad;
    }
    //Lo asigna al Pad correspondiente.
    
    @Override
    public void mousePressed(MouseEvent e) {
        pad.saveToStack(pad.getImage());
        pad.setOldX(e.getX());
        pad.setOldY(e.getY());
    }
    /*Rastrea los movimientos del mouse cada vez que es presionado. Además guarda
      en la pila la imagen que se esté editando en ese momento (Antes de presionar))*/
        
}
