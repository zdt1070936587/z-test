FROM java:8
MAINTAINER zdt 1070936587@qq.com
VOLUME /tmp
ADD target/test-0.0.1-SNAPSHOT.jar /test.jar
RUN bash -c 'touch /app.jar'
#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
#EXPOSE 90
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/test.jar"]