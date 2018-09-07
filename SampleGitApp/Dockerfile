# build
FROM maven:alpine AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:alpine
COPY --from=build /usr/src/app/target/SampleGitApp-1.0-SNAPSHOT-thorntail.jar /usr/app/SampleGitApp-1.0-SNAPSHOT-thorntail.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/app/SampleGitApp-1.0-SNAPSHOT-thorntail.jar"]

#FROM maven:alpine
#WORKDIR /usr/src/app
#COPY pom.xml .
#RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
#COPY . .
#RUN mvn -B -e -o -T 1C package

# package without maven
#FROM openjdk:alpine
#COPY --from=0 /usr/src/app/target/*.jar ./
