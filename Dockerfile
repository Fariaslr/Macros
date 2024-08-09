# Usar uma imagem base com Java JDK 17
FROM openjdk:17-jdk-alpine

# Definir um diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado pela sua aplicação Spring Boot para o container
COPY target/*.jar app.jar

# Expor a porta que a aplicação Spring Boot usa
EXPOSE 8080

# Comando para executar a aplicação Spring Boot
ENTRYPOINT ["java","-jar","/app/app.jar"]
