FROM maven:3.8.1-adoptopenjdk-11

RUN apt-get update && sudo apt-get upgrade && sudo apt-get dist-upgrade
RUN apt install gpg