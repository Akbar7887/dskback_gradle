FROM openjdk:17
EXPOSE 8089


COPY docflow/build/libs/docflow-0.0.1-SNAPSHOT-plain.jar docflow.jar
COPY eureka_service/build/libs/eureka_service-0.0.1-SNAPSHOT.jar.jar eureka_service.jar
COPY api_gateway/build/libs/api_gateway-0.0.1-SNAPSHOT.jar api_gateway.jar
#ADD target/dskbinokor.jar dskbinokor.jar
#ADD entrypoint.sh entrypoint.sh


ENTRYPOINT ["java","-jar","docflow.jar"]
ENTRYPOINT ["java","-jar","eureka_service.jar"]
ENTRYPOINT ["java","-jar","api_gateway.jar"]
#ENTRYPOINT ["sh", "/entrypoint.sh"]
