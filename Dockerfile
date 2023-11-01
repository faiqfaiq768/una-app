FROM maven:3.8.3-openjdk-8 AS build
WORKDIR /una-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run