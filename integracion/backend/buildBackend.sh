#!/bin/bash

echo "WORKSPACE_PATH: $1"

if [ "$1" = "" ]; then
	echo "Path al workspace incorrecto"
	exit 0
fi

WORKSPACE_PATH=$1

cd $WORKSPACE_PATH

cd src/main/resources/

cd $WORKSPACE_PATH

source $HOME/.sdkman/bin/sdkman-init.sh

pwd

echo "grails clean"
grails clean

echo "gradle clean"
gradle clean

echo "gradle wsdl2java"
gradle wsdl2java

echo "grails war"
grails war


if [ $? -ne 0 ]; 
   then echo "ERROR EN BUILD DE BACKEND"
   exit 1
fi

