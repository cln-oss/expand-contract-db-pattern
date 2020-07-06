#!/bin/sh

# 1. Package, build docker image and push it to local registry

./mvnw clean package

# 2. Deploy database, application and ingress into the Kubernetes cluster

kubectl apply -f ./src/main/kubernetes/database.yml
kubectl apply -f ./src/main/kubernetes/application.yml
kubectl apply -f ./src/main/kubernetes/ingress.yml

# 3. Deploy WeaveScope

kubectl apply -f "https://cloud.weave.works/k8s/scope.yaml?k8s-version=$(kubectl version | base64 | tr -d '\n')"

# 4. Run WeaveScope

kubectl port-forward -n weave "$(kubectl get -n weave pod --selector=weave-scope-component=app -o jsonpath='{.items..metadata.name}')" 4040



