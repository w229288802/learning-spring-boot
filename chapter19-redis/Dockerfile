FROM centos:7
RUN yum install -y java-1.8.0-openjdk-devel
COPY ./target/chapter19-redis-0.0.1-SNAPSHOT.jar /launch.jar
ENTRYPOINT ["nohup", "java", "-jar", "-XX:+PrintGCDetails"]
CMD ["launch.jar"]