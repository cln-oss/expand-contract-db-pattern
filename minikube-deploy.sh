#!/bin/sh

# 1. Package, build docker image and push it to local registry

./mvnw clean package

# 2. Deploy database, application and ingress into the Kubernetes cluster

kubectl apply -f ./src/main/kubernetes/database.yml
kubectl apply -f ./src/main/kubernetes/application.yml
kubectl apply -f ./src/main/kubernetes/ingress.yml


