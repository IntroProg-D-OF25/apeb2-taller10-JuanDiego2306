 import java.util.Scanner;
/** Crea un programa que gestione el inventario de una tienda. Utiliza una matriz bidimensional para almacenar los productos disponibles en la tienda, con información como nombre, precio y cantidad. El programa debe permitir agregar nuevos productos, actualizar existencias, buscar productos y eliminarlos.
 *
 * @Juan Quizhpe
 */
public class Ejercisio4 {
    public static void main(String[] args) {
        
        String[][] inventario = new String[10][3]; 
        int cantidadProductos = 0;  
        
      
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menú de Gestión de Inventario ===");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar cantidad de producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    agregarProducto(inventario, cantidadProductos, scanner);
                    cantidadProductos++;
                    break;
                case 2:
                    actualizarCantidad(inventario, cantidadProductos, scanner);
                    break;
                case 3:
                    buscarProducto(inventario, cantidadProductos, scanner);
                    break;
                case 4:
                    eliminarProducto(inventario, cantidadProductos, scanner);
                    cantidadProductos--;
                    break;
                case 5:
                    mostrarInventario(inventario, cantidadProductos);
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el sistema de inventario!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

   
    public static void agregarProducto(String[][] inventario, int cantidadProductos, Scanner scanner) {
        if (cantidadProductos >= inventario.length) {
            System.out.println("No se puede agregar más productos, el inventario está lleno.");
            return;
        }
        
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        String precio = scanner.nextLine();
        System.out.print("Ingrese la cantidad disponible: ");
        String cantidad = scanner.nextLine();
        
        inventario[cantidadProductos][0] = nombre;
        inventario[cantidadProductos][1] = precio;
        inventario[cantidadProductos][2] = cantidad;
        
        System.out.println("Producto agregado correctamente.");
    }

    public static void actualizarCantidad(String[][] inventario, int cantidadProductos, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();
        
        boolean encontrado = false;
        for (int i = 0; i < cantidadProductos; i++) {
            if (inventario[i][0].equalsIgnoreCase(nombre)) {
                System.out.print("Ingrese la nueva cantidad disponible: ");
                String nuevaCantidad = scanner.nextLine();
                inventario[i][2] = nuevaCantidad;
                System.out.println("Cantidad actualizada correctamente.");
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

 
    public static void buscarProducto(String[][] inventario, int cantidadProductos, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        
        boolean encontrado = false;
        for (int i = 0; i < cantidadProductos; i++) {
            if (inventario[i][0].equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + inventario[i][0]);
                System.out.println("Precio: " + inventario[i][1]);
                System.out.println("Cantidad: " + inventario[i][2]);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void eliminarProducto(String[][] inventario, int cantidadProductos, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        
        boolean encontrado = false;
        for (int i = 0; i < cantidadProductos; i++) {
            if (inventario[i][0].equalsIgnoreCase(nombre)) {
              
                for (int j = i; j < cantidadProductos - 1; j++) {
                    inventario[j] = inventario[j + 1];
                }
                inventario[cantidadProductos - 1] = new String[3]; 
                System.out.println("Producto eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
    
    public static void mostrarInventario(String[][] inventario, int cantidadProductos) {
        if (cantidadProductos == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }
        
        System.out.println("\n=== Inventario ===");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("Producto " + (i + 1) + ":");
            System.out.println("Nombre: " + inventario[i][0]);
            System.out.println("Precio: " + inventario[i][1]);
            System.out.println("Cantidad: " + inventario[i][2]);
           System.out.println("-------------------------");
        }
    }
}
/***
 * debug:
 * === Menú de Gestión de Inventario ===
1. Agregar nuevo producto
2. Actualizar cantidad de producto
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Selecciona una opción: 1
Ingrese el nombre del producto: aceite
Ingrese el precio del producto: 1
Ingrese la cantidad disponible: 100
Producto agregado correctamente.

=== Menú de Gestión de Inventario ===
1. Agregar nuevo producto
2. Actualizar cantidad de producto
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Selecciona una opción: 1
Ingrese el nombre del producto: Jabon
Ingrese el precio del producto: 1
Ingrese la cantidad disponible: 200
Producto agregado correctamente.

=== Menú de Gestión de Inventario ===
1. Agregar nuevo producto
2. Actualizar cantidad de producto
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Selecciona una opción: 1
Ingrese el nombre del producto: Pollo
Ingrese el precio del producto: 1,50
Ingrese la cantidad disponible: 300
Producto agregado correctamente.

=== Menú de Gestión de Inventario ===
1. Agregar nuevo producto
2. Actualizar cantidad de producto
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Selecciona una opción: 5

=== Inventario ===
Producto 1:
Nombre: aceite
Precio: 1
Cantidad: 100
  
Producto 2:
Nombre: Jabon
Precio: 1
Cantidad: 200
  
Producto 3:
Nombre: Pollo
Precio: 1,50
Cantidad: 300
  

=== Menú de Gestión de Inventario ===
1. Agregar nuevo producto
2. Actualizar cantidad de producto
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Selecciona una opción: 
 */
