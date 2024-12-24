@echo off
echo Logging into Docker Hub...
docker login -u nidhi999 -p chocopie@1992

echo Building Docker image...
docker build -t nidhi999/frontend_docker_img .
echo Docker image built successfully.

echo Pushing Docker image to Docker Hub...
docker push  nidhi999/frontend_docker_img
echo Docker image pushed successfully.

pause
