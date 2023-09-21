FROM adoptopenjdk:11-jdk-hotspot AS arm_builder

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew && ./gradlew build

FROM adoptopenjdk:11-jre-hotspot AS arm_runtime

WORKDIR /app

COPY --from=arm_builder /app/build/libs/emart-0.0.1-SNAPSHOT.jar app.jar

ENV PROFILE=dev

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
