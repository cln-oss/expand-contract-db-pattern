#!/bin/sh

kubectl rollout undo deployment/application --to-revision=1 --namespace custom

