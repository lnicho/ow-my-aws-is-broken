FROM gradle:6.6.1-jdk11 as build
VOLUME /tmp
WORKDIR /
COPY . .
RUN gradle --stacktrace clean build
RUN mv ./build/libs/app.jar /app.jar

FROM adoptopenjdk/openjdk11:alpine
WORKDIR /
COPY --from=build /app.jar /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]