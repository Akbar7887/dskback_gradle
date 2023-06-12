FROM openjdk:17
EXPOSE 8083


COPY api_gateway/build/libs/api_gateway-0.0.1-SNAPSHOT.jar api_gateway.jar
#ADD target/dskbinokor.jar dskbinokor.jar
#ADD entrypoint.sh entrypoint.sh


ENTRYPOINT ["java","-jar","api_gateway.jar"]
#ENTRYPOINT ["sh", "/entrypoint.sh"]
