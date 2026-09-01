package Arvores;

public class ArvoreBinaria {
	public class No{
		private char valor;
		private No esquerdo;
		private No direito;
		
		public No(char valor) {
			this.valor = valor;
		}
	}
	
	private No raiz;
	
	public No getRaiz() {
		return raiz;
	}
	
	public No criarRaiz(char valor) {
		raiz = new No(valor);
		return raiz;
	}
	
	public No adicionarEsquerdo(No pai, char valor) {
		if(pai == null) {
			System.out.println("Nãi foi possivel inserir: nó pai inexistente");
			return null;
		}
		
		if(pai.esquerdo != null) {
			System.out.println("No pai ja possui filho esquerdo");
			return null;
		}
		
		pai.esquerdo = new No(valor);
		return pai.esquerdo;
	}
	
	public No adicionarDireito(No pai, char valor) {
		if(pai == null) {
			System.out.println("Nãi foi possivel inserir: nó pai inexistente");
			return null;
		}
		
		if(pai.direito != null) {
			System.out.println("No pai ja possui filho direito");
			return null;
		}
		
		pai.direito = new No(valor);
		return pai.esquerdo;
	}
	
	public void preOrdem() {
		preOrdem(raiz);
		System.out.println();
	}
	
	public void emOrdem() {
		emOrdem(raiz);
		System.out.println();
	}
	
	public void posOrdem() {
		posOrdem(raiz);
		System.out.println();
	}	
	
	private void preOrdem(No no) {
		if (no == null) {
			return;
		}
		
		System.out.print(no.valor + " ");
		preOrdem(no.esquerdo);
		preOrdem(no.direito);
	}
	
	private void emOrdem(No no) {
		if(no == null) {
			return;
		}
		
		emOrdem(no.esquerdo);
		System.out.print(no.valor + " ");
		emOrdem(no.direito);	
	}
	private void posOrdem(No no) {
		if(no == null) {
			return;
		}
		
		posOrdem(no.esquerdo);
		posOrdem(no.direito);
		System.out.print(no.valor + " ");
	}
	public int quantidadeFolhas() {
	    return quantidadeFolhas(raiz);
	}
	
	public int quantidadeFolhas(No no) {
		if(no == null) {
			return 0;
		}
		if(no.esquerdo == null && no.direito == null) {
			return 1;
		}
		return quantidadeFolhas(no.esquerdo) + quantidadeFolhas(no.direito);
	}
}


