#!/bin/bash
# Author: Ratan Sunder Parai


# Front-end
cd frontend
npm install
ng build --prod --build-optimizer
docker build -t poc/frontend:simple --no-cache .
cd ..

# Orchestrator
cd orchestrator
mvn clean package
docker build -t poc/orchestrator:simple --no-cache .
cd ..

# CMS
cd cms
mvn clean package
docker build -t poc/cms:simple --no-cache .
cd ..



