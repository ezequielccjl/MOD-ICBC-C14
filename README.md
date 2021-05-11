# mds-automation - automation

## Como saber que depencias cargar para testear un servicio?
Supongamos que debemos testear la operacion **getDestinationInfo** del servicio **channel-transfer-account**
Para encontrar la dependencia correcta debemos ir a **[Appflow](https://appflow-dev.intranet.local/)**.
- Ingresamos en la capa experience (C1 a C5 proyecto MDS).
- Buscamos el servicio (channel-transfer-account en el ejemplo)
- Buscamos la operación (getDestinationInfo)
- Ampliamos en **Versiones y generación de release**
- Ampliamos en **Lista de Tareas**
- EN APPFLOW! Copiamos la dependencia clickeando en "generateMSClient" (se muestra un formato a modo de EJEMPLO )

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

