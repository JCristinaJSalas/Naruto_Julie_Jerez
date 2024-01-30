/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.MisionNinja.view;

import com.mycompany.narutojava.julie.MisionNinja.Controller.MisionNinjaController;
import com.mycompany.narutojava.julie.MisionNinja.model.classes.MisionNinja;
import com.mycompany.narutojava.julie.habilidad.controller.HabilidadController;
import com.mycompany.narutojava.julie.mision.controller.MisionController;
import com.mycompany.narutojava.julie.mision.model.classes.Mision;
import com.mycompany.narutojava.julie.ninja.controller.NinjaController;
import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class MisionNinjaView {

    public static void initApp() {
        Scanner scanner = new Scanner(System.in);
        HabilidadController habilidadController = new HabilidadController();
        NinjaController ninjaController = new NinjaController();
        MisionController misionController = new MisionController();
        MisionNinjaController misionNinjaController = new MisionNinjaController();
        while (true) {
            try {
                System.out.println("""
                                                
                        ------- Gestion de misiones -------
                                                
                        1. Asignar Mision
                        0. << Volver
                        """);
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("\nVolviendo...");
                    break;
                } else if (opcion == 1) {
                    System.out.println("Elije un ninja: ");
                    List<Ninja> listNinja = ninjaController.getAllNinjas();
                    for (Ninja n : listNinja) {
                        System.out.println("Ninja: " + n.getNinjaID() + " " + n.getNombre() + " " + n.getRango());
                    }
                    int idNinja = scanner.nextInt();
                    System.out.println("Elije un mision: ");
                    List<Mision> listMision = misionController.getAllMision();
                    for (Mision m : listMision) {
                        System.out.println("Mision: " + m.getMisionId() + " " + m.getDescripcion() + " " + m.getRango());
                    }
                    int idMision = scanner.nextInt();
                    System.out.println("Fecha de Inicio: ");
                    String fechaInicio = scanner.next();
                    Mision mision2 = misionController.getByIdMision(idMision);
                    int tiempo = mision2.getTiempo();
                    
                    System.out.println("tiempo de mision: " + tiempo);
                    
                    
                    MisionNinja misionNinja = new MisionNinja(idMision, idNinja,LocalDate.parse(fechaInicio), null);
                    misionNinjaController.insertMisionNinja(misionNinja);
                    System.out.println("Mision Creada.");
                    
                    Thread thread = new Thread(() -> {
                         System.out.println("Mision en ejecucion");
                        try {
                            Thread.sleep(tiempo * 10000);
                            
                            List<MisionNinja> listMisionNinja = misionNinjaController.getAllMisionNinja().stream().filter(mision -> mision.getMisionID() == idMision).toList();
                            listMisionNinja.forEach(mision -> {
                                mision.setFechaFin(LocalDate.now());
                                misionNinjaController.updateMV(mision);
                            });
                            
                                                System.out.println("Mision Terminada.");

                            
                                
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    thread.start();
                    
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
