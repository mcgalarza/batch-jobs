#/bin/bash


WORKSPACE_PATH="/webapps/redbee/$GIT_JOB_NAME"
NOMBRE_BUILDER="builder-$BUILDER_NAME"

PATH_JOB_WORKSPACE=/webapps/redbee/jenkins/jenkins_home/workspace/"$JENKINS_JOB"
#PATH_JOB_WORKSPACE=/home/redbee/colonseguros/batch-jobs

docker stop "$NOMBRE_BUILDER"
docker rm "$NOMBRE_BUILDER"

docker run --name "$NOMBRE_BUILDER" -v /var/run/docker.sock:/var/run/docker.sock -v "$PATH_JOB_WORKSPACE":/webapps/redbee/"$GIT_JOB_NAME"/ -v "$PATH_JOB_WORKSPACE"/dependencies/volume-$GIT_JOB_NAME/:/root/.gradle  --entrypoint="/webapps/redbee/$GIT_JOB_NAME/integracion/backend/buildBackend.sh"  docker.dev.redbee.io/"$NOMBRE_BUILDER" $WORKSPACE_PATH
