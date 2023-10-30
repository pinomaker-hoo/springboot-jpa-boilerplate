ARG serverType=dev

FROM base AS branch-version-dev
ENV dSpring=dev

FROM base AS branch-version-stg
ENV dSpring=stg

FROM base AS branch-version-prd
ENV dSpring=prd

FROM adoptopenjdk:11-jdk-hotspot AS arm_builder

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew && ./gradlew build

FROM adoptopenjdk:11-jre-hotspot AS arm_runtime

WORKDIR /app

COPY --from=arm_builder /app/build/libs/emart-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV TZ=Asia/Seoul
ENV JAVA_OPTS " $JAVA_OPTS -Ddd.service=app-eapp -Ddd.env=$dSpring-app"
ENV JAVA_OPTS " $JAVA_OPTS -Dspring.profiles.active=$dSpring"
ENV JAVA_OPTS " $JAVA_OPTS -Dfile.encoding=UTF-8"

ENTRYPOINT ["java", "-jar", "app.jar"]

