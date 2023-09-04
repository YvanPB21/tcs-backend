# Use the Centos image
FROM centos

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
ENV PATH=$PATH:/usr/lib/jvm/java-1.8.0-openjdk/bin

RUN cd /etc/yum.repos.d/
RUN sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
RUN sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
RUN yum update -y

RUN yum install -y java-1.8.0-openjdk-devel && \
    yum clean all && \
    rm -rf /var/cache/yum

RUN mkdir /app
WORKDIR /app

COPY target/tata-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]