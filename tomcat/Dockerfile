# Alpine Linux with OpenJDK JRE
FROM adoptopenjdk:8u222-b10-jre-openj9-0.15.1-bionic
#FROM openjdk:8-jre-alpine
RUN mkdir -p game
# copy WAR into image
ADD code/target /game 
# run application with this command line 
CMD ["java", "-jar", "/game/client.jar"]

