FROM maven:latest
RUN mkdir /salestaxes
COPY salestaxes /salestaxes/
WORKDIR /salestaxes
RUN ls -ls
RUN mvn clean install -DskipTests=true
WORKDIR /
RUN chmod 777 /salestaxes/target/salestaxes-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar /salestaxes/target/salestaxes-0.0.1-SNAPSHOT.jar
