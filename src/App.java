import java.util.Scanner;
import java.util.Arrays;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MetodoOrdenamiento mo = new MetodoOrdenamiento();
        int[] arreglo = null;

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Ingresar un arreglo");
            System.out.println("2. Ordenar arreglo");
            System.out.println("0. Salir");
            int opcion = leerOpcion(scanner, 0, 2);  

            switch (opcion) {
                case 1:
                    arreglo = mo.crearArreglo(scanner);
                    break;
                case 2:
                    if (arreglo != null) {
                        System.out.println("Elija un método de ordenamiento:");
                        System.out.println("1. Selección");
                        System.out.println("2. Inserción");
                        System.out.println("3. Burbuja");
                        System.out.println("4. Burbuja mejorada");
                        int metodo = leerOpcion(scanner, 1, 4);  

                        System.out.println("1. Ascendente");
                        System.out.println("2. Descendente");
                        boolean ascendente = leerOpcion(scanner, 1, 2) == 1;

                        System.out.println("¿Desea ver los pasos?");
                        System.out.println("1. Sí");
                        System.out.println("2. No");
                        boolean verPasos = leerOpcion(scanner, 1, 2) == 1;

                        // Crear una copia del arreglo original antes de ordenar
                        int[] copiaArreglo = Arrays.copyOf(arreglo, arreglo.length);

                        switch (metodo) {
                            case 1:
                                copiaArreglo = mo.sortBySeleccion(copiaArreglo, ascendente, verPasos);
                                break;
                            case 2:
                                copiaArreglo = mo.sortInserccion(copiaArreglo, verPasos);
                                break;
                            case 3:
                                copiaArreglo = mo.sortByBubble(copiaArreglo, ascendente, verPasos);
                                break;
                            case 4:
                                copiaArreglo = mo.sortBubbleAva(copiaArreglo, verPasos);
                                break;
                            default:
                                System.out.println("Método inválido.");
                        }

                        // Imprimir el arreglo ordenado (copia)
                        mo.printArreglo(copiaArreglo);
                    } else {
                        System.out.println("Por favor, ingrese un arreglo primero.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static int leerOpcion(Scanner scanner, int min, int max) {
        int opcion = -1;
        while (opcion < min || opcion > max) {
            System.out.print("Ingrese una opción (" + min + "-" + max + "): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion < min || opcion > max) {
                    System.out.println("Opción fuera de rango. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número.");
                scanner.next(); 
            }
        }
        return opcion;
    }
}