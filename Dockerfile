FROM maven as BUILD
COPY ./target/*.jar /usr/src/app
RUN mv /usr/src/app/*.jar /usr/src/app/app.jar
WORKDIR /usr/src/app
RUN apt update 
RUN apt install procps
CMD java -Xms512m -Xmx1024m -XX:MaxGCPauseMillis=200 -XX:-UseParallelOldGC -XX:+UseGCOverheadLimit -jar app.jar -Dspring.config.location=file:///app/config/application.properties -Dlogging.file=log/app.log
EXPOSE 8080
