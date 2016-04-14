# poc-springboot
POC using SpringBoot: Spring application that allows you to create and retrieve Person objects stored in a MongoDB NoSQL database using Spring Data REST.

## Configuration
Default MongoDB config in application.properties file:

```
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=poc
```

## How to run
If you are using Maven, you can run the application using **mvn spring-boot:run**. Or you can build the JAR file with **mvn clean package** and run the JAR by typing:
```
java -jar target/poc-springboot-1.0-SNAPSHOT.jar
```


## Rest API examples
GET
```
curl http://localhost:8080/persons/{ID}
```

POST
```
curl -i -X POST -H "Content-Type:application/json" -d '{  "firstName" : "Marty",  "lastName" : "McFly" }' http://localhost:8080/persons
```

PUT
```
curl -X PUT -H "Content-Type:application/json" -d '{ "firstName": "Emmett", "lastName": "Brown" }' http://localhost:8080/persons/{ID}
```

DELETE
```
curl -X DELETE http://localhost:8080/persons/{ID}
```

> NOTE: Spring Data REST uses the [HAL format](http://stateless.co/hal_specification.html) for JSON output. It is flexible and offers a convenient way to supply links adjacent to the data that is served.

