package fernandez.max.dam.mp09.uf01.pr2.seguretat.model.domain;

import java.time.LocalDate;

public class VisitaMedicaLog {
    private int idVisita;
    private String nomPacient;
    private String nomMetge;
    private LocalDate data;
    private String diagnostic;
    private String nomPacientMD5;
    private String nomPacientSHA256;
    private String diagnosticMD5;
    private String diagnosticSHA256;
    private String nomPacientAES;
    private String diagnosticAES;

    // Constructor buit
    public VisitaMedicaLog() {
    }

    // Constructor amb VisitaMedica
    public VisitaMedicaLog(VisitaMedica visitaMedica) {
        this.idVisita = visitaMedica.getIdVisita();
        this.nomPacient = visitaMedica.getNomPacient();
        this.nomMetge = visitaMedica.getNomMetge();
        this.data = visitaMedica.getData();
        this.diagnostic = visitaMedica.getDiagnostic();
    }

    // Getters i Setters
    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public String getNomPacient() {
        return nomPacient;
    }

    public void setNomPacient(String nomPacient) {
        this.nomPacient = nomPacient;
    }

    public String getNomMetge() {
        return nomMetge;
    }

    public void setNomMetge(String nomMetge) {
        this.nomMetge = nomMetge;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getNomPacientMD5() {
        return nomPacientMD5;
    }

    public void setNomPacientMD5(String nomPacientMD5) {
        this.nomPacientMD5 = nomPacientMD5;
    }

    public String getNomPacientSHA256() {
        return nomPacientSHA256;
    }

    public void setNomPacientSHA256(String nomPacientSHA256) {
        this.nomPacientSHA256 = nomPacientSHA256;
    }

    public String getDiagnosticMD5() {
        return diagnosticMD5;
    }

    public void setDiagnosticMD5(String diagnosticMD5) {
        this.diagnosticMD5 = diagnosticMD5;
    }

    public String getDiagnosticSHA256() {
        return diagnosticSHA256;
    }

    public void setDiagnosticSHA256(String diagnosticSHA256) {
        this.diagnosticSHA256 = diagnosticSHA256;
    }

    public String getNomPacientAES() {
        return nomPacientAES;
    }

    public void setNomPacientAES(String nomPacientAES) {
        this.nomPacientAES = nomPacientAES;
    }

    public String getDiagnosticAES() {
        return diagnosticAES;
    }

    public void setDiagnosticAES(String diagnosticAES) {
        this.diagnosticAES = diagnosticAES;
    }

    @Override
    public String toString() {
        return "VisitaMedicaLog{" +
                "idVisita=" + idVisita +
                ", nomPacient='" + nomPacient + '\'' +
                ", nomMetge='" + nomMetge + '\'' +
                ", data=" + data +
                ", diagnostic='" + diagnostic + '\'' +
                ", nomPacientMD5='" + nomPacientMD5 + '\'' +
                ", nomPacientSHA256='" + nomPacientSHA256 + '\'' +
                ", diagnosticMD5='" + diagnosticMD5 + '\'' +
                ", diagnosticSHA256='" + diagnosticSHA256 + '\'' +
                ", nomPacientAES='" + nomPacientAES + '\'' +
                ", diagnosticAES='" + diagnosticAES + '\'' +
                '}';
    }
}
