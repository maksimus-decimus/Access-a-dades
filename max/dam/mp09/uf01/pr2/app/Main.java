package fernandez.max.dam.mp09.uf01.pr2.app;

import fernandez.max.dam.mp09.uf01.pr2.seguretat.controller.VisitaMedicaController;

/**
 * Classe principal de l'aplicació de gestió de visites mèdiques amb encriptació
 * 
 * Aquest projecte implementa:
 * - Encriptació MD5 i SHA256 (hash unidireccional)
 * - Encriptació/Desencriptació AES (xifrat reversible)
 * - Persistència de dades en format JSON
 * - Validació de dades
 * - Patró MVC
 * 
 * @author Max Fernandez
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓ DE VISITES MÈDIQUES AMB ENCRIPTACIÓ ===");
        System.out.println("Autor: Max Fernandez");
        System.out.println("DAM - MP09 - UF01 - PR2 - Seguretat\n");
        
        VisitaMedicaController controller = new VisitaMedicaController();
        controller.iniciar();
    }
}
