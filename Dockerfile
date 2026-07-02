

FROM eclipse-temurin:21-jre-alpine

# Creamos el directorio de trabajo
WORKDIR /opt/publicacion

# Variable de entorno para el profile activo (opcional, ya lo tienes en properties)
ENV SPRING_PROFILES_ACTIVE=prod

# Copiamos el archivo JAR directamente al directorio actual (.)
COPY ./target/LaFachada-0.0.1-SNAPSHOT.jar .

# Documentamos el puerto que expone la app
EXPOSE 8086

# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "LaFachada-0.0.1-SNAPSHOT.jar"]