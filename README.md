# Expand-Contract Pattern applied in Rolling Upgrade Deployment

## Technologies used

* Java 11
* Maven
* Quarkus framework
* Docker
* Kubernetes
* Jib
* HTML/CSS/JS
* Weave Scope visualisation & monitoring tool
* PostgreSQL
* Flyway 

## Techniques used

* [Rolling Updates](https://en.wikipedia.org/wiki/Rolling_release)
* [Expand/Contract pattern](https://martinfowler.com/bliki/ParallelChange.html)
* [Evolutionary Database Design](https://databaserefactoring.com/index.html)


## Architecture

![Application Architecture](./images/architecture.PNG)

## Packaging and running the example in a kubernetes cluster

1. Run a local docker registry (Minikube - `minikube addons enable registry`) and forward registry port:
```
kubectl port-forward --namespace kube-system registry-tdnrl 5000:5000
```
2. Package, build docker image and push it to local registry:
```
./mvnw package
```
3. Deploy Weave Scope monitoring tool:
```
kubectl apply -f "https://cloud.weave.works/k8s/scope.yaml?k8s-version=$(kubectl version | base64 | tr -d '\n')"
``` 

4. Forward Weave Scope port:
```
kubectl port-forward -n weave "$(kubectl get -n weave pod --selector=weave-scope-component=app -o jsonpath='{.items..metadata.name}')" 4040
```

5. Deploy PostgreSQL database pod:
```
kubectl apply -f ./src/main/kubernetes/database.yml
```

6. Deploy application server pods:
```
kubectl apply -f ./src/main/kubernetes/application.yml
```

7. Access the application on `http://<Minikube NodeIP>:30036`
