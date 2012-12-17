
CREATE TABLE EB_Cliente
(
	CodigoCliente        INTEGER NOT NULL,
	NombreCliente        VARCHAR(50) NULL,
	ApellidoCliente      VARCHAR(50) NULL,
	DniCliente           VARCHAR(8) NULL
);



ALTER TABLE EB_Cliente
ADD PRIMARY KEY (CodigoCliente);



CREATE TABLE EB_Cuenta
(
	CodigoCuenta         INTEGER NOT NULL,
	CodigoCliente        INTEGER NOT NULL,
	CodigoMoneda         INTEGER NOT NULL,
	Activo               BIT NULL,
	CodigoLocal          INTEGER NULL,
	CodigoUsuario        INTEGER NULL,
	FechaCreacionCuenta  DATE NULL,
	SaldoCuenta          DECIMAL(14,3) NULL
);



ALTER TABLE EB_Cuenta
ADD PRIMARY KEY (CodigoCuenta);



CREATE TABLE EB_Local
(
	CodigoLocal          INTEGER NOT NULL,
	NombreLocal          VARCHAR(50) NULL,
	DireccionLocal       VARCHAR(50) NULL
);



ALTER TABLE EB_Local
ADD PRIMARY KEY (CodigoLocal);



CREATE TABLE EB_Moneda
(
	CodigoMoneda         INTEGER NOT NULL,
	CostoMantenimiento   DECIMAL(14,3) NULL
);



ALTER TABLE EB_Moneda
ADD PRIMARY KEY (CodigoMoneda);



CREATE TABLE EB_Movimiento
(
	CodigoMovimiento     INTEGER NOT NULL,
	CodigoCuenta         INTEGER NULL,
	CostoMovimiento      DECIMAL(14,3) NULL,
	CodigoLocal          INTEGER NULL,
	CodigoUsuario        INTEGER NULL,
	FechaMovimiento      DATE NULL,
	HoraMovimiento       TIME NULL,
	TipoMovimiento       INTEGER NULL,
	MontoMovimiento      DECIMAL(14,3) NULL
);



ALTER TABLE EB_Movimiento
ADD PRIMARY KEY (CodigoMovimiento);



CREATE TABLE EB_Usuario
(
	CodigoUsuario        INTEGER NOT NULL,
	NombreUsuario        VARCHAR(50) NULL,
	IdentificadorUsuario VARCHAR(20) NULL,
	ContrasenaUsuario    VARCHAR(64) NULL
);



ALTER TABLE EB_Usuario
ADD PRIMARY KEY (CodigoUsuario);



ALTER TABLE EB_Cuenta
ADD FOREIGN KEY R_2 (CodigoCliente) REFERENCES EB_Cliente (CodigoCliente);



ALTER TABLE EB_Cuenta
ADD FOREIGN KEY R_3 (CodigoMoneda) REFERENCES EB_Moneda (CodigoMoneda);



ALTER TABLE EB_Cuenta
ADD FOREIGN KEY R_5 (CodigoLocal) REFERENCES EB_Local (CodigoLocal);



ALTER TABLE EB_Cuenta
ADD FOREIGN KEY R_7 (CodigoUsuario) REFERENCES EB_Usuario (CodigoUsuario);



ALTER TABLE EB_Movimiento
ADD FOREIGN KEY R_4 (CodigoCuenta) REFERENCES EB_Cuenta (CodigoCuenta);



ALTER TABLE EB_Movimiento
ADD FOREIGN KEY R_6 (CodigoLocal) REFERENCES EB_Local (CodigoLocal);



ALTER TABLE EB_Movimiento
ADD FOREIGN KEY R_8 (CodigoUsuario) REFERENCES EB_Usuario (CodigoUsuario);


