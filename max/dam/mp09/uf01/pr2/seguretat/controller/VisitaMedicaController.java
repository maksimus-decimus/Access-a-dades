package fernandez.max.dam.mp09.uf01.pr2.seguretat.controller;

import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;
import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.repository.VisitaMedicaRepository;
import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.service.VisitaMedicaService;
import fernandez.max.dam.mp09.uf01.pr2.seguretat.view.console.ConsoleView;

import java.util.List;

public class VisitaMedicaController {
    
    private ConsoleView view;
    private VisitaMedicaRepository repository;
    
    public VisitaMedicaController() {
        this.view = new ConsoleView();
        this.repository = new VisitaMedicaRepository();
    }
    
    public void iniciar() {
        boolean sortir = false;
        
        while (!sortir) {
            view.mostrarMenu();
            int opcio = view.llegirOpcio();
            
            switch (opcio) {
                case 1:
                    crearNovaVisita();
                    break;
                case 2:
                    mostrarVisites();
                    break;
                case 3:
                    desencriptarVisita();
                    break;
                case 4:
                    sortir = true;
                    view.mostrarMissatge("\nGràcies per utilitzar el sistema. Adéu!");
                    break;
                default:
                    view.mostrarError("Opció no vàlida. Torna-ho a intentar.");
            }
        }
        
        view.tancar();
    }
    
    private void crearNovaVisita() {
        try {
            VisitaMedica visita = view.introduirVisitaMedica();
            
            if (VisitaMedicaService.validarVisitaMedica(visita)) {
                VisitaMedicaLog log = VisitaMedicaService.encriptarVisitaMedica(visita);
                repository.afegirVisita(log);
                
                view.mostrarMissatge("\n✓ Visita mèdica creada i encriptada correctament!");
                view.mostrarVisitaLog(log);
            } else {
                view.mostrarError("La visita no és vàlida. No s'ha guardat.");
            }
        } catch (Exception e) {
            view.mostrarError("Error en crear la visita: " + e.getMessage());
        }
    }
    
    private void mostrarVisites() {
        try {
            List<VisitaMedicaLog> visites = repository.carregarVisites();
            
            if (visites.isEmpty()) {
                view.mostrarMissatge("\nNo hi ha visites mèdiques guardades.");
                return;
            }
            
            view.mostrarMissatge("\n=== LLISTA DE VISITES MÈDIQUES ENCRIPTADES ===");
            for (int i = 0; i < visites.size(); i++) {
                view.mostrarMissatge("\n--- Visita #" + (i + 1) + " ---");
                view.mostrarVisitaLog(visites.get(i));
            }
        } catch (Exception e) {
            view.mostrarError("Error en mostrar les visites: " + e.getMessage());
        }
    }
    
    private void desencriptarVisita() {
        try {
            List<VisitaMedicaLog> visites = repository.carregarVisites();
            
            if (visites.isEmpty()) {
                view.mostrarMissatge("\nNo hi ha visites mèdiques guardades.");
                return;
            }
            
            view.mostrarMissatge("\nHi ha " + visites.size() + " visites disponibles.");
            int seleccio = view.seleccionarVisita(visites.size());
            
            if (seleccio < 1 || seleccio > visites.size()) {
                view.mostrarError("Selecció no vàlida.");
                return;
            }
            
            VisitaMedicaLog log = visites.get(seleccio - 1);
            view.mostrarMissatge("\n=== Informació de la visita #" + seleccio + " ===");
            view.mostrarMissatge("ID Visita: " + log.getIdVisita());
            view.mostrarMissatge("Nom Metge: " + log.getNomMetge());
            view.mostrarMissatge("Data: " + log.getData());
            
            VisitaMedicaService.desencriptarVisitaMedicaLog(log);
        } catch (Exception e) {
            view.mostrarError("Error en desencriptar la visita: " + e.getMessage());
        }
    }
}
