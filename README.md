# Movix

Una aplicación hecha específicamente para Android, donde se puede ver todo tipo de películas en ella, ver los trailers, sus calificaciones, fecha de estreno, tipo de géneros que estos tengan y poder agregarlos a lista de favoritos. 

### Pre-requisitos

* Android Studio o Visual Studio
* Smartphone con Sistema Operativo de Android
* Tener habilitado opciones de desarrollador en su Smartphone(si quiere utilizar su telefono para esta app). Si no sabe cómo hacerlo, seguir los pasos en este [link!](https://developer.android.com/studio/debug/dev-options?hl=es-419)


## Instalación

1. Descargar proyecto.
2. Descomprimir el archivo para poder abrirlo en Android Studio.
3. Instalar y/o actualizar las librerías que le recomienda Android Studio para poder utilizar la aplicación Movix.
   - En la esquina inferior derecha, las notificaciones aparecerán para su actualización o instalación de las librerías.  
   - Si no quiere utilizar su Smartphone para la aplicación, omita el inciso 3.
   
## Problemas con la instalación de la applicación
- Si surgen problemas con la instación de la aplicación donde salga un aviso de "Invalid VCS root mapping" puede resolverlo de dos formas, siga los siguientes pasos: 
   - Puede solucionarlo eliminando el archivo `vcs.xml` ubicado en la carpeta `.idea` de su proyecto y luego vuelva a abrir su IDE.
   - Asegúrese de que el proyecto fue clonado y no descargado como un archivo zip en el directorio que está utilizando. Ejemplo:
   `C:\Users\nombre\Desktop\nombre-de-la-app`

## Ejecución

1. Antes de poder correr la aplicación, debe de ir a [The Movie Database (TMDb)](https://www.themoviedb.org/?_dc=1586494174) para poder   crear su propia cuenta.
   - Luego de crear la cuenta, dirigirse a este link [API](https://www.themoviedb.org/documentation/api) para saber de qué trata la API      de TMDb.
   - Dirigirse a este a [The Movie DB](https://developers.themoviedb.org/3/getting-started/introduction) (recordar que tiene que estar        regristrado a TMDb para entrar correctamente al link).
   - Para obtener la clave API, haga click desde la página de configuración de su cuenta. También puede ver las capturas de pantalla          a continuación para obtener ayuda:
#### Paso 1   
   ![screenshot](https://user-images.githubusercontent.com/63436697/78964568-e357b000-7ab7-11ea-8104-f964465f2f9a.png)

#### Paso 2
![screenshot](https://user-images.githubusercontent.com/63436697/78964899-b952bd80-7ab8-11ea-841e-849e1f572983.png)
#### Paso 3
![api_step_3-1534865163](https://user-images.githubusercontent.com/63436697/78964957-e1422100-7ab8-11ea-9fd6-59de17cd8093.png)
#### Paso 4  
![api_step_4-1534865184](https://user-images.githubusercontent.com/63436697/78964975-ef903d00-7ab8-11ea-82ea-da2c023d1706.png)

Llenar todas las casillas para poder obtener el API de TMDb, inmediatamente le darán el *API key*, este es único, sólo es para su cuenta. Copiar el API key.

***Nota Importante:***
Tenga en cuenta que el proceso de registro de API no está optimizado para dispositivos móviles, por lo que debe acceder a estas páginas en una computadora de escritorio y un navegador.   

*En Android Studio* (ya abierto el proyecto)
1. Abrir el módulo que se llama **app**.
2. Dirigirse a la carpeta **res** y ábrela.
3. Abrir la carpeta **values**.
4. Abrir el archivo **api_key.xml**, y pegar el API key donde dice ***Favor poner su API_KEY***
5. Ya puede correr la aplicación

*Correr la aplicación en Android Studio*
![Inkedpic_LI](https://user-images.githubusercontent.com/63436697/78965850-7c3bfa80-7abb-11ea-8e17-cb53d8f6537c.jpg)


## Créditos

Nombre de la herramienta | Descripción
------------ | -------------
[Kotlin](https://developer.android.com/kotlin)| Kotlin es un lenguaje de programación moderno de tipo estático que aumentará su productividad y aumentará la felicidad de su desarrollador.
[Retrofit](https://github.com/square/retrofit) | Retrofit convierte su API HTTP en una interfaz Java.
[Room](https://developer.android.com/topic/libraries/architecture/room) | La biblioteca lo ayuda a crear un caché de los datos de su aplicación en un dispositivo que ejecuta su aplicación.
[RxAndroid](https://github.com/ReactiveX/RxAndroid) | Proporciona un Scheduler que programa en el hilo principal o en cualquier Looper dado.
[Picasso](https://github.com/square/picasso) | Picasso permite la carga de imágenes sin problemas en su aplicación
[Dagger 2](https://github.com/google/dagger) | Dagger es un marco de tiempo de compilación para la inyección de dependencias.
[LeakCanary](https://github.com/square/leakcanary) | LeakCanary es una biblioteca de detección de pérdida de memoria para Android.
[ConstraintLayout](https://github.com/square/leakcanary) | Le permite crear diseños grandes y complejos con una jerarquía de vista plana (sin grupos de vista anidados).
[Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html) | Los componentes de la arquitectura de Android son una colección de bibliotecas que lo ayudan a diseñar aplicaciones robustas, comprobables y mantenibles. Comience con clases para administrar el ciclo de vida de su componente UI y manejar la persistencia de datos.

*Métodos utilizados*
* Arquitectura limpia

## Video de Movix App

[Video de Movix App](https://youtu.be/Tt6dj_moYiA)

## Autor de la aplicación Movix

* **Ashley Valdez Vásquez** 


## Expresiones de gratitud
* Inspiración al crear aplicaciónes en Android y Flutter
