#FROM openjdk:11
#EXPOSE 8085
#
## Define the Nexus URL and repository information
#ARG NEXUS_URL="http://192.168.33.10:8081"
#ARG NEXUS_REPOSITORY="TestDemo"
#ARG ARTIFACT_NAME="deploymentRepo"
#
## Download the latest version of the artifact from Nexus
#RUN LATEST_VERSION=$(curl -s "${NEXUS_URL}/service/rest/v1/search/assets/download?repository=${NEXUS_REPOSITORY}&name=${ARTIFACT_NAME}&maven.extension=jar" | jq -r '.items[0].version') && \
#    wget -O TestDemo-0.0.1-SNAPSHOT.jar "${NEXUS_URL}/repository/${NEXUS_REPOSITORY}/${ARTIFACT_NAME}/${LATEST_VERSION}/${ARTIFACT_NAME}-${LATEST_VERSION}.jar"
#
#ENTRYPOINT ["java", "-jar", "/TestDemo-0.0.1-SNAPSHOT.jar"]


FROM openjdk:11
EXPOSE 8085
ADD target/TestDemo-0.0.1-SNAPSHOT.jar TestDemo.jar
ENTRYPOINT ["java","-jar","/TestDemo.jar"]
