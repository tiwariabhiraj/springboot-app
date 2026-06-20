# Use Java 17 runtime
FROM eclipse-temurin:17-jre

# Working directory inside container
WORKDIR /app

# Copy generated JAR
COPY target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 9001

# Start application
ENTRYPOINT ["java", "-jar", "app.jar"]