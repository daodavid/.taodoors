echo '.....deploy TAODOORS'
mvn clean install
mv /target/model-provider-1.0.jar /deployment/model.jar
cd deployment
java -cp  -Xdebug -Xrunjdwp:transport=dt_socket,server=n,address=DEVPC-09.haemimont.com:8000,suspend=y  model.jar