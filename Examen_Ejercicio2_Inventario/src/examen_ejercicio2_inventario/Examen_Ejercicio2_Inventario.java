/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen_ejercicio2_inventario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author 52614
 */
public class Examen_Ejercicio2_Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Creamos el objeto de inventario
        Inventario inventario = new Inventario();
        
//Creamos los productos a utilizar
        Producto producto1 = new Producto(7, "Tomate", 15.99, 5);
        Producto producto2 = new Producto(3, "Papa", 29.99, 3);
        Producto producto3 = new Producto(1, "Sandia", 20.99, 2);


        inventario.addProduct(producto1);
        inventario.addProduct(producto2);
        inventario.addProduct(producto3);

        inventario.displayInventory();

        Producto productoBuscado = inventario.searchProduct(2);
        if (productoBuscado != null) {
            System.out.println("Producto encontrado: " + productoBuscado);
        } else {
            System.out.println("Producto no encontrado.");
        }

        inventario.removeProduct(1);
        inventario.displayInventory();

        inventario.saveToFile("inventario.txt");

        Inventario nuevoInventario = new Inventario();
        nuevoInventario.loadFromFile("inventario.txt");
        nuevoInventario.displayInventory();
    }

}