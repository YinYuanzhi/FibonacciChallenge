FROM java
MAINTAINER yyz

RUN curl -O http://archive.apache.org/dist/tomcat/tomcat-8/v8.5.28/bin/apache-tomcat-8.5.28.tar.gz
RUN tar xzf apache-tomcat-8.5.28.tar.gz
ADD Fibonacci.war apache-tomcat-8.5.28/webapps/
CMD apache-tomcat-8.5.28/bin/startup.sh && tail -f apache-tomcat-8.5.28/logs/catalina.out
EXPOSE 8080