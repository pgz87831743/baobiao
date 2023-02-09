FROM hub.c.163.com/library/java:8-alpine
COPY ApplicationStart.jar tieba.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
VOLUME /usr/local/srtp/logs:/logs/
EXPOSE 8081
ENTRYPOINT ["java","-Xms256m","-Xmx512m","-jar","tieba.jar"]