FROM openjdk:8-jre-alpine

LABEL author="Tan PTN"
MAINTAINER blu2310@gmai.com

# environment
EXPOSE 8080

# executable ADD @project.artifactId@-@project.version@.jar app.jar
ADD api-gateway.jar app.jar

# run app as user 'booter'
RUN /bin/sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Xmx256m", "-Xss32m", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
