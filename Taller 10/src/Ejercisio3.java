 import java.util.Random;
/**Ejercicio 3
El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar el periodo, la Dirección de la carrera de Computación a solicitado las siguientes estadísticas de la materia INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios por estudiante, dichos promedios se deben calcular (ponderar, ya que el docente ingresa todo sobre 10pts.) de 3 calificaciones (ACD que representa el 35% de la nota, APE del 35% y la nota del AA con un peso del 30%). En resumen, los requerimientos son los siguientes:
Registre los nombres de cada estudiante de dicho paralelo.
Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
Obtenga el promedio del curso, del paralelo C.
Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 *
 * @Juan Quizhpe
 */
public class Ejercisio3 {
    public static void main(String[] args) {
        
        String[] estudiantes = new String[28];
        for (int i = 0; i < 28; i++) {
            estudiantes[i] = "Estudiante " + (i + 1);
        }
        
        double[] acd = new double[28];
        double[] ape = new double[28];
        double[] aa = new double[28];
        double[] promedios = new double[28];
        
        
        Random rand = new Random();
        for (int i = 0; i < 28; i++) {
            acd[i] = rand.nextDouble() * 10;  
            ape[i] = rand.nextDouble() * 10;  
            aa[i] = rand.nextDouble() * 10;  
            
            
            promedios[i] = acd[i] * 0.35 + ape[i] * 0.35 + aa[i] * 0.30;
        }
        
     
        double promedioCurso = calcularPromedioCurso(promedios);
        
       
        System.out.println("Promedio del curso: " + promedioCurso);
        System.out.println("\nEstudiantes con promedio por encima del promedio del curso:");
        for (int i = 0; i < 28; i++) {
            if (promedios[i] > promedioCurso) {
                System.out.println(estudiantes[i] + ": " + promedios[i]);
            }
        }
        
        System.out.println("\nEstudiantes con promedio por debajo del promedio del curso:");
        for (int i = 0; i < 28; i++) {
            if (promedios[i] < promedioCurso) {
                System.out.println(estudiantes[i] + ": " + promedios[i]);
            }
        }
        
        int indiceMayor = obtenerIndiceMaximo(promedios);
        System.out.println("\nEstudiante con el mayor promedio: " + estudiantes[indiceMayor] + ": " + promedios[indiceMayor]);
        
        
        int indiceMenor = obtenerIndiceMinimo(promedios);
        System.out.println("\nEstudiante con el menor promedio: " + estudiantes[indiceMenor] + ": " + promedios[indiceMenor]);
    }

    
    public static double calcularPromedioCurso(double[] promedios) {
        double suma = 0;
        for (int i = 0; i < promedios.length; i++) {
            suma += promedios[i];
        }
        return suma / promedios.length;
    }

   
    public static int obtenerIndiceMaximo(double[] promedios) {
        int indiceMaximo = 0;
        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] > promedios[indiceMaximo]) {
                indiceMaximo = i;
            }
        }
        return indiceMaximo;
    }
    
    public static int obtenerIndiceMinimo(double[] promedios) {
        int indiceMinimo = 0;
        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] < promedios[indiceMinimo]) {
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }
}
/***
 * debug:
 * Promedio del curso: 4.926517733882719

Estudiantes con promedio por encima del promedio del curso:
Estudiante 1: 5.584689023547998
Estudiante 3: 6.334857751915942
Estudiante 4: 6.41028125274136
Estudiante 5: 6.849039751976975
Estudiante 7: 5.624973848843761
Estudiante 8: 6.828315705471838
Estudiante 12: 5.460027964478103
Estudiante 14: 5.512227143212556
Estudiante 18: 7.625573610001703
Estudiante 21: 8.07496966670671
Estudiante 25: 6.251108818092142
Estudiante 26: 5.886504757279791
Estudiante 27: 6.198316005494504

Estudiantes con promedio por debajo del promedio del curso:
Estudiante 2: 2.9783660402428636
Estudiante 6: 2.3142726290346687
Estudiante 9: 2.7800694603810885
Estudiante 10: 4.792513800279931
Estudiante 11: 2.899691067215695
Estudiante 13: 3.776054027166605
Estudiante 15: 4.122994475480356
Estudiante 16: 4.879878079729961
Estudiante 17: 4.063439830870068
Estudiante 19: 1.7721286177333027
Estudiante 20: 4.526962773617819
Estudiante 22: 4.802793170383762
Estudiante 23: 4.548643487085622
Estudiante 24: 2.2126839082526875
Estudiante 28: 4.8311198814783065

Estudiante con el mayor promedio: Estudiante 21: 8.07496966670671

Estudiante con el menor promedio: Estudiante 19: 1.7721286177333027
 */

