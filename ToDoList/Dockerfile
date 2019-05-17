FROM maven as maven
COPY . .
RUN mvn clean package
FROM java:8
COPY --from=maven /target/ToDoList-1.0-SNAPSHOT.jar app.jar
ENRTYPOINT ["/usr/bin/java", "-jar", "app.jar"]
