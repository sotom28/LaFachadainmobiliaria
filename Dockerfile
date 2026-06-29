FROM eclipse-temurin:21
RUN mkdir /opt/publicacion
COPY ./target/LaFachada-0.0.1-SNAPSHOT.jar /opt/publicacion
ENTRYPOINT ["java", "-jar", "/opt/publicacion/LaFachada-0.0.1-SNAPSHOT.jar"]

