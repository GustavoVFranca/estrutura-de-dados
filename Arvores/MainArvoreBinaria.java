package Arvores;

public class MainArvoreBinaria {
	public static void main(String[] args) {
		ArvoreBinaria arvoreB = new ArvoreBinaria();
		
		ArvoreBinaria.No noA = arvoreB.criarRaiz('A');
		
		ArvoreBinaria.No noB = arvoreB.adicionarEsquerdo(noA, 'B');
		ArvoreBinaria.No noC = arvoreB.adicionarDireito(noA, 'C');
		
		ArvoreBinaria.No noD = arvoreB.adicionarEsquerdo(noB, 'D');
		ArvoreBinaria.No noE = arvoreB.adicionarDireito(noB, 'E');
	
		ArvoreBinaria.No noF = arvoreB.adicionarDireito(noC, 'F');
		
		System.out.println("Pre-ordem");
		arvoreB.preOrdem();
		
		System.out.println("Em ordem");
		arvoreB.emOrdem();
		
		System.out.println("Pos-ordem");
		arvoreB.posOrdem();
		
		System.out.println("quantidade folhas");
		System.out.println(arvoreB.quantidadeFolhas());
		
		
	}
}
