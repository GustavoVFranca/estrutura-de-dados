package Arvores;

public class MainArvoreBinariaBusca {
	public static void main (String[] args) {
		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		
		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(70);
		arvore.inserir(20);
		arvore.inserir(40);
		arvore.inserir(60);
		arvore.inserir(80);
		
		System.out.println("testando com valor repetido");
		arvore.inserir(60);
		
		System.out.println();
		
		System.out.println("Percurso em ordem: ");
		arvore.emOrdem();
		System.out.println();
		
		System.out.println();
		System.out.println("existe 80? " + arvore.buscar(80));
		System.out.println("existe 90? " + arvore.buscar(90));
		System.out.println();
		
		System.out.println("Removendo o valor 50 e 20");
		arvore.remover(50);
		arvore.remover(20);
		arvore.emOrdem();
		
		System.out.println();
		System.out.println("percurso por nivel:");
		arvore.mostrarPorNivel();
		
		System.out.println("Quantidade de nos: ");
		System.out.println(arvore.quantidadeNos());
		
		System.out.println("menor valor:");
		System.out.println(arvore.MenorValor());
		
		System.out.println("maior valor:");
		System.out.println(arvore.MaiorValor());
		
		System.out.println("nivel do no 40: ");
		System.out.println(arvore.nivelDoNo(40));
		
		System.out.println("altura da arvore: ");
		System.out.println(arvore.altura());
	}
}
