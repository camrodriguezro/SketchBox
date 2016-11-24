package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class Pad extends JComponent {

    /*Hereda de JComponent con el fin de poder luego incrustarlo como un 
      componente más en el cuadro general*/
    
    private Image image;
    //Sobre una imagen en blanco es donde se va a pintar
    
    private Graphics2D pen;
    //Es la herramienta que permite dibujar
    
    private int oldX, oldY, actualX, actualY;
    /*Simulan las posiciones del mouse, si el mouse se mueve, el puntero va 
      desde un (oldX,oldY) a un (actualX,actualY)*/
    
    private final SizedStack<Image> undoStack = new SizedStack<>(12);
    /*Una pila de doce imagenes: Aquí se guardan cada imagen a la que se le
      realicen cambios*/
    
    public Pad() {
        //Constructor
        this.setDoubleBuffered(true);
        //Permite definir si sobre este componente se puede dibujar
        this.addMouseListener(new MousePressedAdapter(this));
        /*Añade al "Pad" un MouseListener anónimo: Si el mouse es presionado 
          asigna (OldX, OldY) a las coordenadas exactas donde el mouse es 
          presionado. Consultar el método .mousePressed de la clase
          MousePressedAdapter*/
        this.addMouseMotionListener(new MouseMovementAdapter(this));
        /*Mientras el mouse es arrastrado, asinga (actualX, actualY) a las 
          coordenadas (X,Y) del mouse. Posteriormente dibuja una línea entre las
          coordenadas. Repinta y fija a (oldX, oldY) como los actuales (currentX,
          currentY)Consultar el método .mouseDragged de la clase MouseMovementAdapter*/
    }

    public void undo() {
        if (undoStack.size() > 0) {
            setImage(undoStack.pop());
        }
    }
    /*Método "Deshacer": Si la pila tiene algún elemento (significa que hubo un
      cambio), entonces que se asigne a la imagen del Pad, la última imagen de 
      la fila, es decir, el último cambio*/
    
    private void setImage(Image img) {
        pen = (Graphics2D) img.getGraphics();
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setPaint(Color.black);
        image = img;
        repaint();
    }
    /*Permite asignar una imagen al Pad y sija el color del lapiz a negro. Se usa
      para asignar el último cambio (la última imagen) al Pad*/

    private BufferedImage copyImage(Image img) {
        BufferedImage copyOfImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
        Graphics g = copyOfImage.createGraphics();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        return copyOfImage;
    }
    /*Permite copiar la imagen acutal (La que se está haciendo en el Pad. Esto 
      con el fin de que posteriormente esta copia se coloca en la pila*/

    protected void saveToStack(Image img) {
        undoStack.push(copyImage(img));
    }
    /*Permite enviar copias de una imagen (en este caso la que se está editando)
      en el Pad) a la pila*/
    
    public void setOldX(int actualX) {
        this.oldX = actualX;
    }
    //Asigna el valor actualX a la variable oldX

    public void setActualX(int currentX) {
        this.actualX = currentX;
    }
    //Asigna el valor currentX a la variable actualX

    public void setOldY(int actualY) {
        this.oldY = actualY;
    }
    //Asigna el valor actualY a la variable oldY

    public void setActualY(int currentY) {
        this.actualY = currentY;
    }
    //Asigna el valor currentY a la variable actualY

    public int getOldX() {
        return this.oldX;
    }
    //Devuelve el valor de la variable oldX;

    public int getOldY() {
        return this.oldY;
    }
    //Devuelve el valor de la variable oldY;

    public int getActualX() {
        return this.actualX;
    }
    //Devuelve el valor de la variable actualX;

    public int getActualY() {
        return this.actualY;
    }
    //Devuelve el valor de la variable actualY;

    @Override
    public Graphics2D getGraphics() {
        return this.pen;
    }
    //Devuelve el atributo Graphics2D, que es lo que nos permite divujar directamente.;    

    public Image getImage() {
        return this.image;
    }
    //Permite obtener la imagen sobre la cual se está trabajando

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            pen = (Graphics2D) image.getGraphics();
            pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }
    /*Este es el lienzo para pintar: Si no hay nada en ella, entonces crea una 
      imagen del tamaño de la ventana, asigna el valor de Graphics a la imagen
      (mediante esta acción podemos modificar directamente los gráficos del 
      componente) Asigna las constantes de renderización, borra el "tintero" del 
      lapiz mediante el método .clear y finalmente dibuja la imagen.*/
    
    public void clear() {
        pen.setPaint(Color.white);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        pen.setPaint(Color.black);
        repaint();
    }
    /*Este método asigna el color a blanco y llena toda la venta de él y luego,
      asigna a el negro como el color por defecto*/
}
