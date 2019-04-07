## Description

## Deployment Steps
1. cd into project root folder
2. Run ``mvn install dockerfile:build`` . This would build the jar file and create a docker image named _alten-api_
3. To run the image use run ``docker run -p 8080 alten-api``