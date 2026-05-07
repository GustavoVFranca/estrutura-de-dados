package EstruturasLineares;

public class ListaCircular {
	private Nodo inicio;
	private  Nodo fim;
	
	public ListaCircular() {
		this.inicio = null;
		this.fim = null;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public Nodo getFim() {
		return fim;
	}

	public void setFim(Nodo fim) {
		this.fim = fim;
	}
	
	public boolean vazio() {
		return inicio == null;
	}
	
	public void inserirInicio(int valor) {
		Nodo novoNodo = new Nodo(valor);
		if(vazio()) {
			inicio = novoNodo;
			fim = novoNodo;
			fim.setProx(inicio);
			return;
		}
		
		novoNodo.setProx(inicio);
		inicio = novoNodo;//atualiza inicio
		fim.setProx(inicio);// fim aponta para o novo inicio
	}
	
	public void inserirFinal(int valor){
		if(vazio()) {
			inserirInicio(valor);
			return;
		}
		
		Nodo novoNodo = new Nodo(valor);
		fim.setProx(novoNodo);
		fim = novoNodo;
		fim.setProx(inicio);
	}
	
	public void mostrarLista(){
		if(vazio()) {
			System.out.println("Lista Vazia");
			return;
		}
		
		Nodo aux = inicio;
		do {
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}while(aux!=inicio);
	}
	
	public void removerValor(int valor) {
		if(vazio()) return;
		
		//caso 1: valor no inicio
		if(inicio.getDado() == valor){
			// se for o unico elemento
			if(inicio == fim) {
				inicio = null;
				fim = null;
				return;
			}
			inicio = inicio.getProx();
			fim.setProx(inicio);
			return;
		}
		// caso 2: valor esta no meio ou no final
		Nodo aux = inicio;
		while(aux.getProx()!=inicio){
			if(aux.getProx().getDado() == valor) {
				// se o valor que vamos remover for o ultimo
				if(aux.getProx() == fim){
					fim = aux;
					fim.setProx(inicio);
				}else {
					//remover meio
					aux.setProx(aux.getProx().getProx());
				}
				return;
			}
			aux = aux.getProx();
		}
	}
	public int tamanho(){
		if(vazio()){
			return(0);
		}
		Nodo aux = inicio;
		int cont = 0;
		do {
			cont++;
			aux = aux.getProx();
		}while(aux!=inicio);
		return cont;
	}
	
}
