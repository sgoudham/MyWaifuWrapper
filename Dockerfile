FROM maven:3.8.1-adoptopenjdk-11

COPY ~/.m2/settings.xml /root/.m2/settings.xml

RUN apt-get update && sudo apt-get upgrade && sudo apt-get dist-upgrade
RUN apt install gpg