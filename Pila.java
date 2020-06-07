
public class Pila {
 
    //Atributos
    private ListaEnlazada lista; 
    private int tamanio;
 
    //Constructores
    public Pila(int N) {
        lista = new ListaEnlazada(); //No hay elementos
        this.tamanio = 0;
    }
    /**
     * Indica el tamaño
     */
    public int size() {
        return tamanio-1;
    }
    public void apilar(int n){
        lista.agregarAlInicio(new Nodo(null,n));
        tamanio++;
    }
    public Nodo sacar(){
       Nodo aux;
       aux=lista.eliminarAlFin();
        tamanio--;
        return  aux;
    }
}