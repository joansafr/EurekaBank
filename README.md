EurekaBank
==========

Objetivos 

Crear una aplicacion que permita controlar las operaciones de una entidad financiera con respecto a sus cuentas de ahorro de sus clientes. 

## Proyecto 

EurekaBank es una institucion financiera que necesita una nueva aplicacion para controlar todas las operaciones respecto a las cuentas de ahorro de sus clientes. 

Las principales condiciones del negocio son:

1. Las cuentas de ahorro solo pertenecen a un cliente, no existen cuentas mancomunadas.

2. Un cliente puede tener varias cuentas.

3. Las cuentas pueden ser en Nuevos Soles o Dolares.

4. El costo de mantenimiento es de 7 Nuevos Soles para la cuenta en Nuevos Soles y 3 Dolares para la cuenta en Dolares.

5. Solo se puede dar de baja a una cuenta si su saldo es cero (0).

6. Por mes los clientes solo pueden hacer gratis 7 movimientos (deposito y/o retiro), a partir de movimiento 8 (deposito y/o retiro) tiene un costo: 3 Nuevos Soles para las cuentas en Nuevos Soles y 1 Dolar para las cuentas en Dolares. 

7. La empresa cuenta con varios locales, es importante identificar en que local fue creada la cuenta. 

8. Todas las operaciones con respecto a la cuenta deben ser identificadas de la siguientes manera: 

	a. Usuario que realiza la operacion.
	
	b. Fecha y hora.
	
	c. Local donde se realiza. 
	

## Requerimientos Funcionales 

A. Autenticacion del usuario, empleado que hara uso del sistema.

B. Mantenimiento de clientes - CRUD. 

C. Apertura de cuentas.

D. Registro de movimientos.

E. Cierre de cuenta.

F. Reporte de movimientos de una cuenta.

G. Reporte de operaciones realizadas en una fecha determinada y en un local especifico. 

## Desarrollo del Software 

Usted debe desarrollar el software que requiere la empresa Eureka Bank utilizando como minimo la siguiente tecnologia: 
- MySQL para la base de datos.
- JPA para la capa DAO.
- JSF para la capa de la vista y controlador. 
- Primefaces para mejorar la experiencia visual y utilidad en controles.
- JAAS para el modulo de seguridad.
- jQuery para el menu.
  