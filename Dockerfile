# define base docker image
FROM openjdk:11
LABEL maintainer="com.zulkhe"
ADD target/Order-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]