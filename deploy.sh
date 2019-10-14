echo 'deploy .taodoors....'



mvn -Dhttps.protocols=TLSv1.2 install ##build project

mv target/model-provider-1.0.jar deployment/model.jar

cp -r resources/*  deployment/

cd deployment
#mkdir logs
java -jar  model.jar >> logs/server.log

#java -jar  -agentlib:jdwp=transport=dt_socket,server=n,address=193.178.152.194:8005,suspend=y  model.jar
