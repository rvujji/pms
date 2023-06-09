FROM openjdk:11
COPY target/pms-0.0.1-SNAPSHOT.jar pms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/pms-0.0.1-SNAPSHOT.jar"]