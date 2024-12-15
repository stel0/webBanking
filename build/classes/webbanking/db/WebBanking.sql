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
create table Tarjeta (
	id_tarjeta int auto_increment primary key,
    id_cuenta int not null,
    numero_tarjeta char(16) unique not null,
    fecha_vencimiento date not null,
    limite_credito int not null default 0,
    saldo_disponible int not null,
    deuda int not null default,
    estado enum('activa','bloqueada') not null default 'activa',
    foreign key (id_cuenta) references Cuenta(id_cuenta)
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
INSERT INTO Cliente (nombre, apellido, ci, telefono, direccion)
VALUES ('Alejandra', 'Britos', '5087100', '0983448167', 'Calle Primavera 55');

INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (1, 'ahorro', 1500000, '2024-01-01', 'activa', '8765', '1234');

INSERT INTO Cuenta (id_cliente, tipo_cuenta, saldo, fecha_apertura, estado, pin_cuenta, pin_transaccion)
VALUES (1, 'ahorro', 0, '2024-01-20', 'activa', '9876', '2345');

select * from cliente;
select * from cuenta;
select * from tarjeta;

SELECT c.id_cliente, c.nombre, cu.id_cuenta, cu.tipo_cuenta, cu.saldo
FROM Cliente c
JOIN Cuenta cu ON c.id_cliente = cu.id_cliente
WHERE c.id_cliente = 1;	

alter table Tarjeta
add column deuda INT AS (limite_credito - saldo_disponible);

