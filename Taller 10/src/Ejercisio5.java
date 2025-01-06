
import java.util.Scanner;
/**Crea un programa que gestione el inventario de una tienda, así como la emisión de facturas. Utiliza una matriz bidimensional para almacenar los productos disponibles en la tienda, con información como nombre, precio y cantidad. El programa debe permitir facturar un producto dado su código, y unidades deseadas. Adicional se debe agregar a la factura al 15% del IVA, y si la compra superar los $100, se debe aplicar un descuento.
Nota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 *
 * @Juan Quizhpe
 */
public class Ejercisio5 {
    public static void main(String[] args) {
      
        String[][] inventario = new String[10][4]; 
        double[] precios = new double[10];
        int[] cantidades = new int[10];
        
        inicializarInventario(inventario, precios, cantidades);

    
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menú de Gestión de Inventario y Facturación ===");
            System.out.println("1. Ver inventario");
            System.out.println("2. Facturar producto");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcion) {
                case 1:
                    mostrarInventario(inventario, precios, cantidades);
                    break;
                case 2:
                    facturarProducto(inventario, precios, cantidades, scanner);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el sistema de inventario y facturación!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    
    public static void inicializarInventario(String[][] inventario, double[] precios, int[] cantidades) {
      
        inventario[0] = new String[]{"001", "Camiseta", "15.50"};
        inventario[1] = new String[]{"002", "Pantalón", "25.00"};
        inventario[2] = new String[]{"003", "Zapatos", "40.00"};
        inventario[3] = new String[]{"004", "Sombrero", "10.00"};
        inventario[4] = new String[]{"005", "Chaqueta", "50.00"};
        
        precios[0] = 15.50;
        precios[1] = 25.00;
        precios[2] = 40.00;
        precios[3] = 10.00;
        precios[4] = 50.00;
        
        cantidades[0] = 5; 
        cantidades[1] = 3; 
        cantidades[2] = 4; 
        cantidades[3] = 10; 
        cantidades[4] = 2; 
    }

   
    public static void mostrarInventario(String[][] inventario, double[] precios, int[] cantidades) {
        System.out.println("\n=== Inventario ===");
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                System.out.println("Código: " + inventario[i][0]);
                System.out.println("Nombre: " + inventario[i][1]);
                System.out.println("Precio: $" + precios[i]);
                System.out.println("Cantidad disponible: " + cantidades[i]);
                System.out.println("--------------------------");
            }
        }
    }

  
    public static void facturarProducto(String[][] inventario, double[] precios, int[] cantidades, Scanner scanner) {
        System.out.print("Ingrese el código del producto a facturar: ");
        String codigo = scanner.nextLine();
        
        int productoIndex = buscarProducto(codigo, inventario);
        
        if (productoIndex == -1) {
            System.out.println("Producto no encontrado.");
            return;
        }
       
        if (cantidades[productoIndex] == 0) {
            System.out.println("¡Alerta! No hay existencias de este producto.");
            return;
        }
        System.out.print("Ingrese la cantidad que desea comprar: ");
        int cantidadCompra = scanner.nextInt();
        
        if (cantidadCompra > cantidades[productoIndex]) {
            System.out.println("No hay suficiente stock. Solo quedan " + cantidades[productoIndex] + " unidades.");
            return;
        }
        
        double totalSinIVA = precios[productoIndex] * cantidadCompra;
        
        double iva = totalSinIVA * 0.15;
        
        double totalConIVA = totalSinIVA + iva;
       
        if (totalConIVA > 100) {
            double descuento = totalConIVA * 0.10; 
            totalConIVA -= descuento;
            System.out.println("Descuento aplicado: 10% ($" + descuento + ")");
        }
        
      
        System.out.println("\n=== Factura ===");
        System.out.println("Producto: " + inventario[productoIndex][1]);
        System.out.println("Precio unitario: $" + precios[productoIndex]);
        System.out.println("Cantidad comprada: " + cantidadCompra);
        System.out.println("Subtotal: $" + totalSinIVA);
        System.out.println("IVA (15%): $" + iva);
        System.out.println("Total con IVA: $" + totalConIVA);
        
        cantidades[productoIndex] -= cantidadCompra;
    }

   
    public static int buscarProducto(String codigo, String[][] inventario) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null && inventario[i][0].equals(codigo)) {
                return i; 
            }
        }
        return -1; 
    }
}
/***
 * 
=== Menú de Gestión de Inventario y Facturación ===
1. Ver inventario
2. Facturar producto
3. Salir
Selecciona una opción: 1

=== Inventario ===
Código: 001
Nombre: Camiseta
Precio: $15.5
Cantidad disponible: 5
--------------------------
Código: 002
Nombre: Pantalón
Precio: $25.0
Cantidad disponible: 3
--------------------------
Código: 003
Nombre: Zapatos
Precio: $40.0
Cantidad disponible: 4
--------------------------
Código: 004
Nombre: Sombrero
Precio: $10.0
Cantidad disponible: 10
--------------------------
Código: 005
Nombre: Chaqueta
Precio: $50.0
Cantidad disponible: 2
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------

=== Menú de Gestión de Inventario y Facturación ===
1. Ver inventario
2. Facturar producto
3. Salir
Selecciona una opción: 001

=== Inventario ===
Código: 001
Nombre: Camiseta
Precio: $15.5
Cantidad disponible: 5
--------------------------
Código: 002
Nombre: Pantalón
Precio: $25.0
Cantidad disponible: 3
--------------------------
Código: 003
Nombre: Zapatos
Precio: $40.0
Cantidad disponible: 4
--------------------------
Código: 004
Nombre: Sombrero
Precio: $10.0
Cantidad disponible: 10
--------------------------
Código: 005
Nombre: Chaqueta
Precio: $50.0
Cantidad disponible: 2
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------
Código: null
Nombre: null
Precio: $0.0
Cantidad disponible: 0
--------------------------

=== Menú de Gestión de Inventario y Facturación ===
1. Ver inventario
2. Facturar producto
3. Salir
Selecciona una opción: 5
Opción inválida. Intenta nuevamente.

=== Menú de Gestión de Inventario y Facturación ===
1. Ver inventario
2. Facturar producto
3. Salir
Selecciona una opción: 2
Ingrese el código del producto a facturar: 001
Ingrese la cantidad que desea comprar: 5

=== Factura ===
Producto: Camiseta
Precio unitario: $15.5
Cantidad comprada: 5
Subtotal: $77.5
IVA (15%): $11.625
Total con IVA: $89.125
 */

