package EstruturasLineares.Pilha;
import EstruturasLineares.Nodo;
public class PilhaDinamica implements IPilha{
	private Nodo topo;
	//construtor
	public PilhaDinamica() {
		topo = null;
	}
	
	@Override
	public boolean vazia() {
		if(topo == null) {
			return true;
		}
		return false;
	}
	@Override
	public void push(int dado) {
		Nodo novoNodo = new Nodo(dado);
		novoNodo.setProx(topo);
		topo = novoNodo;	
	}
	@Override
	public int pop() {
		if(vazia()) {
			System.out.println("Erro: a pilha esta vazia");
			return -1;
		}
		int valorRemovido = topo.getDado();
		topo = topo.getProx();
		return valorRemovido;
	}
	@Override
	public int peek() {
		if(vazia()) {
			System.out.println("Erro: a pilha esta vazia");
			return -1;
		}
		return topo.getDado();
	}
	
	@Override
	public void mostrarPilha() {
		if(vazia()) {
			System.out.println("A pilha dinamica esta vazia");
			return;
		}
		Nodo aux = topo;
		System.out.println("---topo(Dinamica)---");
		while(aux != null) {
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
		System.out.println("---Base--");
	}
}
