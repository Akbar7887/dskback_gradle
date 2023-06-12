FROM openjdk:17
EXPOSE 8089


COPY docflow/build/libs/docflow-0.0.1-SNAPSHOT-plain.jar docflow.jar


ENTRYPOINT ["java","-jar","docflow.jar"]
#ENTRYPOINT ["sh", "/entrypoint.sh"]
