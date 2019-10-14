echo 'deploy .taodoors....'



mvn -Dhttps.protocols=TLSv1.2 install ##build project

mv target/model-provider-1.0.jar deployment/model.jar

cp -r resources/*  deployment/

cd deployment
mkdir logs
#java -cp  -Xdebug -Xrunjdwp:transport=dt_socket,server=n,address=DEVPC-09.haemimont.com:8000,suspend=y  model.jar
java -jar  model.jar >> logs/server.log