CREATE DATABASE WebBanking;
USE WebBanking;

-- Cliente
create table Cliente (
	id_cliente int auto_increment primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    ci int unique not null,
    telefono varchar(15),
    direccion varchar(100)
    );
    
-- Cuenta
create table Cuenta (
	id_cuenta int auto_increment primary key,
    id_cliente int not null,
    tipo_cuenta ENUM('ahorro', 'corriente') not null,
    saldo int not null default 0,
    fecha_apertura date not null,
    estado ENUM('activa','inactiva') not null default 'activa',
	pin_cuenta CHAR(60) not null,
    pin_transaccion CHAR(60) not null,
    FOREIGN KEY (id_cliente) references Cliente(id_cliente)
    );
    
-- Servicio
create table Servicio (
	id_servicio int auto_increment primary key,
    nombre_servicio varchar(50) not null,
    proveedor_servicio varchar(50) not null,
    detalle_servicio varchar(150)
    );
    
-- Tarjeta 
CREATE TABLE Tarjeta (
    id_tarjeta INT AUTO_INCREMENT PRIMARY KEY,
    id_cuenta INT NOT NULL,
    numero_tarjeta CHAR(16) UNIQUE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    limite_credito INT NOT NULL DEFAULT 0,
    saldo_disponible INT NOT NULL,
    estado ENUM('activa', 'bloqueada') NOT NULL DEFAULT 'activa',
    FOREIGN KEY (id_cuenta) REFERENCES Cuenta(id_cuenta)
);

    
-- Tabla Operacion
CREATE TABLE Operacion (
    id_operacion INT AUTO_INCREMENT PRIMARY KEY,
    id_cuenta INT NOT NULL,
    tipo_operacion ENUM('retiro', 'deposito', 'transferencia', 'pago de servicio', 'pago de tarjeta') NOT NULL,
    monto int NOT NULL,
    estado_operacion enum('Procesada', 'Pendiente'),
    fecha_hora DATETIME NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES Cuenta(id_cuenta)
);

-- PagoServicio
CREATE TABLE PagoServicio (
    id_pago_servicio int AUTO_INCREMENT PRIMARY KEY,
    id_cuenta INT NOT NULL,
    id_servicio INT NOT NULL,
    monto int NOT NULL,
    fecha_hora DATETIME NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES Cuenta(id_cuenta),
    FOREIGN KEY (id_servicio) REFERENCES Servicio(id_servicio)
);

-- PagoTarjeta
CREATE TABLE PagoTarjeta (
    id_pago_tarjeta INT AUTO_INCREMENT PRIMARY KEY,
    id_cuenta INT NOT NULL,
    id_tarjeta INT NOT NULL,
    monto DECIMAL(15, 2) NOT NULL,
    fecha_hora DATETIME NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES Cuenta(id_cuenta),
    FOREIGN KEY (id_tarjeta) REFERENCES Tarjeta(id_tarjeta)
);

-- Prueba


select * from Cliente;
select * from Cuenta;
select * from Tarjeta;

SELECT c.id_cliente, c.nombre, cu.id_cuenta, cu.tipo_cuenta, cu.saldo
FROM Cliente c
JOIN Cuenta cu ON c.id_cliente = cu.id_cliente
WHERE c.id_cliente = 1;	

alter table Tarjeta
add column deuda INT AS (limite_credito - saldo_disponible);

ALTER TABLE Cliente
ADD COLUMN email VARCHAR(100) NOT NULL UNIQUE,
ADD COLUMN contrasena CHAR(60) NOT NULL;


INSERT INTO Cliente (nombre, apellido, ci, telefono, direccion,email,contrasena)
VALUES ('Alejandra', 'Britos', '5087100', '0983448167', 'Calle Primavera 55','alejandra.britos@gmail.com', 'contra123');

INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (1, 'ahorro', 1500000, '2024-01-01', 'activa', '8765', '1234');

INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (1, 'ahorro', 0, '2024-01-20', 'activa', '9876', '2345');

-- Insertar primer cliente
INSERT INTO Cliente (nombre, apellido, ci, telefono, direccion, email, contrasena)
VALUES ('Carlos', 'González', '7030100', '0976123456', 'Calle Central 123', 'carlos.gonzalez@gmail.com', 'contra123');

-- Insertar segundo cliente
INSERT INTO Cliente (nombre, apellido, ci, telefono, direccion, email, contrasena)
VALUES ('María', 'Fernández', '8030200', '0987654321', 'Avenida Libertad 45', 'maria.fernandez@gmail.com', 'contra321');

-- Cuentas del primer cliente (Carlos González)
INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (2, 'ahorro', 500000, '2024-02-01', 'activa', '5678', '4321');

INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (2, 'corriente', 1000000, '2024-02-15', 'activa', '6789', '5432');

-- Cuenta del segundo cliente (María Fernández)
INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (3, 'ahorro', 300000, '2024-03-01', 'activa', '7890', '6543');


INSERT INTO Tarjeta (id_cuenta, numero_tarjeta, fecha_vencimiento, limite_credito, saldo_disponible, estado)
VALUES (2, '1234567812345678', '2026-12-31', 2000000, 2000000, 'activa');

INSERT INTO Tarjeta (id_cuenta, numero_tarjeta, fecha_vencimiento, limite_credito, saldo_disponible, estado)
VALUES (1, '8765432187654321', '2027-05-31', 3000000, 1000000, 'activa');

INSERT INTO Servicio (nombre_servicio, proveedor_servicio, detalle_servicio)
VALUES 
('Electricidad', 'Proveedor Nacional de Energía', 'Pago de facturas de electricidad'),
('Agua Potable', 'Servicio Municipal de Agua', 'Pago de facturas de agua potable'),
('Internet', 'Proveedor de Internet X', 'Pago mensual de servicio de internet'),
('Telefonía Móvil', 'Proveedor de Telefonía Y', 'Recarga de saldo y pago de facturas móviles'),
('Gas Domiciliario', 'Proveedor Nacional de Gas', 'Pago de suministro de gas para el hogar'),
('Televisión por Cable', 'Cable X', 'Pago mensual del servicio de televisión por cable');


