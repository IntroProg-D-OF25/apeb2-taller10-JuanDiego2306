   import java.util.Random;
/**
 *Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios, desarrollar su procesamiento para calcular y presentar:
La suma de las dos matrices (considerar las restricciones matemáticas para ello).
La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 * @Juan Quizhpe
 */
public class Ejercisio2 {
    public static void main(String[] args) {
       
        int m1 = 3, n1 = 2;
        int m2 = 2, n2 = 4; 
        
     
        int[][] matriz1 = generarMatriz(m1, n1);
        int[][] matriz2 = generarMatriz(m2, n2);
       
        System.out.println("Matriz 1:");
        imprimirMatriz(matriz1);
        
        System.out.println("\nMatriz 2:");
        imprimirMatriz(matriz2);
        
        
        if (m1 == m2 && n1 == n2) {
            int[][] suma = sumaMatrices(matriz1, matriz2);
            System.out.println("\nSuma de las matrices:");
            imprimirMatriz(suma);
        } else {
            System.out.println("\nLas matrices no tienen el mismo tamaño, no se puede realizar la suma.");
        }
     
        if (n1 == m2) {
            int[][] multiplicacion = multiplicarMatrices(matriz1, matriz2);
            System.out.println("\nMultiplicación de las matrices:");
            imprimirMatriz(multiplicacion);
        } else {
            System.out.println("\nNo se puede realizar la multiplicación, las dimensiones no son compatibles.");
        }
    }

    public static int[][] generarMatriz(int filas, int columnas) {
        Random rand = new Random();
        int[][] matriz = new int[filas][columnas];
     
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
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

    
    public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];
        

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

  
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;
        
        
        if (columnas1 != filas2) {
            System.out.println("Error: La multiplicación no puede ser posible, las dimensiones no coinciden.");
            return new int[0][0];  
        }
        
        int[][] resultado = new int[filas1][columnas2];
        
        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < columnas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }
}
/**
 * debug:
 * Matriz 1:
2	7	
1	10	
8	1	

Matriz 2:
6	5	4	9	
9	10	6	2	

Las matrices no tienen el mismo tamaño, no se puede realizar la suma.

Multiplicación de las matrices:
75	80	50	32	
96	105	64	29	
57	50	38	74	
 */

