package EstruturasLineares.Pilha;

public class Main {

	public static void main(String[] args) {
	
	
	/*	IPilha pilha1 = new PilhaDinamica();
		executarTestes(pilha1);
		
		IPilha pilha2 = new PilhaEstatica(4);
		executarTestes(pilha2);
	
	}
	public static void executarTestes(IPilha p) {
		p.push(10);
		p.push(20);
		p.push(30);
		p.push(40);
		
		p.mostrarPilha();
		
		System.out.println("valor do topo " + p.peek());
		System.out.println("desempilhando " + p.pop());
		
		p.mostrarPilha();*/
		
		System.out.println(MetodosPilha.ReverterStringPilha("bora bill"));
		System.out.println(MetodosPilha.decimalParaBinario(10));
		System.out.println(MetodosPilha.estaBalanceado("{[()]}"));
		System.out.println(MetodosPilha.estaBalanceado("{[)(]}"));
	}
	
	
}