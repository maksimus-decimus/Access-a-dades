package fernandez.max.dam.mp09.uf01.pr2.seguretat.model.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VisitaMedicaRepository {
    
    private static final String FILE_PATH = "visites_mediques.json";
    private Gson gson;
    
    public VisitaMedicaRepository() {
        // Configurar Gson amb adaptador per LocalDate
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, 
                    (JsonSerializer<LocalDate>) (src, typeOfSrc, context) -> 
                        context.serialize(src.format(DateTimeFormatter.ISO_LOCAL_DATE)))
                .registerTypeAdapter(LocalDate.class,
                    (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                        LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE))
                .setPrettyPrinting()
                .create();
    }
    
    /**
     * Guarda una llista de visites mèdiques encriptades al fitxer JSON
     */
    public void guardarVisites(List<VisitaMedicaLog> visites) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(visites, writer);
            System.out.println("Visites guardades correctament al fitxer: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error en guardar les visites: " + e.getMessage());
        }
    }
    
    /**
     * Carrega la llista de visites mèdiques encriptades del fitxer JSON
     */
    public List<VisitaMedicaLog> carregarVisites() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("El fitxer no existeix. Es retornarà una llista buida.");
            return new ArrayList<>();
        }
        
        try (FileReader reader = new FileReader(FILE_PATH)) {
            VisitaMedicaLog[] visites = gson.fromJson(reader, VisitaMedicaLog[].class);
            if (visites == null) {
                return new ArrayList<>();
            }
            List<VisitaMedicaLog> llista = new ArrayList<>();
            for (VisitaMedicaLog visita : visites) {
                llista.add(visita);
            }
            System.out.println("Visites carregades correctament des del fitxer: " + FILE_PATH);
            return llista;
        } catch (IOException e) {
            System.err.println("Error en carregar les visites: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Afegeix una nova visita al fitxer JSON
     */
    public void afegirVisita(VisitaMedicaLog visita) {
        List<VisitaMedicaLog> visites = carregarVisites();
        visites.add(visita);
        guardarVisites(visites);
    }
}
