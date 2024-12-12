FROM tomcat:8.5-jdk21

RUN sed -i 's/port="8080"/port="8082"/' ${CATALINA_HOME}/conf/server.xml

COPY target/services-weather-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
COPY logging.properties /usr/local/tomcat/conf/logging.properties

ENV JAVA_OPTS="-Djava.util.logging.config.file=/usr/local/tomcat/conf/logging.properties"

EXPOSE 8082

CMD ["catalina.sh", "run"]