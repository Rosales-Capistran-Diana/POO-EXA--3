/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_ejercicio2_inventario;

/**
 *
 * @author 52614
 */
public class Producto {

//Se declaran los atributos a utilizar
    private String nombre;
    private double precio;
    private int cantidad;
    private int id;

//Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//Constructor default.
    public Producto() {
        this.nombre = " ";
        this.precio = 0;
        this.cantidad = 0;
        this.id = 0;
    }

//Constructor con parámetros
    public Producto(int cantidad, String nombre, double precio, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad;

    }
}
