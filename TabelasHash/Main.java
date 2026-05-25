package TabelasHash;

public class Main {

	public static void main(String[] args) {
		HashTable1 tabela = new HashTable1(5);
		
		tabela.inserir("UVA", "R$ 8,00");
		tabela.inserir("MAÇA", "R$ 5,00");

		tabela.mostrarTabela();
		System.out.println("preço da uva: " + tabela.recuperar("UVA"));
	}

}
