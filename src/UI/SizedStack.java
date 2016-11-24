package UI;

import java.util.Stack;

public class SizedStack<T> extends Stack<T> {
    /*Una pila (Stack) de tipo <T>, el <T> es un indicador abstracto: Permite
      establecer el tipo de dato que será usado para la pila, por ejemplo en nuestro
      caso: Stack<Image> creará una pila de Image. Una pila es como un tarro vertical,
      lo primero que se agrega es lo último que se saca.*/
    
    private final int maxSize;
    //Tamaño de la pila
    
    public SizedStack(int size) {
        super();
        this.maxSize = size;
    }
    /*Constructor, asigna un int "size" a la variable atributo "maxSize", se
      refiere al tamaño maximo de la pila*/

    @Override
    public Object push(Object object) {
        while (this.size() > maxSize) {
            this.remove(0);
        }
        return super.push((T) object);
    }
    /*Si la pila supera el número máximo de elementos (representado por la variable
      atributo "maxSize"), entonces removerá el último elemento de la pila (El primer
      elemento que se introdujo, el primer cambio hecho): De este modo garantiza
      que sólo podrá guardar un #maxSize de objetos, en nuestro caso, serán imagenes.
      Luego, añade un objeto a la pila (mediante "push" = "addElement") y devuelve
      ese mismo objeto.*/
}
