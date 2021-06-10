FROM maven:3.8.1-adoptopenjdk-11
MAINTAINER Goudham Suresh

RUN ls -la

RUN apt-get -y update && \
    apt-get -y upgrade && \
    apt-get -y dist-upgrade && \
    apt-get -y install gpg
