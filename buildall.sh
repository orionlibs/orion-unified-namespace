#!/bin/bash
export MAVEN_OPTS=-Xmx2048m
cd /c/workspaces/open-source-projects/unified-namespace/core
mvn -s C:/Users/neo/.m2/settingsOrion.xml clean install
cd /c/workspaces/open-source-projects/unified-namespace/utilities
mvn -s C:/Users/neo/.m2/settingsOrion.xml clean install
cd /c/workspaces/open-source-projects/unified-namespace/api
mvn -s C:/Users/neo/.m2/settingsOrion.xml clean install
cd /c/workspaces/open-source-projects/unified-namespace/uns-app-backend
mvn -s C:/Users/neo/.m2/settingsOrion.xml clean install