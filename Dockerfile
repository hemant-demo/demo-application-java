FROM maven:3.5-jdk-8 as BUILD

COPY ./src /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean 
RUN mvn --batch-mode -f /usr/src/app/pom.xml compile
RUN mvn --batch-mode -f /usr/src/app/pom.xml test
RUN mvn --batch-mode -f /usr/src/app/pom.xml package

#FROM openjdk:8-jdk
#ENV PORT 4567
#EXPOSE 4567
#COPY --from=BUILD /usr/src/app/target /opt/target
#WORKDIR /opt/target
#MD ["/bin/bash", "-c", "find -type f -name '*.jar' | xargs java -jar"]