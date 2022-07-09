# Test Back-end Agrotis

# Dependencies

- Java 11
- Maven
- Docker Compose or an already setup Postgres DB

## Start the API with docker

- run `docker-compose up -d`
- use maven cli with the command `mvn spring-boot:run` or a IDE to start the project

## Starting the API with an already setup Postgres DB

- configure the postgres connection on `application.yml` inside the folder `src/main/resources`
- use maven cli with the command `mvn spring-boot:run` or a IDE to start the project
