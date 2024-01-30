/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.ninja.view;

import com.mycompany.narutojava.julie.ninja.controller.NinjaController;
import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;
import com.mycompany.narutojava.julie.ninja.model.clases.builder.NinjaBuilder;
import com.mycompany.narutojava.julie.ninja.model.clases.builder.NinjaConcreteBuilder;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class NinjaView {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                NinjaController ninjaController = new NinjaController();
                NinjaBuilder ninjaBuilder = new NinjaConcreteBuilder();
                System.out.println("""
                                                
                        ------- Ninjas -------
                                                
                        1. Agrega Ninja
                        2. Elimina Ninja
                        3. Muestra Ninjas
                        4. Muestra Ninja
                        0. << Volver
                        """);
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("\nVolviendo...");
                    break;
                } else if (opcion == 1) {
                    System.out.println("Agrega los datos: ");
                    System.out.println("Nombre del Ninja: ");
                    String nombre = scanner.next();
                    System.out.println("Rango del Ninja: ");
                    String rango = scanner.next();
                    System.out.println("Aldea del Ninja: ");
                    String aldea = scanner.next();

                    Ninja ninja = ninjaBuilder.nombre(nombre)
                            .rango(rango)
                            .aldea(aldea)
                            .build();
                    ninjaController.insertNinja(ninja);
                    scanner.nextLine();
                } else if (opcion == 2) {
                    System.out.println("Id del Ninja: ");
                    int idNinja = scanner.nextInt();
                    ninjaController.deleteNinja(idNinja);
                } else if (opcion == 3) {
                    System.out.println("Mostrar Ninjas ");

                    List<Ninja> listNinja = ninjaController.getAllNinjas();
                    for (Ninja ninja1 : listNinja) {
                        System.out.println(ninja1);

                    }
                } else if (opcion == 4) {
                    System.out.println("Ninja ");
                    int idNinja = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(ninjaController.getByIdNinjas(idNinja)); 
                    
                } else {
                    throw new Exception("\nError: La opcion ingresada no es valida.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\nError: El caracter ingresado no es valido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }scanner.close();
    }
}
