FROM openjdk:17-oracle
EXPOSE 8080
ADD target/spring-security-latest.jar spring-security-latest.jar
ENTRYPOINT ["java", "-jar", "/spring-security-latest.jar"]