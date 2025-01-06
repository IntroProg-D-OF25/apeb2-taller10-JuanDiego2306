import java.util.Random;
/**Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su procesamiento para presentar los elementos:
De la diagonal principal.
De la diagonal segundaria.
Ubicados bajo la diagonal principal.
Ubicados sobre la diagonal principal.
Ubicados bajo la diagonal secundaria.
Ubicados sobre la diagonal secundaria.
 *
 * Juan Quizhpe
 */
public class Ejercisio1 {
    public static void main(String[] args) {
        
        int m = 5;  
        int[][] matriz = generarMatriz(m);
       
        System.out.println("Matriz generada:");
        imprimirMatriz(matriz);
        
        System.out.println("\nDiagonal Principal:");
        mostrarDiagonalPrincipal(matriz);
        
        System.out.println("\nDiagonal Secundaria:");
        mostrarDiagonalSecundaria(matriz);
        
        System.out.println("\nElementos bajo la diagonal principal:");
        mostrarElementosBajoDiagonalPrincipal(matriz);
        
        System.out.println("\nElementos sobre la diagonal principal:");
        mostrarElementosSobreDiagonalPrincipal(matriz);
        
        System.out.println("\nElementos bajo la diagonal secundaria:");
        mostrarElementosBajoDiagonalSecundaria(matriz);
        
        System.out.println("\nElementos sobre la diagonal secundaria:");
        mostrarElementosSobreDiagonalSecundaria(matriz);
    }

    public static int[][] generarMatriz(int m) {
        Random rand = new Random();
        int[][] matriz = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = rand.nextInt(10) + 1;  
            }
        }
        return matriz;
    }

    
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void mostrarDiagonalPrincipal(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + "\t");
        }
        System.out.println();
    }

    public static void mostrarDiagonalSecundaria(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][n - 1 - i] + "\t");
        }
        System.out.println();
    }

    
    public static void mostrarElementosBajoDiagonalPrincipal(int[][] matriz) {
        int n = matriz.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println();
    }

    
    public static void mostrarElementosSobreDiagonalPrincipal(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println();
    }

    public static void mostrarElementosBajoDiagonalSecundaria(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println();
    }

    public static void mostrarElementosSobreDiagonalSecundaria(int[][] matriz) {
        int n = matriz.length;
        for (int i = 1; i < n; i++) {
            for (int j = n - i; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println();
    }
}
    
/***
 * debug:
 * Matriz generada:
3	6	7	10	5	
5	8	3	5	6	
4	5	9	5	9	
8	6	6	5	1	
4	1	5	7	6	

Diagonal Principal:
3	8	9	5	6	

Diagonal Secundaria:
5	5	9	6	4	

Elementos bajo la diagonal principal:
5	4	5	8	6	6	4	1	5	7	

Elementos sobre la diagonal principal:
6	7	10	5	3	5	6	5	9	1	

Elementos bajo la diagonal secundaria:
3	6	7	10	5	8	3	4	5	8	

Elementos sobre la diagonal secundaria:
6	5	9	6	5	1	1	5	7	6	
 */
