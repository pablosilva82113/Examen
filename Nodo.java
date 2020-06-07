
public class Nodo <T>{
	public Nodo Siguiente;
	private T Data;
	public Nodo(Nodo Sig,T Data) {
		this.Siguiente=Sig;
		this.Data=Data;
	}
	public T obtenerData() {
		return Data;
	}
	public void colocarData(T Data) {
		this.Data=Data;
	}
	@Override
	public String toString() {
		return "Data : " + Data;
	}
	
}