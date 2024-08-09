
ObjectDB ist eine Java-basierte, leichtgewichtige Objektdatenbank, die speziell für Anwendungen entwickelt wurde, die das Java-Persistence-API (JPA) verwenden. Es ist eine gute Wahl, wenn du eine objektorientierte Datenbank in einer Java-Anwendung nutzen möchtest. Hier ist eine grundlegende Anleitung, wie du ObjectDB in einem Java-Projekt einrichten und nutzen kannst.

### 1. Installation von ObjectDB

Zunächst musst du ObjectDB herunterladen und in dein Projekt integrieren:

1. **Download**: Lade die ObjectDB-Bibliothek von der [offiziellen Website](https://www.objectdb.com/download) herunter.
2. **Hinzufügen zu deinem Projekt**: Füge die heruntergeladene `objectdb.jar`-Datei zu deinem Projekt hinzu. Wenn du eine IDE wie IntelliJ IDEA oder Eclipse verwendest, kannst du dies über die Projekteinstellungen tun.

### 2. Einrichtung eines Java-Projekts mit ObjectDB

Hier ist ein einfaches Beispiel, wie du ObjectDB in einem Java-Projekt nutzen kannst.

#### 2.1. Projektstruktur

Erstelle ein neues Java-Projekt mit einer Struktur, die in etwa so aussieht:

```
MyObjectDBProject/
│
├── src/
│   ├── META-INF/
│   │   └── persistence.xml
│   ├── model/
│   │   └── Book.java
│   └── Main.java
├── lib/
│   └── objectdb.jar
	└── explorer.jar
└── ...
```

#### 2.2. `persistence.xml` erstellen

In `META-INF/` erstellst du die `persistence.xml`, um die Datenbankverbindung zu konfigurieren:

```xml
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
                                 http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">
    <persistence-unit name="myObjectDB">
        <provider>com.objectdb.jpa.Provider</provider>
        <class>model.Book</class>
        <properties>
            <property name="javax.persistence.jdbc.url" value="objectdb://localhost:6136/mydb.odb"/>
        </properties>
    </persistence-unit>
</persistence>
```

#### 2.3. Erstellen der Entitätsklasse

In `model/` erstellst du eine einfache Java-Klasse, die eine Entität in der Datenbank repräsentiert:

#### 2.4. Hauptprogramm erstellen

Erstelle die `Main.java`, um eine einfache CRUD-Operation (Create, Read, Update, Delete) durchzuführen:


### 3. Ausführen des Projekts

 Führe das `Main`-Programm aus. Es wird ein neues Buch in der ObjectDB-Datenbank erstellen, die Daten abrufen, aktualisieren und dann löschen.

### 4. ObjectDB-Datenbankdatei

Nach dem Ausführen des Programms wird eine Datenbankdatei (z.B. `mydb.odb`) im Projektverzeichnis erstellt. Du kannst diese Datei mit dem ObjectDB Explorer (enthalten im ObjectDB-Download) öffnen, um den Inhalt der Datenbank zu visualisieren.