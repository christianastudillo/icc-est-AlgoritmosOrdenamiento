import java.util.Arrays;
import java.util.Scanner;

public class MetodoOrdenamiento {

    // selección
    public int[] sortBySeleccion(int[] arreglo, boolean ascendente, boolean verPasos) {
        int tamanio = arreglo.length;

        for (int i = 0; i < tamanio; i++) {
            int indice = i;
            for (int j = i + 1; j < tamanio; j++) {
                if ((ascendente && arreglo[j] < arreglo[indice]) || (!ascendente && arreglo[j] > arreglo[indice])) {
                    indice = j;
                }
            }
            
            // Mostrar los valores que se están comparando

            if (verPasos) {
                System.out.println(" ");
                System.out.print("  Arreglo: " + Arrays.toString(arreglo));
                
                System.out.print("  Iteración " + (i + 1) + ": valor a: " + arreglo[i] + " con valor b: " + arreglo[indice]);
                System.out.println(" ");
            }

            // Intercambio
            int aux = arreglo[indice];
            arreglo[indice] = arreglo[i];
            arreglo[i] = aux;

            // if (verPasos) {                
            //     System.out.println("  Arreglo: " + Arrays.toString(arreglo));
            // }
        }
        return arreglo;
    }

    // inserción
    public int[] sortInserccion(int[] arreglo, boolean verPasos) {
        int tamanio = arreglo.length;

        for (int i = 1; i < tamanio; i++) {
            int aux = arreglo[i];
            int j = i - 1;

            // Mostrar los valores que se están comparando
            if (verPasos) {
                System.out.println(" ");

                System.out.print("  Arreglo: " + Arrays.toString(arreglo));
                System.out.print("  Iteración " + i + ": valor a: " + aux + " con valor b: " + arreglo[j]);
                System.out.println(" ");
            }

            while (j >= 0 && arreglo[j] > aux) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = aux;

            // if (verPasos) {
            //     System.out.print("  Arreglo: " + Arrays.toString(arreglo));
            // }
        }
        return arreglo;
    }

    // burbuja
    public int[] sortByBubble(int[] arreglo, boolean ascendente, boolean verPasos) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    // Mostrar los valores que se están comparando
                    if (verPasos) {
                        System.out.println(" ");


                        System.out.print("  Iteración " + i + ": " + Arrays.toString(arreglo));
                        System.out.print("  Iteración " + i + ", Comparando: valor a: " + arreglo[j] + " con valor b: " + arreglo[j + 1]);
                        System.out.println(" ");
                    }

                    // Intercambiar los valores
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }

            // if (verPasos) {
                
            //     System.out.print("  Iteración " + i + ": " + Arrays.toString(arreglo));
            // }
        }
        return arreglo;
    }

    // burbuja mejorada
    public int[] sortBubbleAva(int[] arreglo, boolean verPasos) {
        int n = arreglo.length;
        boolean intercambio = false;

        for (int i = 0; i < n; i++) {
            intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Mostrar los valores que se están comparando
                if (verPasos) {
                    System.out.println(" ");

                    System.out.print("  Iteración " + i + ": " + Arrays.toString(arreglo));
                    System.out.print("  Iteración " + i + ", Comparando: valor a: " + arreglo[j] + " con valor b: " + arreglo[j + 1]);
                    System.out.println(" ");
                }
                
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }

            // if (verPasos) {
            //     System.out.print("  Iteración " + i + ": " + Arrays.toString(arreglo));
            // }
        }
        return arreglo;
    }

    public int[] crearArreglo(Scanner scanner) {
        int nElementos = -1;
        while (nElementos <= 0) {
            System.out.print("Introduce el tamaño del arreglo: ");
            if (scanner.hasNextInt()) {
                nElementos = scanner.nextInt();
                if (nElementos <= 0) {
                    System.out.println("El número de elementos debe ser mayor que cero");
                }
            } else {
                System.out.println("Error, ingresar un número entero");
                scanner.next(); 
            }
        }

        int[] arreglo = new int[nElementos];

        for (int i = 0; i < nElementos; i++) {
            arreglo[i] = leerEntero(scanner, i + 1);
        }
        return arreglo;
    }

    private int leerEntero(Scanner scanner, int indice) {
        int numero = Integer.MIN_VALUE;
        while (numero == Integer.MIN_VALUE) {
            System.out.print("Introduce el valor para el elemento " + indice + ": ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
            } else {
                System.out.println("Error, ingresar un número entero");
                scanner.next(); 
            }
        }
        return numero;
    }

    public void printArreglo(int[] arreglo) {
        System.out.println(" ");
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
        System.out.println(" ");
    }
}
