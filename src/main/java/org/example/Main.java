package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean encontrado = false;
        ArrayList<Producto> Inventario = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean estado = true;
        while (estado){
            System.out.println("--------");
            System.out.println("Bienvenidos");
            System.out.println("1. Crea un producto");
            System.out.println("2. Vender un producto");
            System.out.println("3. Reponer Producto");
            System.out.println("4. Aplicar Descuento a Producto");
            System.out.println("5. Mostrar Informacion de los productos");
            System.out.println("6. Aumentar el precio a un Producto");
            System.out.println("7. Calcular el valor del Inventario");
            System.out.println("8. Eliminar un producto");
            System.out.println("9. Salir");
            System.out.println("--------");
            int opc = sc.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Ingrese el Codigo del Producto:");
                        int CodigoP = sc.nextInt();
                    System.out.println("Ingrese el Nombre del Producto");
                        String NombreP = sc.next();
                    System.out.println("Ingrese el Precio del Producto");
                        double Precio = sc.nextDouble();
                    System.out.println("Ingrese la cantidad de Stock");
                        int Stock = sc.nextInt();
                    Producto nuevoProducto = new Producto(CodigoP, NombreP, Precio, Stock);
                    Inventario.add(nuevoProducto);
                    System.out.println("Producto agregado exitosamente.");
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del producto a Vender");
                    int codigoVender = sc.nextInt();
                    System.out.println("Ingrese la cantidad a Vender");
                    int CantidadVender = sc.nextInt();
                    for (Producto p: Inventario){
                        if(p.getCodigoP() == codigoVender){
                            p.VenderProducto(CantidadVender);
                            encontrado = true;
                            break;
                        }
                    }if (!encontrado){
                    System.out.println("Producto no encontrado");
                }
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto a reponer: ");
                    int codigoReponer = sc.nextInt();
                    for (Producto p : Inventario) {
                        if (p.getCodigoP() == codigoReponer) {
                            System.out.print("Ingrese la cantidad a reponer: ");
                            int cantidadReponer = sc.nextInt();
                            if (cantidadReponer > 0) {
                                p.Reponer(cantidadReponer);
                                encontrado = true;
                            }else{
                                System.out.println("Valor ingresado debe ser mayor a 0");
                            }
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el código del producto para aplicar descuento: ");
                    int codigoDescuento = sc.nextInt();
                    for (Producto p : Inventario) {
                        if (p.getCodigoP() == codigoDescuento) {
                            p.Descuento();
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 5:
                    for (Producto p : Inventario) {
                        System.out.println("--------");
                        p.mostrarInformacion();
                        System.out.println("--------");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el codigo del producto al cual le vas a aumentar el precio");
                    int codigoAumentar = sc.nextInt();
                    for(Producto p : Inventario){
                        if (p.getCodigoP() == codigoAumentar){
                            p.aumentarPrecio();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 7:
                    double totalInventario = 0;
                    for (Producto p : Inventario) {
                        totalInventario += p.calcularValorInventario();
                    }
                    System.out.println("Valor total del inventario: " + totalInventario);
                    break;
                case 8:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    int codigoEliminar = sc.nextInt();
                    Iterator<Producto> iterator = Inventario.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().getCodigoP() == codigoEliminar) {
                            iterator.remove();
                            System.out.println("Producto eliminado exitosamente.");
                            break;
                        }
                    }
                    break;
                case 9:
                    estado = false;
                    System.out.println("Cerrando Programa...");
                    break;
                default:
                    System.out.println("Opcion Invalida, Eliga por favor una opcion valida");

            }
        }
    }
}