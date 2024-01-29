/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.habilidad.view;

import com.mycompany.narutojava.julie.habilidad.controller.HabilidadController;
import com.mycompany.narutojava.julie.habilidad.model.classes.Habilidad;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class HabilidadView {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        HabilidadController habilidadController = new HabilidadController();

        while (true) {
            try {
                System.out.println("""
                                                
                        ------- Habilidades -------
                                                
                        1. Agrega Habilidad
                        2. Elimina Habilidad
                        0. << Volver
                        """);
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("\nVolviendo...");
                    break;
                } else if (opcion == 1) {
                    System.out.println("Nombre de la Habilidad: ");
                    String nombre = scanner.next();
                    System.out.println("Describe: ");
                    String descripcion = scanner.next();
                    System.out.println("Escoge tu ninja ");

                    Habilidad habilidad = new Habilidad(2, nombre, descripcion);
                    habilidadController.insertHabilidad(habilidad);

                } else if (opcion == 2) {
                    System.out.println("Id de la habilidad: ");
                    int idhabilidad = scanner.nextInt();
                    habilidadController.deleteHabilidad(idhabilidad);
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\nError: El caracter ingresado no es valido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
