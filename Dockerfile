# Use official Java image as base
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the Maven build file and source code
COPY . /app

# Package the Spring Boot application (during image build)
RUN ./mvnw package -DskipTests

# Run the jar file (from target directory)
CMD ["java", "-jar", "target/todo-app-1.0.0.jar"]
