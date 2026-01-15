# Hexagonal Spring Boot Archetype

## Descripción

Este proyecto es un **Maven Archetype** que facilita la creación de microservicios basados en **arquitectura hexagonal** (Ports & Adapters) utilizando **Java 21** y **Spring Boot 3.3**. 

La arquitectura hexagonal promueve la separación de responsabilidades, manteniendo el dominio independiente de los frameworks externos. Este archetype genera una estructura base que incluye:

- **Dominio**: Modelo de negocio, casos de uso y servicios de dominio puros (sin dependencias de Spring).
- **Infraestructura**: Adaptadores para entrada (REST controllers) y salida (persistencia JPA), junto con configuraciones de Spring Boot.

## Tecnologías Incluidas

- **Java 21**: Versión LTS más reciente con características modernas.
- **Spring Boot 3.3**: Framework para desarrollo rápido de aplicaciones.
- **Maven**: Herramienta de build y gestión de dependencias.
- **Arquitectura Hexagonal**: Patrón de diseño para mantener el acoplamiento bajo.
- **Dependencias del proyecto generado**:
  - `spring-boot-starter-web`: Para APIs REST.
  - `spring-boot-starter-data-jpa`: Para persistencia.
  - `spring-boot-starter-test`: Para pruebas.
  - `H2`: Base de datos en memoria para desarrollo.

## Instalación del Archetype

Para instalar este archetype en tu repositorio local de Maven, ejecuta:

```bash
mvn clean install
```

Esto compilará el archetype y lo instalará en tu repositorio local (~/.m2/repository).

## Uso del Archetype

Una vez instalado, puedes generar un nuevo proyecto basado en este archetype usando el comando `mvn archetype:generate`.

### Comando Básico

```bash
mvn archetype:generate \
  -DarchetypeGroupId=com.example \
  -DarchetypeArtifactId=hexagonal-springboot-archetype \
  -DarchetypeVersion=1.0.0 \
  -DgroupId=com.tuempresa \
  -DartifactId=mi-microservicio \
  -Dversion=1.0.0-SNAPSHOT \
  -Dpackage=com.tuempresa.mimicroservicio \
  -DserviceName=MiMicroservicio
```

### Parámetros Explicados

- `-DarchetypeGroupId=com.example`: Grupo del archetype (definido en este proyecto).
- `-DarchetypeArtifactId=hexagonal-springboot-archetype`: Artefacto del archetype.
- `-DarchetypeVersion=1.0.0`: Versión del archetype.
- `-DgroupId=com.tuempresa`: Grupo de tu nuevo proyecto.
- `-DartifactId=mi-microservicio`: Nombre del artefacto de tu proyecto.
- `-Dversion=1.0.0-SNAPSHOT`: Versión inicial de tu proyecto.
- `-Dpackage=com.tuempresa.mimicroservicio`: Paquete base de tu proyecto.
- `-DserviceName=MiMicroservicio`: Nombre del servicio (usado en clases como `MiMicroservicioApplication`).

### Ejemplo Interactivo

Si prefieres el modo interactivo, ejecuta:

```bash
mvn archetype:generate
```

Luego selecciona el archetype de la lista (busca `com.example:hexagonal-springboot-archetype`).

## Estructura del Proyecto Generado

El proyecto generado tendrá la siguiente estructura de directorios:

```
mi-microservicio/
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── tuempresa
                    └── mimicroservicio
                        ├── MiMicroservicioApplication.java  # Clase principal de Spring Boot
                        ├── domain
                        │   ├── model
                        │   │   └── SampleAggregate.java     # Entidad de dominio
                        │   ├── port
                        │   │   ├── in
                        │   │   │   └── SampleUseCase.java   # Puerto de entrada (caso de uso)
                        │   │   └── out
                        │   │       └── SampleRepository.java # Puerto de salida (repositorio)
                        │   └── service
                        │       └── SampleService.java       # Servicio de dominio
                        └── infrastructure
                            ├── adapter
                            │   ├── in
                            │   │   └── rest
                            │   │       └── SampleController.java  # Controlador REST
                            │   └── out
                            │       └── persistence
                            │           └── JpaSampleRepository.java # Adaptador de persistencia JPA
                            └── config
                                └── SampleConfig.java         # Configuración de Spring
```

### Descripción de Capas

- **Domain**: Contiene la lógica de negocio pura, sin dependencias externas.
- **Infrastructure**: Implementa los puertos definidos en el dominio usando frameworks específicos.

## Validación del Proyecto Generado

Después de generar el proyecto, navega a su directorio y ejecuta:

```bash
mvn clean verify  # Compila y ejecuta pruebas
mvn spring-boot:run  # Inicia la aplicación
```

La aplicación debería estar disponible en `http://localhost:8080`.

## Contribución

Si deseas contribuir a este archetype:

1. Realiza tus cambios.
2. Ejecuta `mvn clean install` para probar.
3. Genera un proyecto de prueba y verifica que funcione.
4. Envía un pull request.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
