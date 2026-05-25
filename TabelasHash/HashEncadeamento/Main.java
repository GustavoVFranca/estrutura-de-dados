package TabelasHash.HashEncadeamento;

public class Main {

	public static void main(String[] args) {
		HashTable3 agenda = new HashTable3(4);
		
		long a = System.currentTimeMillis();
		System.out.println(a);
		for(int i = 0; i < 10000; i++) {
			agenda.inserir(("chave"+i), String.valueOf(i));
		}
		long b = System.currentTimeMillis();
		System.out.println(b);
	
		System.out.println(b - a);
		
		agenda.mostrarTabela();
	}
}
