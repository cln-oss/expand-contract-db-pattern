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

1. Start `minikube` with the following addons:
```
minikube start --addons registry, ingress
```

2. Forward the image registry port:
```
kubectl port-forward --namespace kube-system registry-<id> 5000:5000
```

2. Run the deployment script:
```
./minikube-deploy.sh
```

3. Access the application URL by:
```
minikube service app-service --url -n custom
```

4. Access WeaveScope on `http://localhost:4040`
