/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.narutojava.julie;

import com.mycompany.narutojava.julie.habilidad.view.HabilidadView;
import com.mycompany.narutojava.julie.mision.view.MisionView;
import com.mycompany.narutojava.julie.ninja.view.NinjaView;
import com.mycompany.narutojava.julie.persistence.BDConnection;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class NarutoJavaJulie {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Operations.setConnection(BDConnection.MySQLConnection());
            
            
            System.out.println("---- Aldea Ninja de Konoha ----");
            while(true){
                try {
                    System.out.println("""
                            ------- MENU PRINCIPAL -------
                            Elige una opcion:
                            1) Ninjas
                            2) Habilidades
                            3) Misiones
                            0) Salir
                                            """); 
                    System.out.print("Opcion: ");
                    int opcion = scanner.nextInt();
                    
                    if (opcion == 0) {
                        System.out.println("\nSaliendo...");
                        break;
                    } else if (opcion == 1) {
                        NinjaView.initApp();
                        scanner.nextLine();
                    }   else if (opcion == 2) {
                        HabilidadView.initApp();
                    } else if (opcion == 3) {
                        MisionView.initApp();
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
}
