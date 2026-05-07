package EstruturasLineares;

public class ListaEncadeada {
	private Nodo inicio;
	
	public ListaEncadeada() {
		inicio = null;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}
	public boolean vazio () {
		return inicio == null;
	}
	
	public void inserirInicio(int dado) {
		Nodo novoNodo = new Nodo(dado);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	public void inserirFInal(int dado) {
		if(vazio()) {
			inserirInicio(dado);
			return;
		}
		Nodo novoNodo = new Nodo(dado);
		Nodo aux = inicio;
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novoNodo);
	}
	
	public void RemoverValor(int valor) {
		if(vazio())	return;
		if(inicio.getDado() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while(aux.getProx() != null) {
			if(aux.getProx().getDado() == valor) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}

	public void mostrarLista () {
		if(vazio()) {
			System.out.println("Lista Vazia");
			return;
		}
		Nodo aux = inicio;	
		while (aux != null) {
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
	}
}
