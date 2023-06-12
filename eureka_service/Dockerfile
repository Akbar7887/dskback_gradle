FROM openjdk:17
EXPOSE 8089


COPY eureka_service/build/libs/eureka_service-0.0.1-SNAPSHOT.jar eureka_service.jar


ENTRYPOINT ["java","-jar","eureka_service.jar"]
#ENTRYPOINT ["sh", "/entrypoint.sh"]
