FROM openjdk:17
ADD /target/bankingalstrom-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java" , "-jar" , "app.jar" ]

EXPOSE 9090