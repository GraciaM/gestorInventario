CREATE DATABASE Inventario CHARACTER SET utf8 COLLATE utf8_spanish_ci;
use Inventario;

CREATE TABLE Proveedor (
  CIF varchar(10) NOT NULL,
  Empresa varchar(30) NOT NULL,
  Direccion varchar(50),
  Ciudad varchar (15),
  Telefono varchar (20),
  Email varchar(30),
  PRIMARY KEY (CIF)
) engine=innodb;

INSERT INTO Proveedor VALUES ('9873490823','CNA Group','CALLE PATATA','BARCELONA','+34 93 3561182','cacafuti@gmail.com');
INSERT INTO Proveedor VALUES ('2342398789','DPLGroup','CALLE HABICHUELA','VALENCIA','+34 96 3561187','cacafuto@gmail.com');
INSERT INTO Proveedor VALUES ('7236483292','FerSay','CALLE GOMINOLA','VALENCIA','+34 93 3561184','cacafutu@gmail.com');


CREATE TABLE Pieza (
  ID varchar (30) NOT NULL,
  Nombre varchar(30) NOT NULL,
  Descripcion text NULL,
  Precio_venta integer NOT NULL,
  PRIMARY KEY (ID)
) engine=innodb;

INSERT INTO Pieza VALUES ('15101000', 'Motor', 'Grupo motor para campana extractora de cocina', '95.59');
INSERT INTO Pieza VALUES ('15100033', 'Botonera', 'Caja de mandos para campana extractora de cocina', '63.69');
INSERT INTO Pieza VALUES ('485189911103', 'Condensador', 'Condensador 35 mm - 450V para lavadora', '6.85');
INSERT INTO Pieza VALUES ('V99I000H1', 'Bomba', 'Bomba desagüe EBS2556-0707 para lavadora', '28.89');
INSERT INTO Pieza VALUES ('481946818049', 'Burlete', 'Burlete medidas 98.7x57.1 cm para frigorifico combi', '33.50');
INSERT INTO Pieza VALUES ('83040745', 'Resistencia', 'Resistencia INFERIOR 900/300w para horno', '15.25');

CREATE TABLE Pieza_Costo (
  CIF_Proveedor varchar(10) NOT NULL,
  ID_Pieza varchar(30) NOT NULL,
  Precio_costo double,
  PRIMARY KEY (CIF_Proveedor, ID_Pieza),
  CONSTRAINT PP_Pro_FK FOREIGN KEY (CIF_Proveedor) REFERENCES Proveedor (CIF),
  CONSTRAINT PP_Pie_FK FOREIGN KEY (ID_Pieza) REFERENCES Pieza (ID)
) engine=innodb;

INSERT INTO Pieza_Costo VALUES ('9873490823','15101000','47.40');
INSERT INTO Pieza_Costo VALUES ('9873490823','15100033','25.78');
INSERT INTO Pieza_Costo VALUES ('2342398789','485189911103','3.01');
INSERT INTO Pieza_Costo VALUES ('2342398789','V99I000H1','12.56');
INSERT INTO Pieza_Costo VALUES ('7236483292','481946818049','14.97');
INSERT INTO Pieza_Costo VALUES ('9873490823','83040745','7.46');

CREATE TABLE Ubicacion (
  Estanteria varchar(5),
  Estante varchar(5),
  PRIMARY KEY (Estanteria, Estante)
) engine=innodb;

INSERT INTO Ubicacion VALUES ('1','A');
INSERT INTO Ubicacion VALUES ('1','B');
INSERT INTO Ubicacion VALUES ('2','A');
INSERT INTO Ubicacion VALUES ('2','B');
INSERT INTO Ubicacion VALUES ('3','A');
INSERT INTO Ubicacion VALUES ('4','A');

