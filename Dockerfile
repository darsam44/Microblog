FROM openjdk:18
ADD target/blog-spring-boot.jar blog-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "blog-spring-boot.jar"]