DROP DATABASE naruto_Julie_Jerez;
CREATE DATABASE naruto_Julie_Jerez;
use naruto_Julie_Jerez;
CREATE TABLE Ninja (
    NinjaID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Rango VARCHAR(100),
    Aldea VARCHAR(100)
);

CREATE TABLE Mision (
    MisionID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(100),
    Rango VARCHAR(100),
    Recompensa VARCHAR(50),
    Tiempo INT
);
CREATE TABLE MisionNinja (
    NinjaID INT not NULL,
    MisionID INT not null,
    FechaInicio DATE,
    FechaFin DATE,
    PRIMARY KEY (NinjaID, MisionID),
    FOREIGN KEY (NinjaID) REFERENCES Ninja(NinjaID),
    Foreign Key (MisionID) REFERENCES Mision(MisionID)
);

CREATE TABLE Habilidad (
    HabilidadID INT PRIMARY KEY AUTO_INCREMENT,
    NinjaID INT,
    Nombre VARCHAR(100),
    Descripcion VARCHAR(100),
    FOREIGN KEY (NinjaID) REFERENCES Ninja(NinjaID)
);

INSERT INTO Ninja (NinjaID, Nombre, Rango, Aldea) VALUES (1, 'JuanMarino', 'KAGE', 'Aldea del Viento');
INSERT INTO Ninja (NinjaID, Nombre, Rango, Aldea) VALUES (2, 'Jaider', 'SASAU', 'Aldea Arena');
INSERT INTO Ninja (NinjaID, Nombre, Rango, Aldea) VALUES (3, 'Cristina', 'SASAU', 'Aldea de la Hoja');
INSERT INTO Ninja (NinjaID, Nombre, Rango, Aldea) VALUES (4, 'Naruto', 'JOUNIN', 'Aldea Fuego');
INSERT INTO Ninja (NinjaID, Nombre, Rango, Aldea) VALUES (5, 'Killua', 'GENNIN', 'Aldea Tierra');

INSERT INTO Mision (MisionID, Descripcion, Rango, Recompensa,Tiempo) VALUES (1, 'Transportar Empresario', 'Rango C', 'Y - 45.000',1);
INSERT INTO Mision (MisionID, Descripcion, Rango, Recompensa,Tiempo) VALUES (2, 'Transportar Ninos', 'Rango D', 'Y - 5.000',2);
INSERT INTO Mision (MisionID, Descripcion, Rango, Recompensa,Tiempo) VALUES (3, 'Escoltar Persona', 'Rango B', 'Y - 405.000',5);
INSERT INTO Mision (MisionID, Descripcion, Rango, Recompensa,Tiempo) VALUES (4, 'Cortar Cesped', 'Rango D', 'Y - 1.000',4);

INSERT INTO Habilidad (HabilidadID, NinjaID, Nombre, Descripcion) VALUES (1,2, 'Control Arena', 'Compacta arena');
INSERT INTO Habilidad (HabilidadID, NinjaID, Nombre, Descripcion) VALUES (2,1, 'Volar', 'Vuela por 30 min');
INSERT INTO Habilidad (HabilidadID, NinjaID, Nombre, Descripcion) VALUES (3,3, 'control aire', 'Crea rafagas');

INSERT INTO Habilidad (HabilidadID, NinjaID, Nombre, Descripcion) VALUES (4,4, 'LanzaLllamas', 'Laza bolas de fuego');
INSERT INTO Habilidad (HabilidadID, NinjaID, Nombre, Descripcion) VALUES (5,5, 'Barrera de Tierra', 'Crea una barrera protectora de tierra');


INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (1,1,"2024-01-29",null);
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (2,1,"2024-01-29",null);
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (3,2,"2024-01-30",null);
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (4,2,"2024-01-30",null);

INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (3,3,null,null);
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (4,3,null,null);
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (2,3,null,null);
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (5,3,null,null);


INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (4,4,"2024-01-29","2024-01-29");
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (5,4,"2024-01-29","2024-01-29");



--NINJAS CON SUS HABILIDADDES
Select n.*, h.Nombre as Habilidad from Ninja n 
Inner join Habilidad h on n.NinjaID = h.NinjaID;


-- mISIONES DISPONIBLES
select n.Nombre, mi.Descripcion from MisionNinja mn
INNER JOIN Ninja n On mn.NinjaID = n.NinjaID
inner Join Mision mi on mn.MisionID = mi.MisionID
where mn.FechaInicio IS NULL 
AND mn.FechaFin IS NULL
AND n.NinjaID = 2;


-- Mostrar misiones completadas
select n.Nombre, mi.Descripcion from MisionNinja mn
INNER JOIN Ninja n On mn.NinjaID = n.NinjaID
inner Join Mision mi on mn.MisionID = mi.MisionID
where mn.FechaInicio IS not NULL 
AND mn.FechaFin IS not NULL
AND n.NinjaID = 4;


--Asignar una mision
INSERT INTO MisionNinja (NinjaID, MisionID, FechaInicio, FechaFin) VALUES (5,4,"2024-01-29","2024-01-29");
