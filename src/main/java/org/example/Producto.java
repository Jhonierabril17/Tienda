package org.example;

import java.security.PublicKey;

public class Producto {

    private int CodigoP;
    private String NombreP;
    private double Precio;
    private int Stock;

    public Producto() {
    }

    public Producto(int codigoP, String nombreP, double precio, int stock) {
        CodigoP = codigoP;
        NombreP = nombreP;
        Precio = precio;
        Stock = stock;
    }

    public void VenderProducto(int CantidadStock){
        if(CantidadStock <= Stock ){
            Stock -= CantidadStock;
            System.out.println("Venta realizada");
            System.out.println("Nuevo Stock de: "+ Stock);
        }else {
            System.out.println("No hay Stock disponible");
        }
    }

    public void Reponer(int CantidadStock){
            CantidadStock += Stock;
            System.out.println("Stock actualizado. Nuevo stock: " + CantidadStock);
    }

    public void Descuento(){
        Precio -= Precio * 0.02;
        System.out.println("Descuento aplicado con exito, el precio del producto es: " + Precio);
    }

    public void aumentarPrecio(){
        Precio += Precio * 0.06;
        System.out.println("Precio Actualizado con exito, Nuevo precio: "+ Precio);
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + CodigoP);
        System.out.println("Nombre: " + NombreP);
        System.out.println("Precio: " + Precio);
        System.out.println("Stock: " + Stock);
    }

    public double calcularValorInventario(){
        return Stock * Precio;
    }

    public int getCodigoP() {
        return CodigoP;
    }

}
