package Ordenacao;

import java.util.Arrays;
import java.util.Random;


public class OrdenacaoQuadratica {
	
	// bubble sort
	public static MetricaOrdenacao bubbleSort(int[] vetor) {
        int comparacoes = 0, trocas = 0;
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparacoes++;                          
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
        return new MetricaOrdenacao(comparacoes, trocas);
    }
	//selection sort
	public static MetricaOrdenacao selectionSort(int [] vetor) {
		int n = vetor.length;
		int comparacoes = 0;
		int troca = 0;
		
		for (int i = 0; i < n-1; i++) {
			int indiceMenor = i;
			// busca menor elemento na parte nao ordenada
			for(int j = i; j < n; j++) {
				comparacoes++;
				if(vetor[j] < vetor[indiceMenor]) {
					indiceMenor = j;
				}
			}
			if(indiceMenor != i) {
				int temp = vetor[i];
				vetor[i] = vetor [indiceMenor];
				vetor[indiceMenor] = temp;
				troca++;
			}
		}
		return new MetricaOrdenacao(comparacoes, troca);
	}
	
	public static MetricaOrdenacao insertionSort(int [] vetor) {
		int n = vetor.length;
		int comparacoes = 0;
		int troca = 0;
		
		for(int i = 1; i < n; i++) {
			int chave = vetor[i];
			int j = i - 1;
			while(j >= 0 && vetor[j] > chave) {
				comparacoes++;
				vetor[j+1] = vetor[j];
				troca++;
				j--;
			}
			
			vetor[j+1] = chave;
		}
		return new MetricaOrdenacao(comparacoes, troca);
	}
	
	public static void main(String[] args) {
		int [] dadosOriginais = new int[10000];
		Random ran = new Random();
		for(int i = 0; i < 10000; i++) {
			dadosOriginais[i] = ran.nextInt(100000);
		}
		int[] vetorBubble     = dadosOriginais.clone();
        int[] vetorSelection  = dadosOriginais.clone();
        int[] vetorInsertion  = dadosOriginais.clone();

        MetricaOrdenacao mBubble    = bubbleSort(vetorBubble);
        MetricaOrdenacao mSelection = selectionSort(vetorSelection);
        MetricaOrdenacao mInsertion = insertionSort(vetorInsertion);

        System.out.println("Resultado com 10000 elementos");
        System.out.println("Bubble Sort Comparações: " + mBubble.getComparacao()
                + " | Trocas: " + mBubble.getTroca());
        System.out.println("Selection Sort Comparações: " + mSelection.getComparacao()
                + " | Trocas: " + mSelection.getTroca());
        System.out.println("Insertion Sort Comparações: " + mInsertion.getComparacao()
                + " | Trocas: " + mInsertion.getTroca());
	}
}
