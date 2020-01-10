FROM maven:3.5.2-jdk-9 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN cd /usr/src/app && mvn -Djavax.net.ssl.trustStorePassword=changeit clean package

FROM openjdk:9
COPY --from=build /usr/src/app/target/*.jar /app/app.jar
EXPOSE 8666
ENTRYPOINT ["java","-jar","/app/app.jar"]