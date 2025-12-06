# Instruccions per instal·lar i configurar el projecte

## Opció 1: Utilitzar Maven (Recomanat)

Si tens Maven instal·lat, és la forma més senzilla:

### Pas 1: Verificar Maven
```bash
mvn --version
```

### Pas 2: Compilar el projecte
```bash
cd fernandez
mvn clean compile
```

### Pas 3: Executar l'aplicació
```bash
mvn exec:java
```

### Pas 4: Crear JAR executable (opcional)
```bash
mvn package
java -jar target/seguretat-encriptacio-1.0.0-jar-with-dependencies.jar
```

---

## Opció 2: Compilació manual amb javac

### Pas 1: Descarregar Gson

Descarrega la llibreria Gson des de Maven Central:
- URL: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
- Guarda'l a la carpeta `fernandez/` (on està el README.md)

### Pas 2: Compilar amb el script (Windows)

Executa el fitxer `compile.bat`:
```bash
compile.bat
```

### Pas 3: Executar amb el script (Windows)

Executa el fitxer `run.bat`:
```bash
run.bat
```

### Compilació i execució manual (Windows)

Si prefereixes fer-ho manualment:

```bash
# Crear directori per classes compilades
mkdir bin

# Compilar el projecte
javac -encoding UTF-8 -cp gson-2.10.1.jar -d bin max/dam/mp09/uf01/pr2/seguretat/model/domain/*.java max/dam/mp09/uf01/pr2/seguretat/model/service/*.java max/dam/mp09/uf01/pr2/seguretat/model/repository/*.java max/dam/mp09/uf01/pr2/seguretat/controller/*.java max/dam/mp09/uf01/pr2/seguretat/view/console/*.java max/dam/mp09/uf01/pr2/app/*.java

# Executar l'aplicació
java -cp "bin;gson-2.10.1.jar" fernandez.max.dam.mp09.uf01.pr2.app.Main
```

### Compilació i execució manual (Linux/macOS)

```bash
# Crear directori per classes compilades
mkdir -p bin

# Compilar el projecte
javac -encoding UTF-8 -cp gson-2.10.1.jar -d bin max/dam/mp09/uf01/pr2/seguretat/model/domain/*.java max/dam/mp09/uf01/pr2/seguretat/model/service/*.java max/dam/mp09/uf01/pr2/seguretat/model/repository/*.java max/dam/mp09/uf01/pr2/seguretat/controller/*.java max/dam/mp09/uf01/pr2/seguretat/view/console/*.java max/dam/mp09/uf01/pr2/app/*.java

# Executar l'aplicació
java -cp "bin:gson-2.10.1.jar" fernandez.max.dam.mp09.uf01.pr2.app.Main
```

---

## Opció 3: Utilitzar un IDE

### IntelliJ IDEA

1. Obrir IntelliJ IDEA
2. File → Open → Seleccionar la carpeta `fernandez/`
3. IntelliJ detectarà automàticament el `pom.xml` i descarregarà les dependències
4. Executar la classe `Main.java`

### Eclipse

1. Obrir Eclipse
2. File → Import → Existing Maven Projects
3. Seleccionar la carpeta `fernandez/`
4. Eclipse descarregarà les dependències automàticament
5. Run → Run As → Java Application → Seleccionar `Main`

### Visual Studio Code

1. Obrir VS Code
2. Instal·lar extensions:
   - Extension Pack for Java (Microsoft)
   - Maven for Java
3. Obrir la carpeta `fernandez/`
4. VS Code detectarà el projecte Maven
5. Executar la classe `Main.java`

---

## Verificació

Després d'executar l'aplicació, hauries de veure:

```
=== SISTEMA DE GESTIÓ DE VISITES MÈDIQUES AMB ENCRIPTACIÓ ===
Autor: Max Fernandez
DAM - MP09 - UF01 - PR2 - Seguretat

=== SISTEMA DE GESTIÓ DE VISITES MÈDIQUES ===
1. Crear nova visita mèdica
2. Mostrar totes les visites encriptades
3. Desencriptar una visita (AES)
4. Sortir
Selecciona una opció:
```

---

## Solució de problemes

### Error: "gson-2.10.1.jar no trobat"
- Assegura't d'haver descarregat el fitxer Gson
- Col·loca'l a la carpeta `fernandez/`

### Error: "No s'ha pogut trobar o carregar la classe principal"
- Verifica que has compilat correctament les classes
- Comprova que el classpath inclou tant `bin` com `gson-2.10.1.jar`

### Error de codificació de caràcters
- Utilitza `-encoding UTF-8` en compilar
- Assegura't que els fitxers .java estan guardats amb codificació UTF-8

---

## Requisits del sistema

- **Java JDK 8** o superior
- **Maven 3.6** o superior (opcional, per la opció 1)
- **Sistema operatiu**: Windows, Linux o macOS

---

## Contacte

Per qualsevol dubte o problema amb la instal·lació:
- **Autor**: Max Fernandez
- **Projecte**: DAM-2 - MP09 - UF01 - PR2
