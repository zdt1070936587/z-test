FROM java:8
MAINTAINER sky 296141266@qq.com
VOLUME /tmp
ADD  z-test.jar app.jar
RUN bash -c 'touch /app.jar'
#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 90
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","-c"]
