FROM rtfpessoa/ubuntu-jdk8

RUN mkdir webapp

COPY build/libs/middleware-0.0.1-SNAPSHOT.jar ./webapp/middleware-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["sh", "-c", "java -Djasypt.encryptor.password=${JASYPT_OPTS} -jar ./webapp/middleware-0.0.1-SNAPSHOT.jar"]
