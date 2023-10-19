FROM openjdk

MAINTAINER nk1123

WORKDIR /app

COPY target/phoneBook.jar /app/phoneBook.jar

ENTRYPOINT ["java", "-jar", "phoneBook.jar"]