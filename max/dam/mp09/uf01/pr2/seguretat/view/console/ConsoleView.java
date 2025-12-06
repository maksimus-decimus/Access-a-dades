package fernandez.max.dam.mp09.uf01.pr2.seguretat.view.console;

import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleView {
    
    private Scanner scanner;
    
    public ConsoleView() {
        scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓ DE VISITES MÈDIQUES ===");
        System.out.println("1. Crear nova visita mèdica");
        System.out.println("2. Mostrar totes les visites encriptades");
        System.out.println("3. Desencriptar una visita (AES)");
        System.out.println("4. Sortir");
        System.out.print("Selecciona una opció: ");
    }
    
    public int llegirOpcio() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public VisitaMedica introduirVisitaMedica() {
        System.out.println("\n=== NOVA VISITA MÈDICA ===");
        
        System.out.print("ID de la visita: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no vàlid. S'assignarà 0.");
        }
        
        System.out.print("Nom del pacient: ");
        String nomPacient = scanner.nextLine();
        
        System.out.print("Nom del metge: ");
        String nomMetge = scanner.nextLine();
        
        System.out.print("Data de la visita (dd/MM/yyyy): ");
        LocalDate data = null;
        try {
            String dataStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data no vàlida. S'utilitzarà la data d'avui.");
            data = LocalDate.now();
        }
        
        System.out.print("Diagnòstic: ");
        String diagnostic = scanner.nextLine();
        
        return new VisitaMedica(id, nomPacient, nomMetge, data, diagnostic);
    }
    
    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }
    
    public void mostrarError(String error) {
        System.err.println("ERROR: " + error);
    }
    
    public void mostrarVisitaLog(fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog log) {
        System.out.println("\n=== VISITA MÈDICA ENCRIPTADA ===");
        System.out.println("ID Visita: " + log.getIdVisita());
        System.out.println("Nom Pacient (original): " + log.getNomPacient());
        System.out.println("Nom Metge: " + log.getNomMetge());
        System.out.println("Data: " + log.getData());
        System.out.println("Diagnòstic (original): " + log.getDiagnostic());
        System.out.println("\n--- Encriptacions ---");
        System.out.println("Nom Pacient MD5: " + log.getNomPacientMD5());
        System.out.println("Nom Pacient SHA256: " + log.getNomPacientSHA256());
        System.out.println("Nom Pacient AES: " + log.getNomPacientAES());
        System.out.println("Diagnòstic MD5: " + log.getDiagnosticMD5());
        System.out.println("Diagnòstic SHA256: " + log.getDiagnosticSHA256());
        System.out.println("Diagnòstic AES: " + log.getDiagnosticAES());
    }
    
    public int seleccionarVisita(int maxVisites) {
        System.out.print("\nIntrodueix el número de visita a desencriptar (1-" + maxVisites + "): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public void tancar() {
        scanner.close();
    }
}
