
public class ListaEnlazada {
	//Referencia al inicio
	private Nodo Inicio;
	//Referencia al fin
	private Nodo Fin;
	private int NoElementos;
	public ListaEnlazada() {
		Inicio=null;
		Fin=null;
		 NoElementos=0;
	}
	public void agregarAlInicio(Nodo AG) {
		//caso cunado no tengo nodos
		if(Inicio==null) {
			Inicio=AG;
			Fin=AG;
			 NoElementos++;
		}else {//mi lista almenos tiene un nodo
			AG.Siguiente=Inicio;
			Inicio=AG;
			 NoElementos++;
		}
	}
	public void agregarAlFin(Nodo AG) {
		//caso cunado no tengo nodos
		if(Fin==null) {
			Fin=AG;
			Inicio=AG;
			NoElementos++;
		}else {//mi lista almenos tiene un nodo
			Fin.Siguiente=AG;
			Fin=AG;
			NoElementos++;
		}
	}
	public boolean buscar(Nodo AB) {
		if(AB!=null) {
			Nodo ref=Inicio;
			boolean Encontrado=false;
			while ((ref!=null)&&!Encontrado) {
				//Si esto es cierto el nodo ya fue encontrado
				if(ref.obtenerData()==AB.obtenerData()) {
					Encontrado=true;
				}
				ref=ref.Siguiente;
			}
			return Encontrado;
		}
		return false;
	}
	public int obtenerNoElementos() {
		return  NoElementos;
	}
	public Nodo eliminarAlInicio() {
		if(Inicio==null) {
			return null;
		}else {
		Nodo ret=Inicio;
		Inicio=Inicio.Siguiente;
		ret.Siguiente=null;
		 NoElementos--;
		 return ret;
		}
	}
	public Nodo eliminarAlFin() {
		if(Fin==null) {
			return null;
		}else {
		Nodo ref=Inicio;
		boolean Encontrado=false;
		while((ref!=null)&&!Encontrado) {
			if(ref.Siguiente==Fin) {
				Encontrado=true;
			}
			if(!Encontrado) {
			ref=ref.Siguiente;
			}
		}
		 NoElementos--;
		 Nodo eliminar = Fin;
		 Fin =ref;
		 ref.Siguiente=null;
		return eliminar;
		}
	}
	public Nodo eliminarPorNodo(Nodo AB) {
		if(AB==null) {
			return null;
		}
		if(Fin==null) {
			return null;
		}else {
		Nodo refRojo=Inicio;
		Nodo refAzul=null;
		Nodo refElim=null;
		boolean Encontrado=false;
		while((refRojo!=null)&&!Encontrado) {
			if(refRojo.obtenerData()==AB.obtenerData()) {
				Encontrado=true;
				refElim=refRojo;
				 NoElementos--;
			}
			if(!Encontrado) {
			refAzul=refRojo;
			refRojo=refRojo.Siguiente;
			}else {
				refAzul.Siguiente=refRojo.Siguiente;
				refElim.Siguiente=null;
			}
		}
		return refElim;
		}
	}
	@Override
	public String toString() {
		String tmp="";
		if(Inicio==null) {
			return "";
		}
		Nodo ref=Inicio;
		while(ref!=null) {
			tmp=tmp+" "+ref.toString();
			ref=ref.Siguiente;
		}
		return tmp;
	}
	public Nodo porIndice(int p) {
		if(Inicio==null) {
			return null;
		}
		if(p>=NoElementos) {
			return null;
		}
		if(p<0) {
			return null;
		}
		int i=0;
		Nodo ref=Inicio;
		for (;i<p;i++) {
			ref=ref.Siguiente;
		}
		ref=new Nodo(null,ref.obtenerData());
		return ref;
	}
}