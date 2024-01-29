/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.mision.view;

import com.mycompany.narutojava.julie.mision.controller.MisionController;
import com.mycompany.narutojava.julie.mision.model.classes.Mision;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class MisionView {
 public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        MisionController misionController = new MisionController();

        while (true) {
            try {
                System.out.println("""
                                                
                        ------- Misiones -------
                                                
                        1. Agrega Mision
                        2. Elimina mision
                        0. << Volver
                        """);
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("\nVolviendo...");
                    break;
                } else if (opcion == 1) {
                    System.out.println("Describe la mision: ");
                    String descripcion = scanner.next();
                    scanner.nextLine();
                    System.out.println("Rango de mision: ");
                    String rango = scanner.next();
                    scanner.nextLine();
                    System.out.println("Recompensa ");
                    String recompensa = scanner.next();
                    scanner.nextLine();
                    
                    Mision mision = new Mision(descripcion, descripcion,recompensa);
                    misionController.insertMision(mision);
                    scanner.nextLine();

                } else if (opcion == 2) {
                    System.out.println("Id de la mision: ");
                    int idmision = scanner.nextInt();
                    scanner.nextLine();
                    misionController.deleteMision(idmision);
                }else {
                    throw new Exception("\nError: La opcion ingresada no es valida.");
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