FROM tomcat:9.0-jdk21

COPY target/services-weather-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
COPY logging.properties /usr/local/tomcat/conf/logging.properties

ENV JAVA_OPTS="-Djava.util.logging.config.file=/usr/local/tomcat/conf/logging.properties"

CMD ["catalina.sh", "run"]