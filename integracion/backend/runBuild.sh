#!/bin/bash

JENKINS_JOB_PARAM=$2

export GIT_JOB_NAME="batch-jobs"
export JENKINS_JOB=$JENKINS_JOB_PARAM
export BUILDER_NAME="batch_jobs"

cd $1/integracion/backend

bash run.sh
