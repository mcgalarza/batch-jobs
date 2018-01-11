#!/bin/bash

docker stop batch_jobs
docker rm batch_jobs
docker rmi docker.dev.redbee.io/batch_jobs
