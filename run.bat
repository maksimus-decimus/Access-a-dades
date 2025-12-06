@echo off
REM Script per compilar i executar el projecte sense Maven

echo ==========================================
echo COMPILACIO I EXECUCIO DEL PROJECTE
echo ==========================================
echo.

REM Crear directori per classes compilades
if not exist "bin" mkdir bin

REM Verificar si existeix Gson
if not exist "gson-2.10.1.jar" (
    echo ERROR: No s'ha trobat gson-2.10.1.jar
    echo.
    echo Descarrega Gson des de:
    echo https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
    echo.
    echo Col·loca el fitxer gson-2.10.1.jar a la mateixa carpeta que aquest script.
    pause
    exit /b 1
)

echo [1/2] Compilant el projecte...
javac -encoding UTF-8 -cp gson-2.10.1.jar -d bin max/dam/mp09/uf01/pr2/seguretat/model/domain/*.java max/dam/mp09/uf01/pr2/seguretat/model/service/*.java max/dam/mp09/uf01/pr2/seguretat/model/repository/*.java max/dam/mp09/uf01/pr2/seguretat/controller/*.java max/dam/mp09/uf01/pr2/seguretat/view/console/*.java max/dam/mp09/uf01/pr2/app/*.java

if %errorlevel% neq 0 (
    echo.
    echo ERROR: La compilacio ha fallat!
    pause
    exit /b %errorlevel%
)

echo [2/2] Executant l'aplicacio...
echo.
java -cp "bin;gson-2.10.1.jar" fernandez.max.dam.mp09.uf01.pr2.app.Main

pause
