import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j-1] > cur) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur;
        }
    }

    public static void quickSort(int[ ] S) {
       int n = S.length;
       if (n < 2) return;

       int pivot = S[n-1];
       int m = 0, k = n;
       int[ ] temp = new int[n];
       for (int i = 0; i < n - 1; i++)
          if (S[i] < pivot)
          temp[m++] = S[i];
        else if (S[i] > pivot)
          temp[--k] = S[i];
        int[ ] L = Arrays.copyOfRange(temp, 0, m);
        int[ ] E = new int[k - m];
        Arrays.fill(E, pivot);
        int[ ] G = Arrays.copyOfRange(temp, k, n);

        quickSort(L);
        quickSort(G);

        System.arraycopy(L, 0, S, 0, m);
        System.arraycopy(E, 0, S, m, k - m);
        System.arraycopy(G, 0, S, k, n - k);
        }

    public static int inPlaceQuickSortWithRandomPivot(int[] A) {
        int[] numOfCom = {0};
        Random random = new Random();
        inPlaceQuickSortWithRandomPivot(A, 0, A.length-1, random.nextInt(A.length), numOfCom);
        return numOfCom[0];
    }

    public static int inPlaceQuickSortWithRandomPivot(int[] A, int p, int q, int i, int[] numOfCom) { // this one is more optimal
        if(p == q) {
            return A[p];
        }
        int r = partition(A, p, q, numOfCom);
        int k = r - p + 1;
        if(i == k) {
            return A[r];
        } else if(i < k) {
            return inPlaceQuickSortWithRandomPivot(A, p, r-1, i, numOfCom);
        } else {
            return inPlaceQuickSortWithRandomPivot(A, r+1, q, i-k, numOfCom);
        }
    }

    public static int partition(int[] A, int p, int q, int[] numOfComp) {
        int pivot = A[p];
        int i = p;
        for (int j=p + 1; j<q; j++) {
            if (A[j] < pivot) {
                i++;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        numOfComp[0] += (q-p);

        int temp = A[i];
        A[i] = A[p];
        A[p] = temp;
        return i;
    }


}
