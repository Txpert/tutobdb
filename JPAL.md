
Java Persistence Query Language (JPQL) ist eine Abfragesprache, die in der Java Persistence API (JPA) verwendet wird, um Abfragen gegen Datenbanken zu erstellen. JPQL ähnelt SQL (Structured Query Language), arbeitet jedoch mit Entitäten und deren Eigenschaften statt mit direkten Datenbanktabellen.

### Grundlagen von JPQL

JPQL ist stark typisiert und objektorientiert. Im Gegensatz zu SQL, das direkt auf Tabellen und Spalten zugreift, arbeitet JPQL mit den Entitätsklassen und ihren Attributen.

#### 1. **Grundlegende Struktur einer JPQL-Abfrage**

Die grundlegende Struktur einer JPQL-Abfrage besteht aus drei Teilen:

- **`SELECT`**: Wählt bestimmte Daten aus den Entitäten aus.
- **`FROM`**: Gibt die Entitätsklasse an, aus der die Daten stammen.
- **`WHERE`**: (optional) Filtert die Daten basierend auf bestimmten Kriterien.

Beispiel:
```java
SELECT e FROM Employee e WHERE e.salary > 50000
```
Dieser Befehl ruft alle `Employee`-Entitäten ab, deren `salary` größer als 50.000 ist.

#### 2. **Alias-Namen**

JPQL-Abfragen verwenden oft Aliase, um die Lesbarkeit zu verbessern. Ein Alias wird verwendet, um eine Entität zu referenzieren, und wird direkt nach der Entitätsklasse im `FROM`-Teil definiert:

```java
SELECT e FROM Employee e
```
Hier ist `e` der Alias für die `Employee`-Entität. Du kannst diesen Alias verwenden, um auf die Felder der Entität zuzugreifen.

#### 3. **Filterung mit `WHERE`**

Der `WHERE`-Klausel wird verwendet, um die Ergebnisse basierend auf bestimmten Bedingungen zu filtern:

```java
SELECT e FROM Employee e WHERE e.department = 'IT'
```
Diese Abfrage ruft alle Mitarbeiter ab, die in der IT-Abteilung arbeiten.

#### 4. **Sortieren mit `ORDER BY`**

Mit `ORDER BY` kannst du die Ergebnisse nach einem bestimmten Attribut sortieren:

```java
SELECT e FROM Employee e WHERE e.salary > 50000 ORDER BY e.salary DESC
```
Diese Abfrage sortiert die Ergebnisse nach dem Gehalt in absteigender Reihenfolge.

#### 5. **Aggregation mit `COUNT`, `SUM`, `AVG`, `MAX`, `MIN`**

JPQL unterstützt Aggregationsfunktionen wie `COUNT`, `SUM`, `AVG`, `MAX`, `MIN`, ähnlich wie SQL:

```java
SELECT COUNT(e) FROM Employee e WHERE e.department = 'IT'
```
Diese Abfrage zählt die Anzahl der Mitarbeiter in der IT-Abteilung.

#### 6. **Joins**

JPQL unterstützt auch Joins, um Daten aus mehreren Entitäten zu kombinieren. Ein Join wird verwendet, wenn eine Entität eine Beziehung zu einer anderen Entität hat (z.B. `@OneToMany`, `@ManyToOne`):

- **Inner Join**: Verwendet `JOIN` oder `INNER JOIN`:
  ```java
  SELECT e FROM Employee e JOIN e.department d WHERE d.name = 'IT'
  ```
  Diese Abfrage ruft alle Mitarbeiter ab, die in der IT-Abteilung arbeiten.

- **Left Join**: Verwendet `LEFT JOIN`:
  ```java
  SELECT e FROM Employee e LEFT JOIN e.department d WHERE d.name = 'IT'
  ```

- **Fetch Join**: Wird verwendet, um verbundene Entitäten in einer Abfrage mit abzurufen:
  ```java
  SELECT e FROM Employee e JOIN FETCH e.department
  ```
  Diese Abfrage holt die `Employee`-Entität zusammen mit ihrer `Department`-Entität.

#### 7. **Parameter in JPQL**

Du kannst Parameter in JPQL verwenden, um dynamische Abfragen zu erstellen. Es gibt zwei Arten von Parametern:

- **Positionsparameter** (`?1`, `?2`, ...):
  ```java
  SELECT e FROM Employee e WHERE e.salary > ?1
  ```
  Diese Abfrage filtert Mitarbeiter basierend auf einem übergebenen Gehaltswert.

- **Benannte Parameter** (`:name`):
  ```java
  SELECT e FROM Employee e WHERE e.name = :name
  ```
  Diese Abfrage filtert Mitarbeiter basierend auf einem übergebenen Namen.

#### 8. **Beispiel einer komplexeren JPQL-Abfrage**

Angenommen, du möchtest alle Mitarbeiter abrufen, die in der IT-Abteilung arbeiten und ein Gehalt über 50.000 haben, sortiert nach Gehalt in absteigender Reihenfolge:

```java
SELECT e FROM Employee e 
JOIN e.department d 
WHERE d.name = 'IT' AND e.salary > 50000 
ORDER BY e.salary DESC
```

### Übungsaufgaben

1. **Einfacher SELECT**: Schreibe eine JPQL-Abfrage, um alle Produkte in einer `Product`-Entität abzurufen, deren Preis größer als 100 ist.
2. **Aggregation**: Schreibe eine JPQL-Abfrage, die den durchschnittlichen Preis aller Produkte berechnet.
3. **Join**: Schreibe eine JPQL-Abfrage, um alle Bestellungen (`Order`-Entität) abzurufen, zusammen mit den entsprechenden Kunden (`Customer`-Entität), die nach dem Bestelldatum sortiert sind.

JPQL ist ein mächtiges Werkzeug, das es ermöglicht, auf eine relationale Datenbank in einer objektorientierten Weise zuzugreifen. Indem du die Grundlagen von JPQL beherrschst, kannst du komplexe Abfragen erstellen und Daten effizient verwalten.