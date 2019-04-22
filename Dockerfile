FROM maven as BUILD

COPY . /usr/src/app
RUN apt update 
RUN apt install procps
RUN mvn -f /usr/src/app/pom.xml clean 
#RUN mvn --batch-mode -f /usr/src/app/pom.xml compile
#RUN mvn --batch-mode -f /usr/src/app/pom.xml test
RUN mvn -f /usr/src/app/pom.xml package
