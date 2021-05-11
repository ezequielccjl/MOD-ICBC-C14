# MDS Automation

## Estructura de nombres de paquetes y carpetas
En pos de simplificar el trabajo entre las diferentes c�lulas, se considera conveniente llevar adelante la siguiente estructura.

##### Back
- Paquetes java: se agruparan por *servicios*. En caso de no existir el paquete, deber� crearse bajo la estructura `step.definition.back`
- Features: se agruparan por *servicios*. En caso de no existir la carpeta, deber� crearse dentro de la carpeta `features/back`

##### Front
- Paquetes java: se agruparan por *aplicaci�n*. En caso de no existir el paquete, deber� crearse bajo la estructura `step.definition.front`. Inicialmente tendremos un paquete `zap`. Podr�n crearse nuevos paquetes, si se considera necesario.
- Features: se agruparan por *aplicaci�n*. En caso de no existir la carpeta, deber� crearse dentro de la carpeta `features/front`. Podr�n crearse nuevas carpetas, si se considera necesario

## Como saber que depencias cargar para testear un servicio?
Supongamos que debemos testear la operacion **getDestinationInfo** del servicio **channel-transfer-account**
Para encontrar la dependencia correcta debemos ir a **[Appflow](https://appflow-dev.intranet.local/)**.
- Ingresamos en la capa experience (C1 a C5 proyecto MDS).
- Buscamos el servicio (channel-transfer-account en el ejemplo)
- Buscamos la operaci�n (getDestinationInfo)
- Ampliamos en **Versiones y generaci�n de release**
- Ampliamos en **Lista de Tareas**
- EN APPFLOW! Copiamos la dependencia clickeando en "generateMSClient" (se muestra un formato a modo de EJEMPLO)

```
<dependency>
	<groupId>com.ebanking.retail.mds</groupId>
	<artifactId>channel-transfer-account-client</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>
```

- Pegamos la dependencia en el pom.xml
- No compila? Leyo bien todo? =P

## Selenium test driver 
Para poder ejecutar la prueba de selenium es necesario
- En tu carpeta de usuario, crear una carpeta llamada `drivers`
- Descargar el [driver](https://chromedriver.chromium.org/downloads) correspondiente a la version que tengas instalada de Chrome.
- Pegar el driver en la carpeta creada en el paso anterior.

