package TabelasHash.HashEncadeamento;

public class ListaEncadeada {
	private class Nodo{
		String chave;
		String valor;
		Nodo prox;
		
		public Nodo(String chave, String valor) {
			this.chave = chave;
			this.valor = valor;
			this.prox = null;
		}
	}
	
	private Nodo inicio;
	
	public ListaEncadeada(String chave, String valor) {
		this.inicio = new Nodo(chave, valor);
	}
	
	public void AtualizarOuAdicionar(String chave, String valor){
		Nodo aux = inicio;
		while(aux != null) {
			if(aux.chave.equals(chave)) {
				aux.valor = valor;
				return;
			}
			aux = aux.prox;
		}
		// se nao achou adiciona no inicio (O(1))
		Nodo novoNodo = new Nodo(chave, valor);
		novoNodo.prox = inicio;
		inicio = novoNodo;
	}
	
	public String buscaPorChave(String chave) {
		Nodo aux = inicio;
		while(aux != null) {
			if(aux.chave.equals(chave)) {
				return aux.valor;
			}
			aux = aux.prox;
		}
		return null;
	}
	
	public void removerChave(String chave) {
		if(inicio == null) return;
		
		if(inicio.chave.equals(chave)) {
			inicio = inicio.prox;
		}
		
		Nodo aux = inicio;
		while(aux.prox != null) {
			if(aux.chave.equals(chave)) {
				aux.prox = aux.prox.prox;
				return;
			}
		aux = aux.prox;
		}
	}
	
	public void mostrarLista() {
		Nodo aux = inicio;
		while(aux != null) {
			System.out.print(" {" + aux.valor + "} ->");
			aux = aux.prox;
		}
		System.out.println("Null");
	}
	
}
