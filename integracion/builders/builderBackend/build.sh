#!/bin/bash

if [ "$1" = "" ]; then
	echo "Ingresar job name"
	exit 0
fi

BUILDER_NAME=$1


NOMBRE_BUILDER="builder-$BUILDER_NAME"

docker stop "$NOMBRE_BUILDER"
docker rm "$NOMBRE_BUILDER"
docker rmi "$NOMBRE_BUILDER"

docker build -t "docker.dev.redbee.io/$NOMBRE_BUILDER" .
