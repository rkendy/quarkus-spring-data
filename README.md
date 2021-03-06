# code-with-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Extensions

RestEasy JSON-B, SmallRye OpenAPI, JDBC Driver H2, Quarkus Extension for Spring Data JPA API

## Add extension

mvn quarkus:list-extensions
mvn quarkus:add-extension -Dextensions="quarkus-jdbc-mysql,quarkus-smallrye-health"

## Docker: mysql

docker pull mysql
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
docker exec -it mysql bash
docker start mysql
docker stop mysql

## Integration Test with Docker

Testcontainers
Database Rider
\$ mvn verify -Pfailsafe

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `code-with-quarkus-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
