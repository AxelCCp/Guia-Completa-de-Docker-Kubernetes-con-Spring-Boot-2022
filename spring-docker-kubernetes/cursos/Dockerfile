#CLASE 70 ... 
FROM openjdk:12.0.2 as builder
WORKDIR /app/cursos
COPY ./pom.xml /app
COPY ./cursos/.mvn ./.mvn
COPY ./cursos/mvnw .
COPY ./cursos/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip  -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
COPY ./cursos/src ./src
RUN ./mvnw clean package -DskipTests
FROM openjdk:12.0.2
WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/cursos/target/cursos-0.0.1-SNAPSHOT.jar .
EXPOSE 8002
CMD ["java","-jar","cursos-0.0.1-SNAPSHOT.jar"]
