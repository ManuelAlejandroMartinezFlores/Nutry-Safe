# Src

## Modelos
+ `Usuario.java`: representa al usuario que utiliza el programa. Contiene información personal como el nombre de usuario, nombre, edad, altura, objetivo de calorías 
y cantidad de calorías consumidas en el día.

+ `Receta.java`: representa las acciones del programa hacia el usuario. Es decir, presenta las recetas para el usuario y consejos acorde a los datos ingresados 
en la clase usuario. 

+ `MongoDB.java`: se encarga de conectarse con MongoDB Atlas para la persistencia de datos

+ `Controlador.java`: contiene la lógica de todo el programa. Única clase que está relacionada tanto con los modelos y con las vistas.

## Vista

+ `PanelIngreso.java`: meustra la interfaz gráfica para el inicio de sesión

+ `PanelGeneral.java`: muestra un menú de opciones y cambia entre paneles

+ `PanelDatos.java`: muestra la interfaz gráfica para cambiar los datos del usuario

+ `PanelCaloria.java`: mustra la interfaz gráfica para contar las calorias del usaurio

+ `PanelConsejos.java`: muestra la interfaz gráfica con consejos personalizados para el usuario

+ `PanelReceta.java`: muestra la interfaz gráfica con una receta personalizada para el usuario

## Driver
+ `App.java`: contiene el método main
