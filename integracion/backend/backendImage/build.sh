#!/bin/bash

NOMBRE_IMAGEN="batch_jobs"
VERSION_NUMBER=$1
VERSION_BKP='prev.version'
JENKINS_JOB_BUILD=$2
JAR_NAME="batch-jobs-0.0.1-SNAPSHOT.jar"

cd /var/jenkins_home/workspace/$JENKINS_JOB_BUILD/integracion/backend/backendImage/

cp -rf /var/jenkins_home/workspace/$JENKINS_JOB_BUILD/build/libs/$JAR_NAME .

docker stop $NOMBRE_IMAGEN
docker rm $NOMBRE_IMAGEN

if [ "$1" = "latest" ]; then
	echo "No se genera version previa"
else
	echo "Se genera version previa"
	docker tag "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER" "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_BKP"
	docker push "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_BKP"
fi


echo "docker rmi docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
docker rmi "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"

echo "docker build docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
docker build -t "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER" .
docker push "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
