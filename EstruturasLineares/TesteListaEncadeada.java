package EstruturasLineares;

public class TesteListaEncadeada {

	public static void main(String[] args) {
	/*	ListaEncadeada lista1 = new ListaEncadeada();
		lista1.inserirInicio(8);
		lista1.inserirInicio(2);
		lista1.inserirInicio(3);
		
		lista1.inserirFInal(5);
		
		lista1.RemoverValor(8);
		
		lista1.mostrarLista();
*/
	
	ListaDuplamenteEncadeada l2 = new ListaDuplamenteEncadeada();
		l2.inserirInicio(8);
		l2.inserirInicio(2);
		l2.inserirInicio(3);
	
		l2.inserirFInal(5);
		l2.inserirFInal(7);
	
		l2.mostrarLista();
		System.out.println("");
		l2.mostrarInverso();
	}
}
