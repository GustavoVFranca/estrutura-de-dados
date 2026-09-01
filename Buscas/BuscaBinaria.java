package Buscas;

public class BuscaBinaria {
	
	public static int buscaBinaria(int[] array, int valorProcurado) {
		int inicio = 0;
		int fim = array.length - 1;
		int meio;
		
		while(inicio <= fim) {
			meio = (inicio + fim)/2;
			
			if(array[inicio] == valorProcurado) {
				return meio;
			}
			if(valorProcurado > array[meio]) {
				inicio = meio + 1;
			}else if (valorProcurado < array[meio]) {
				fim = meio - 1;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int [] numeros = {3, 7, 9, 12, 18,25,30};
		int valorProcurado = 12;
		
		int posicao = buscaBinaria(numeros, valorProcurado);
		
		if(posicao != -1) {
			System.out.println("valor encontrado no indice: " + posicao);
		}else {
			System.out.println("valor nao encontrado");
		}

	}

}
