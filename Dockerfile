FROM java:8
EXPOSE 8080:8080
COPY target/SpringBootWebApp.jar SpringBootWebApp.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "SpringBootWebApp.jar"]