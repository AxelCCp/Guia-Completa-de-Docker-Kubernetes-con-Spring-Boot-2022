#FROM openjdk:12.0.2
#WORKDIR /app
#COPY ./target/usuarios-0.0.1-SNAPSHOT.jar /app
#EXPOSE 8001
#ENTRYPOINT ["java","-jar","usuarios-0.0.1-SNAPSHOT.jar"]

#SECCIÓN 7 ... CLASE 56 ... EXPLICACIÓN EN ONENOTE  
#FROM openjdk:12.0.2
#WORKDIR /app/usuarios
#COPY ./pom.xml /app
#COPY ./usuarios .
#RUN ./mvnw clean package -DskipTests
#EXPOSE 8001
#ENTRYPOINT ["java","-jar","./target/usuarios-0.0.1-SNAPSHOT.jar"]

#SECCIÓN 7 ... CLASE 57 ... EXPLICACIÓN EN ONENOTE  
FROM openjdk:12.0.2
WORKDIR /app/usuarios
COPY ./pom.xml /app
COPY ./usuarios/.mvn ./.mvn
COPY ./usuarios/mvnw .
COPY ./usuarios/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip  -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
COPY ./usuarios/src ./src
RUN ./mvnw clean package -DskipTests
EXPOSE 8001
ENTRYPOINT ["java","-jar","./target/usuarios-0.0.1-SNAPSHOT.jar"]
