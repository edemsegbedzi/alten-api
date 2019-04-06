FROM openjdk
MAINTAINER segbedz.edem@gmail.com
ADD target/alten-api.jar alten-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "alten-api.jar"]