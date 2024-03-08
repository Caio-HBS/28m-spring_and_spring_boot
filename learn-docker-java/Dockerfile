FROM maven:3.9.6-ibm-semeru-21-jammy AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/caiohbs/learndockerjava/LearnDockerJavaApplication.java /home/app/src/main/java/com/caiohbs/learndockerjava/LearnDockerJavaApplication.java

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM ibm-semeru-runtimes:open-21-jdk-jammy
VOLUME /tmp
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]