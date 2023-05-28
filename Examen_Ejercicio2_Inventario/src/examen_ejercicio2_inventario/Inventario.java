/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Inventario {
    private Producto[] productos; // Cambiado el nombre de la variable "producto" a "productos"
    private int contar;

    public Inventario() {
        this.productos = new Producto[10]; // Inicializar el arreglo de productos con tamaño 10
        this.contar = 0;
    }

//Método: addProduct(Product producto): Agrega un producto al inventario. Puede usar arreglos, limite la cantidad de productos a almacenar a 10.
    public void addProduct(Producto producto) {
        if (contar < productos.length) {
            productos[contar] = producto;
            contar++;
            System.out.println("Producto agregado al inventario");
        } else {
            System.out.println("No se pudo agregar ese producto al inventario");
        }
    }
//Método: removeProduct(int productId): elimina un producto del inventario en función de su ID.
    public void removeProduct(int productoId) {
        int remover = -1;
        for (int i = 0; i < contar; i++) {
            if (productos[i].getId() == productoId) {
                remover = i;
                break;
            }
        }

        if (remover != -1) {
            for (int i = remover; i < contar - 1; i++) {
                productos[i] = productos[i + 1];
            }
            productos[contar - 1] = null;
            contar--;
            System.out.println("El producto fue eliminado del inventario.");
        } else {
            System.out.println("El producto no fue encontrado en el inventario.");
        }
    }

//Método: searchProduct(int productId): busca un producto por su ID y devuelve el objeto Producto si lo encuentra, o nulo si no lo encuentra.
    public Producto searchProduct(int productoId) {
        for (int i = 0; i < contar; i++) {
            if (productos[i].getId() == productoId) {
                return productos[i];
            }
        }
        return null;
    }

//Método: displayInventory(): Muestra el inventario actual con todos los productos y sus detalles
    public void displayInventory() {
        if (contar == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario actual:");
            for (int i = 0; i < contar; i++) {
                System.out.println(productos[i]);
            }
        }
    }

//Método: saveToFile(String filename): Guarda todo el inventario en un archivo de texto con el nombre de archivo dado. 
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < contar; i++) {
                Producto producto = productos[i];
                writer.println(
                        producto.getId() + "," + producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCantidad());
            }
            System.out.println("Inventario guardado en el archivo: " + filename);
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario en el archivo: " + e.getMessage());
        }
    }

//Método:  loadFromFile(String filename): Carga el contenido del inventario desde un archivo de texto con el nombre de archivo dado.
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            contar = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String nombre = parts[1];
                    double precio = Double.parseDouble(parts[2]);
                    int cantidad = Integer.parseInt(parts[3]);
                    Producto prod = new Producto(cantidad, nombre, precio, id);
                    productos[contar] = prod;
                    contar++;
                }
            }
            System.out.println("Inventario cargado desde el archivo: " + filename);
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario desde el archivo: " + e.getMessage());
        }
    }
}
