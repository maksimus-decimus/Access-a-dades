
## Resum de l'activitat

### 1. Classes del domini (Model)
- **VisitaMedica.java**: Entitat amb les dades de la visita (idVisita, nomPacient, nomMetge, data, diagnòstic)
- **VisitaMedicaLog.java**: Entitat amb les dades originals + dades encriptades

### 2. Classes de servei (Service)
- **MD5Encryptor.java**: Encriptació amb algoritme MD5 (hash unidireccional)
- **SHA256Encryptor.java**: Encriptació amb algoritme SHA-256 (hash unidireccional)
- **AESEncryptor.java**: Encriptació/desencriptació amb algoritme AES (reversible)
- **VisitaMedicaService.java**: Validació de dades i gestió d'encriptacions

### 3. Repositori (Persistència)
- **VisitaMedicaRepository.java**: Gestió de persistència en format JSON amb Gson

### 4. Controlador (Controller)
- **VisitaMedicaController.java**: Gestiona el flux de l'aplicació i coordina Vista-Model

### 5. Vista (View)
- **ConsoleView.java**: Interfície d'usuari per consola

### 6. Aplicació principal
- **Main.java**: Punt d'entrada de l'aplicació

### 7. Fitxers de configuració
- **pom.xml**: Configuració Maven amb dependència Gson

- **compile.bat**: Script per compilar en Windows (si no funciona maven)
- **run.bat**: Script per compilar i executar en Windows (si no funciona maven)


## Com executar el projecte
Maven:
```bash
cd fernandez
mvn clean compile
mvn exec:java
```

Windows:
```bash
cd fernandez
run.bat
```

## Notes importants

1. Les dades encriptades es guarden a `visites_mediques.json`
2. MD5 i SHA256 són hash unidireccionals (no es poden desencriptar)
3. AES permet encriptar i desencriptar dades
4. Totes les dades són validades abans de processar-se


**DAM-2 - MP09 - UF01 - PR2 - Seguretat i Encriptació**
