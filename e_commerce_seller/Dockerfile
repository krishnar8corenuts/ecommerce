
FROM camunda/zeebe-simple-monitor:0.17.0-alpha1 as source

FROM openjdk:11-jre

VOLUME /tmp
ADD target/e_commerce_seller.jar e_commerce_seller.jar

ENTRYPOINT ["java","-jar","e_commerce_seller.jar"]
