package EstruturasLineares;

public class ListaDuplamenteEncadeada {
	private NodoDuplo inicio;
	private NodoDuplo fim;
	
	public ListaDuplamenteEncadeada() {
		inicio = null;
		fim = null;
	}
	public NodoDuplo getInicio() {
		return inicio;
	}
	public NodoDuplo getFim() {
		return fim;
	}
	public boolean vazia() {
		return inicio == null;
	}
	
	public void inserirInicio(int dado) {
		NodoDuplo novoNodo = new NodoDuplo(dado);
		
		if(vazia()) {
			inicio = novoNodo;
			fim = novoNodo;
			return;
		}
		
		novoNodo.setProx(inicio);
		inicio.setAnt(novoNodo);
		inicio = novoNodo;
	}
	public void inserirFInal(int dado) {
		if(vazia()) {
			inserirInicio(dado);
			return;
		}
		
		NodoDuplo novoNodo =  new NodoDuplo(dado);
		fim.setProx(novoNodo);
		novoNodo.setAnt(fim);
		fim = novoNodo;
	}
	
	public void mostrarLista() {
		if(vazia()) {
			System.out.println("lista vazia");
			return;
		}
		NodoDuplo aux = inicio;
		while (aux != null) {
			System.out.println(aux.getDado());
			aux= aux.getProx();
		}
	}
	public void removerValor(int valor) {
		if (vazia()) return;
		
		if(inicio.getDado() == valor) {
			if(inicio== fim) {
				inicio = null;
				fim = null;
				return;
			}
			inicio = inicio.getProx();
			inicio.setAnt(null);
			return;
		}
			
		if(fim.getDado() == valor) {
			fim = fim.getAnt();
			fim.setProx(null);
			return;
		}
		NodoDuplo aux = inicio.getProx();
		while(aux != null) {
			if(aux.getDado() == valor) {
				aux.getAnt().setProx(aux.getProx());
				aux.getProx().setAnt(aux.getAnt());
				return;
			}
			aux = aux.getProx();
		}
	}
	public void mostrarInverso() {
		if(vazia()) {
			System.out.println("lista vazia");
			return;
		}
		NodoDuplo aux = fim;
		while (aux != null) {
			System.out.print(aux.getDado());
			aux= aux.getAnt();
		}
	}
	public void maiorMenor() {
		int maior = 0;
		int menor = 0;
		
		if(vazia()) {
			System.out.println("lista vazia");
			return;
		}
		NodoDuplo aux = inicio;
		
		while(aux != null) {
			maior = aux.getDado();
			menor = aux.getDado();
			aux.setProx(aux.getProx());
			if(aux.getDado() > maior) {
				maior = aux.getDado();
			}
			if(aux.getDado() < menor) {
				menor = aux.getDado();
			}
			aux = aux.getProx();
		}
		System.out.println("maior: "+ maior + " menor: " + menor);
	}
}
