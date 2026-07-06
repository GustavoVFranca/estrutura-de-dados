package Ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class TopKOrdenacao {

	public static void bubbleSortK(int[] vetor, int k) {
	    int n = vetor.length;
	    for (int i = 0; i < k; i++) {
	        for (int j = n - 1; j > i; j--) {
	            if (vetor[j] < vetor[j - 1]) { 
	                int aux = vetor[j];
	                vetor[j] = vetor[j - 1];
	                vetor[j - 1] = aux;
	            }
	        }
	    }
	}
	 public static void selectionSortK(int[] vetor, int k) {
	        int n = vetor.length;

	        for (int i = 0; i < k; i++) {
	            int indiceMenor = i;
	            for (int j = i + 1; j < n; j++) {
	                if (vetor[j] < vetor[indiceMenor]) {
	                    indiceMenor = j;
	                }
	            }
	            if (indiceMenor != i) {
	                int temp = vetor[i];
	                vetor[i] = vetor[indiceMenor];
	                vetor[indiceMenor] = temp;
	            }
	        }
	    }
	 public static void insertionSortK(int[] vetor, int k) {
		    int n = vetor.length;
		    for (int i = 1; i < n; i++) {
		        int chave = vetor[i];
		        int j = i - 1;
		        while (j >= 0 && vetor[j] > chave) {
		            vetor[j + 1] = vetor[j];
		            j--;
		        }
		        vetor[j + 1] = chave;
		        if (i == k - 1) break;
		    }
		}

	public static void main(String[] args) {
	    int[] dadosOriginais = {64, 34, 25, 12, 22, 11, 90, 5, 42, 18};
	
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Digite o valor de k (1 a " + dadosOriginais.length + "): ");
	    int k = scanner.nextInt();
	    scanner.close();
	
	    if (k < 1 || k > dadosOriginais.length) {
	        System.out.println("Valor de k inválido.");
	        return;
	    }
	
	    System.out.println("\nArray original: " + Arrays.toString(dadosOriginais));
	    System.out.println("k = " + k + "\n");
	    
	    int[] vetorBubble    = dadosOriginais.clone();
        int[] vetorSelection = dadosOriginais.clone();
        int[] vetorInsertion = dadosOriginais.clone();

        bubbleSortK(vetorBubble, k);
        selectionSortK(vetorSelection, k);
        insertionSortK(vetorInsertion, k);

        System.out.println("Bubble Sort    (k=" + k + "): " + Arrays.toString(vetorBubble));
        System.out.println("Selection Sort (k=" + k + "): " + Arrays.toString(vetorSelection));
        System.out.println("Insertion Sort (k=" + k + "): " + Arrays.toString(vetorInsertion));
	}
}
