# FibonacciChallenge
I used jersy API and jackson API in this REST web services. The project is coding in Java. It is run on Tomcat 8.5.28.
Please go to localhost:8080/Fibonacci/rest/generatefibonacci for further instructions.

## How to use Dockerfile
1. Download Dockerfile and Fibonacci.war and put them into the same folder, eg. /webapp
2. use following command in command line interface to build the container:
```
sudo docker build -t tomcat .
```
3. type following command in command line interface to run the container:
```
sudo docker run -p 8080:8080 tomcat
```
4. use browser to go to localhost:8080/Fibonacci/rest/generatefibonacci for further instructions.
