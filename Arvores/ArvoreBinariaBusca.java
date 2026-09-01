package Arvores;
import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBinariaBusca {
	private class No{
		int valor;
		No dir;
		No esq;
	
		public No(int valor) {
			this.valor = valor;
			dir = esq = null;
		}
	}
	
	No raiz;
	
	public void inserir(int valor) {
		raiz = inserir(raiz,valor);
	}
	
	private No inserir(No no,int valor) {
		if(no == null) {
			no = new No(valor);
			return no;
		}
		
		if(valor < no.valor) {
			no.esq = inserir(no.esq, valor);
		} else if (valor> no.valor) {
			no.dir = inserir(no.dir, valor);
		}else{
			System.out.println("O valor " + valor + " ja existe na arvore");
		}
		
		return no;
	}
	public void emOrdem() {
		emOrdem(raiz);
	}
	
	private void emOrdem(No no) {
		if(no != null) {
			emOrdem(no.esq);
			System.out.print(no.valor + " ");
			emOrdem(no.dir);
		}
	}
	
	public boolean buscar(int valor) {
		
		No atual = raiz;
		
		while(atual != null) {
			if(valor == atual.valor) {
				return true;
			}
			
			if(valor < atual.valor) {
				atual = atual.esq;
			}else {
				atual = atual.dir;
			}
		}
		
		return false;
	}
	
	public void remover(int valor) {
		if(!buscar(valor)) {
			System.out.println("o valor nao existe nessa arvore");
			return;
		}
		raiz = remover(raiz,valor);
	}
	
	private No remover(No no, int valor) {
		// procurando pelo no
		if(valor < no.valor) {
			no.esq = remover(no.esq, valor);
		}
		else if(valor > no.valor) {
			no.dir = remover(no.dir,valor);
		}else {
			//caso 1: no folha
			if(no.esq == null && no.dir == null) {
				return null;
			}
			//caso 2: possui somente um filho
			if(no.esq == null) {
				return no.dir;
			}
			if(no.esq == null) {
				return no.esq;
			}
			//caso 3: possui dois filhos
			No sucessor = encontrarMenor(no.dir);
			
			//copia o valor do sucessor
			no.valor = sucessor.valor;
			
			//Remover o sucessor da posicao original
			no.dir = remover(no.dir,sucessor.valor);
		}
		
		return no;
	}
	
	private No encontrarMenor(No no) {
		while(no.esq != null) {
			no = no.esq;
		}
		return no;
	}
	
	public void mostrarPorNivel() {
		if(raiz==null) {
			System.out.println("Arvore vazia");
			return;
		}
		Queue<No>fila = new LinkedList<>();
		fila.add(raiz);
		
		while(!fila.isEmpty()) {
			int nivelSize = fila.size();
			for(int i = 0; i < nivelSize; i++) {
				No noAtual = fila.poll();
				
				if(noAtual != null) {
					System.out.print(noAtual.valor + " ");
					fila.add(noAtual.esq);
					fila.add(noAtual.dir);
				}else {
					System.out.print("-");
				}
			}
		System.out.println();
			
		}
	}
	
	public int quantidadeNos() {
		return quantidadeNos(raiz);
	}
	
	private int quantidadeNos(No no) {
		if(no == null) {
			return 0;
		}
		
		return 1 + quantidadeNos(no.esq) + quantidadeNos(no.dir);
	}
	
	public int MenorValor() {
		return MenorValor(raiz);
	}
	
	private int MenorValor(No no) {
		while(no.esq != null) {
			no = no.esq;
		}
		return no.valor;
	}
	
	public int MaiorValor() {
		return MaiorValor(raiz);
	}
	
	private int MaiorValor(No no) {
		while(no.dir != null) {
			no = no.dir;
		}
		return no.valor;
	}
	
	public int nivelDoNo(int valor) {
		return nivelDoNo(raiz, valor);
	}
	
	private int nivelDoNo(No no, int valor) {
	    No atual = no;
	    int nivel = 0;
	    
	    while(atual != null) {
	        if(valor == atual.valor) {
	            return nivel;
	        }
	        if(valor < atual.valor) {
	            atual = atual.esq;
	        } else {
	            atual = atual.dir;
	        }
	        nivel++;
	    }
	    
	    return -1; 
	}
	
	public int altura () {
		return altura(raiz);
	}
	
	private int altura(No no) {
		if(no == null) {
			return -1;
		}
		
		int alturaEsq = altura(no.esq);
	    int alturaDir = altura(no.dir);
	    
	    int maior;
	    if(alturaEsq > alturaDir) {
	        maior = alturaEsq;
	    } else {
	        maior = alturaDir;
	    }
	    return 1 + maior;
	}
}
	
