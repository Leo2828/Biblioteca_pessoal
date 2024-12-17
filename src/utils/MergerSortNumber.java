package utils;

public class MergerSortNumber {
 
    public void sort(int[] vetor) {
        sort(vetor, 0, vetor.length - 1);
    }
   
    private void sort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
         
            sort(vetor, esquerda, meio);   
            sort(vetor, meio + 1, direita);        
            merge(vetor, esquerda, meio, direita);
        }
    }
   
    private void merge(int[] vetor, int esquerda, int meio, int direita) {
       
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
 
 
        int[] esquerdavetor = new int[n1];
        int[] direitavetor = new int[n2];
 
 
        for (int i = 0; i < n1; i++) {
            esquerdavetor[i] = vetor[esquerda + i];
        }
        for (int j = 0; j < n2; j++) {
            direitavetor[j] = vetor[meio + 1 + j];
        }
       
        int i = 0, j = 0;
        int k = esquerda;
 
 
        while (i < n1 && j < n2) {
            if (esquerdavetor[i] <= direitavetor[j]) {
                vetor[k] = esquerdavetor[i];
                i++;
            } else {
                vetor[k] = direitavetor[j];
                j++;
            }
            k++;
        }
       
        while (i < n1) {
            vetor[k] = esquerdavetor[i];
            i++;
            k++;
        }
       
        while (j < n2) {
            vetor[k] = direitavetor[j];
            j++;
            k++;
        }
    }
}
