# fILTRO DE JAVA PROYECTO DE nARUTO

## Description
Se crea un manejo de CRUD, EN CLASES COMO :
MISION
nINJA
hABILIDADES

## OOP (Object Oriented Programming)
Aplicamos Herencai, Interfaz. Dao para el manejo de interfaz del CRUD

## Design pattern       
se eligio MVC
se aplico el modelo  vista controlardor

## SOLID application    

Los principios SOLID se aplicaron al modelo de paquete de eventos de la siguiente manera:

S – Principio de Responsabilidad Única: Aplicado mediante el uso de interfaces para cada acción (CRUD), permitiendo el polimorfismo ya que ciertas clases no implementan todas las acciones.

O – Principio de Abierto/Cerrado: Actualmente, estas interfaces implementan acciones como guardar, leer, modificar y eliminar. Sin embargo, algunas clases tienen acciones adicionales como mostrar toda la información o de una manera específica, dejándolo abierto a la adición de más acciones.

L – Principio de Sustitución de Liskov: Este principio explica cómo se deben usar correctamente la herencia y el polimorfismo. Nuestras clases hacen buen uso de este principio, donde se puede aplicar el polimorfismo.

I – Principio de Segregación de Interfaces: "Los objetos no deben ser forzados a depender de interfaces que no utilizan". Por lo tanto, hay una interfaz padre que contiene todas las interfaces gestionadas, y cada interfaz tiene su propia función y acción.

D – Principio de Inversión de Dependencias: Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones.

