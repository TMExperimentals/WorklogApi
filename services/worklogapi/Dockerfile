FROM gradle:7.4.2-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM eclipse-temurin:17.0.3_7-jre-alpine
EXPOSE 8080:8080
RUN mkdir /app
COPY --from=build /home/gradle/src/services/worklogapi/build/libs/*.jar /app/worklogapi.jar
ENTRYPOINT ["java","-jar","/app/worklogapi.jar"]