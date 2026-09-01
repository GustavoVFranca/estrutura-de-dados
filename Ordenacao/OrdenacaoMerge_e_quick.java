package ordenacaoNovo;

import java.util.Arrays;

public class OrdenacaoMerge_e_quick {
	public static void mergeSort(int [] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		
		mergeSortRecursivo(array, 0,array.length-1);
	}
	
	private static void mergeSortRecursivo(int[] array, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim)/2;
			// divisao: ordena recursivamente o subarray esquerdo e direito
			mergeSortRecursivo(array, inicio, meio);
			mergeSortRecursivo(array, meio+1, fim);
			
			//conquista: intercala os dois subarrays previamente ordenados
			merge(array, inicio, meio, fim);
		}
	}
	private static void merge (int [] array, int inicio, int meio, int fim) {
		
		// 1 determinacao do tamanho dos subarrays
		int tamanhoEsq = meio - inicio + 1;
		int tamanhoDir = fim - meio;
		
		int [] vetorEsq = new int [tamanhoEsq];
		int[] vetorDir = new int[tamanhoDir];
		
		// 2 copia dos elementos do vetor principal para os auxiliares
		for(int i = 0; i<tamanhoEsq; i++) {
			vetorEsq[i] = array[inicio + i];
		}
		
		for(int j = 0; j< tamanhoDir; j++) {
			vetorDir[j] = array[meio + 1 + j];
		}
		
		// 3 processo de intercalaçao(merge)
		int i = 0; // ponteiro de leitura do subarray esquerdo
		int j = 0; // ponteiro de leitura do subarray direito
		int k = inicio; // ponteiro de gravação no array original
		
		// compara os elementos e insere o menor no array original
		while(i < tamanhoEsq && j < tamanhoDir) {
			if(vetorEsq[i] <= vetorDir[j]) {
				array[k] = vetorEsq[i];
				i++;
			}else {
				array[k] = vetorDir[j];
				j++;
			}
			k++;
		}
		//4 transferencia de elementos remanescentes(se houver)
		while(i < tamanhoEsq) {
		    array[k] = vetorEsq[i];
		    i++;
		    k++;
		}
		while(j < tamanhoDir) {
		    array[k] = vetorDir[j];
		    j++;
		    k++;
		}
	}
	
	public static void quickSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		quickSortRecursivo(array, 0, array.length -1);
	}
	
	private static void quickSortRecursivo(int[] array, int inicio, int fim) {
		if(inicio < fim) {
			//posiciona  elementos em relacao ao piv e obtem o indice de corte
			int pontoDeCorte = particao(array, inicio, fim);
			
			quickSortRecursivo(array, inicio, pontoDeCorte);
			quickSortRecursivo(array, pontoDeCorte + 1, fim);
		}
	}
	
	private static int particao(int [] array, int inicio, int fim) {
		//1 definicao do pivo
		int meio = (inicio + fim) / 2;
		int pivo = array[meio];
		
		//2 inicializacao do ponteiros nas extremidades do escopo atual
		int i = inicio;
		int j = fim;
		
		while(true) {
			// avança o ponteiro i ate encontrar um elemento maior ou igual o pivo
			while(array[i]< pivo) {
				i++;
			}
			//recua o ponteiro j ate encontrar um elemento menor ou igual o pivo
			while(array[j] > pivo) {
				j--;
			}
			if(i>=j) {
				return j;
			}
			//3 operacao de troca para readequar os elementos mal posicionados
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			
			//incremento para evitar laco infinito apos troca de elementos igauis ao pivo
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		int[] arrayOriginal = {64, 34, 25, 12, 22, 11, 90,5, 42, 8};
		System.out.println("Array original: " + Arrays.toString(arrayOriginal));

		System.out.println("==============================================");
		
		int[] arrayMerge = arrayOriginal.clone();
	
		
		long inicioMerge = System.nanoTime();
		OrdenacaoMerge_e_quick.mergeSort(arrayMerge);
		long fimMerge = System.nanoTime();
		
		System.out.println("Merge Sort");
		System.out.println("array ordenado mergesort" + Arrays.toString(arrayMerge));
		System.out.println("Tempo de execucao: " + (fimMerge - inicioMerge));
		
		System.out.println("==============================================");
		
		int [] arrayQuick = arrayOriginal.clone();
		
		long inicioQuick = System.nanoTime();
		OrdenacaoMerge_e_quick.quickSort(arrayQuick);
		long fimQuick = System.nanoTime();
		
		System.out.println("Quick Sort");
		System.out.println("array ordenado QuickSort " + Arrays.toString(arrayQuick));
		System.out.println("Tempo de execucao: " + (fimQuick - inicioQuick));
	}
	
	
}
