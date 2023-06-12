FROM openjdk:17
EXPOSE 8089


COPY target/docflow.jar docflow.jar
#ADD target/dskbinokor.jar dskbinokor.jar
#ADD entrypoint.sh entrypoint.sh


ENTRYPOINT ["java","-jar","docflow.jar"]
#ENTRYPOINT ["sh", "/entrypoint.sh"]
