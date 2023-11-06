FROM adoptopenjdk:11-jdk-hotspot as builder

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew && ./gradlew build

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY --from=builder /app/build/libs/app.jar app.jar

EXPOSE 8080

ENV dSpring=dev
ENV TZ=Asia/Seoul
ENV JAVA_OPTS " $JAVA_OPTS -Ddd.service=app-eapp -Ddd.env=$dSpring-app"
ENV JAVA_OPTS " $JAVA_OPTS -Dspring.profiles.active=$dSpring"
ENV JAVA_OPTS " $JAVA_OPTS -Dfile.encoding=UTF-8"

ENTRYPOINT ["java", "-jar", "app.jar"]

