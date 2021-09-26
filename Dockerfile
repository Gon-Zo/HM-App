FROM rtfpessoa/ubuntu-jdk8

RUN mkdir webapp

COPY build/libs/middleware-0.0.1-SNAPSHOT.jar ./webapp/middleware-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java" , "-Djasypt.encryptor.password=${JASYPT}","-jar" , "./webapp/middleware-0.0.1-SNAPSHOT.jar"]
