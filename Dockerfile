



FROM eclipse-temurin:21-jre-alpine

# Creamos el directorio de trabajo
WORKDIR /opt/publicacion

# Copiamos el archivo JAR directamente al directorio actual (.)
COPY ./target/LaFachada-0.0.1-SNAPSHOT.jar .


# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "LaFachada-0.0.1-SNAPSHOT.jar"]