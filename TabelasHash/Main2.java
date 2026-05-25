package TabelasHash;

public class Main2 {

	public static void main(String[] args) {
		HashTable2 agenda = new HashTable2(4);
		
		agenda.inserir("Ana", "96767-6767");
		agenda.inserir("Alice", "96767-6969");
		
		agenda.mostrarTabela();
		
		agenda.inserir("Celia", "98349-2349");
		
		agenda.mostrarTabela();
		
		agenda.inserir("Bruno", "98347-7487");
		agenda.mostrarTabela();
	}

}
