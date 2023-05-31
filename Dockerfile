FROM openjdk:11.0.16-oraclelinux7
ADD target/vcs-0.0.1-SNAPSHOT.jar vnesports
ENTRYPOINT ["java","-jar","vnesports"]
EXPOSE 8080