CREATE TABLE Pieza_Ubicacion (
  ID_Pieza varchar(30) NOT NULL,
  EstanteriaUbicacion varchar(5),
  EstanteUbicacion varchar(5),
  Stock integer,
  Stock_prestado integer,
  PRIMARY KEY (ID_Pieza, EstanteriaUbicacion, EstanteUbicacion),
  CONSTRAINT PU_Pie_FK FOREIGN KEY (ID_Pieza) REFERENCES Pieza (ID),
  CONSTRAINT PU_Ubi_FK FOREIGN KEY (EstanteriaUbicacion, EstanteUbicacion) REFERENCES Ubicacion (Estanteria, Estante)
)engine=innodb;

INSERT INTO Pieza_Ubicacion VALUES ('15101000', '1', 'A', '9', '1');
INSERT INTO Pieza_Ubicacion VALUES ('15100033', '1', 'B', '13', '3');
INSERT INTO Pieza_Ubicacion VALUES ('485189911103', '2', 'A', '11', '0');
INSERT INTO Pieza_Ubicacion VALUES ('V99I000H1', '2', 'B', '2', '1');
INSERT INTO Pieza_Ubicacion VALUES ('481946818049', '3', 'A', '1', '0');
INSERT INTO Pieza_Ubicacion VALUES ('83040745', '4', 'A', '6', '0');

CREATE TABLE Familia (
  Nombre varchar (20),
  Descripcion text NULL,
  PRIMARY KEY (Nombre)
) engine=innodb;

INSERT INTO Familia VALUES ('Campana', 'Extractor de humos activado por un ventilador aspirador, con panel de control y temporizador.');
INSERT INTO Familia VALUES ('Frigorifico', 'Frigorífico combi no frost Total.');
INSERT INTO Familia VALUES ('Lavadora', 'Lavadora carga frontal.');
INSERT INTO Familia VALUES ('Horno', 'Multifunción con HydrocleanECO, Sistema de Limpieza automático, Eficiencia energfética A+');

CREATE TABLE Producto (
  Modelo varchar(30) NOT NULL,
  Marca varchar(15) NOT NULL,
  Medida int,
  Color varchar (15),
  NombreFamilia varchar (29),
  PRIMARY KEY (Modelo, Marca),
  CONSTRAINT Pro_Fam_FK FOREIGN KEY (NombreFamilia) REFERENCES Familia (Nombre)
) engine=innodb;

INSERT INTO Producto VALUES ('SYGMA', 'Cata', '90', 'Inox', 'Campana');
INSERT INTO Producto VALUES ('THALASSA', 'Cata', '60', 'BLACK', 'Campana');
INSERT INTO Producto VALUES ('4FE-8814', 'Fagor', NULL, NULL, 'Lavadora');
INSERT INTO Producto VALUES ('W19l MO1L Combi', 'Whirlpool', NULL, 'Inox', 'Frigorifico');
INSERT INTO Producto VALUES ('HCB 6535', 'Teka', '60', 'Inox', 'Horno');

CREATE TABLE Pieza_pertenece_Producto (
  ID_Pieza varchar (30) NOT NULL,
  ModeloProducto varchar(30) NOT NULL,
  MarcaProducto varchar(15) NOT NULL,
  PRIMARY KEY (ID_Pieza, ModeloProducto, MarcaProducto),
  CONSTRAINT Ppp_Pie_FK FOREIGN KEY (ID_Pieza) REFERENCES Pieza (ID),
  CONSTRAINT Ppp_Pro_FK FOREIGN KEY (ModeloProducto, MarcaProducto) REFERENCES Producto (Modelo, Marca)
) engine=innodb;

INSERT INTO Pieza_pertenece_Producto VALUES ('15101000', 'SYGMA', 'Cata');
INSERT INTO Pieza_pertenece_Producto VALUES ('15100033', 'THALASSA', 'Cata');
INSERT INTO Pieza_pertenece_Producto VALUES ('485189911103', '4FE-8814', 'Fagor');
INSERT INTO Pieza_pertenece_Producto VALUES ('V99I000H1', '4FE-8814', 'Fagor');
INSERT INTO Pieza_pertenece_Producto VALUES ('481946818049', 'W19l MO1L Combi', 'Whirlpool');
INSERT INTO Pieza_pertenece_Producto VALUES ('83040745', 'HCB 6535', 'Teka');


