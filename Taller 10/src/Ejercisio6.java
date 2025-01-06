   import java.util.Scanner;
/**Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3. Permita a dos jugadores marcar sus movimientos alternativamente. El juego debe verificar si alguno de los jugadores ha ganado o si hay un empate.
 *
 * @Juan Quizhpe
 */
public class Ejercisio6 {
    public static void main(String[] args) {

        char[][] tablero = new char[3][3];
      
        inicializarTablero(tablero);
        
        boolean turnoJugador = true; 
        boolean juegoTerminado = false;
        
        Scanner scanner = new Scanner(System.in);
        
       
        while (!juegoTerminado) {
            mostrarTablero(tablero);
          
            System.out.println("Jugador " + (turnoJugador ? "1 (X)" : "2 (O)") + ", ingresa la fila y columna (0-2):");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            
          
            if (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' ') {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            } else {
                
                tablero[fila][columna] = turnoJugador ? 'X' : 'O';
             
                if (verificarGanador(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Jugador " + (turnoJugador ? "1 (X)" : "2 (O)") + " ha ganado!");
                    juegoTerminado = true;
                } else if (esEmpate(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Es un empate!");
                    juegoTerminado = true;
                } else {
                  
                    turnoJugador = !turnoJugador;
                }
            }
        }
        
        scanner.close();
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' '; 
            }
        }
    }
    
    public static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
    public static boolean verificarGanador(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                return true;
            }
        }
   
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }
        
        return false;
    }

    public static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; 
                }
            }
        }
        return true; 
    }
}
/**
 * debug:
 * 
 */
