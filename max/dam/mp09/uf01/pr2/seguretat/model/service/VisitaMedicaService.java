package fernandez.max.dam.mp09.uf01.pr2.seguretat.model.service;

import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

public class VisitaMedicaService {
    
    /**
     * Valida que totes les dades de la visita mèdica estiguin informades
     */
    public static boolean validarVisitaMedica(VisitaMedica visita) {
        if (visita == null) {
            System.out.println("Error: La visita mèdica no pot ser nul·la");
            return false;
        }
        
        if (visita.getIdVisita() <= 0) {
            System.out.println("Error: L'ID de la visita ha de ser major que 0");
            return false;
        }
        
        if (visita.getNomPacient() == null || visita.getNomPacient().trim().isEmpty()) {
            System.out.println("Error: El nom del pacient és obligatori");
            return false;
        }
        
        if (visita.getNomMetge() == null || visita.getNomMetge().trim().isEmpty()) {
            System.out.println("Error: El nom del metge és obligatori");
            return false;
        }
        
        if (visita.getData() == null) {
            System.out.println("Error: La data de la visita és obligatòria");
            return false;
        }
        
        if (visita.getDiagnostic() == null || visita.getDiagnostic().trim().isEmpty()) {
            System.out.println("Error: El diagnòstic és obligatori");
            return false;
        }
        
        return true;
    }
    
    /**
     * Encripta les dades sensibles de la visita mèdica
     */
    public static VisitaMedicaLog encriptarVisitaMedica(VisitaMedica visita) {
        if (!validarVisitaMedica(visita)) {
            throw new IllegalArgumentException("La visita mèdica no és vàlida");
        }
        
        VisitaMedicaLog log = new VisitaMedicaLog(visita);
        
        // Encriptar nomPacient amb MD5, SHA256 i AES
        log.setNomPacientMD5(MD5Encryptor.encrypt(visita.getNomPacient()));
        log.setNomPacientSHA256(SHA256Encryptor.encrypt(visita.getNomPacient()));
        log.setNomPacientAES(AESEncryptor.encrypt(visita.getNomPacient()));
        
        // Encriptar diagnostic amb MD5, SHA256 i AES
        log.setDiagnosticMD5(MD5Encryptor.encrypt(visita.getDiagnostic()));
        log.setDiagnosticSHA256(SHA256Encryptor.encrypt(visita.getDiagnostic()));
        log.setDiagnosticAES(AESEncryptor.encrypt(visita.getDiagnostic()));
        
        return log;
    }
    
    /**
     * Desencripta les dades AES de la visita mèdica
     */
    public static void desencriptarVisitaMedicaLog(VisitaMedicaLog log) {
        System.out.println("\n=== Desencriptació AES ===");
        System.out.println("Nom Pacient desencriptat: " + AESEncryptor.decrypt(log.getNomPacientAES()));
        System.out.println("Diagnòstic desencriptat: " + AESEncryptor.decrypt(log.getDiagnosticAES()));
    }
}
