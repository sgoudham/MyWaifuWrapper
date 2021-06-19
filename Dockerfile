FROM maven:3.8.1-adoptopenjdk-16
MAINTAINER Goudham Suresh

RUN apt-get update && apt-get install -y \
    gpg
