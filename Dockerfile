
FROM openjdk:8-jdk-alpine
WORKDIR /Users/crpavel/Documents/DocumentosMacBookProPavel/Projects/docker/Person

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
#ARG JAR_FILE=build/libs/Person-0.0.1-SNAPSHOT.jar
#RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../*.jar)

ARG DEPENDENCY=/Users/crpavel/Documents/DocumentosMacBookProPavel/Projects/docker/Person/build/libs/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.pavel.test.Person.PersonApplication"]