# Spring Boot Deploy Docker Container & MySQL Docker Container 

1. container spring boot (backend-service) port:9999
- create image spring boot </br>
dont forget ! you must clean install your project maven and get it `.jar` from folder target<br/>
and dont forget create `Dockerfile` <br/>
create image backed service spring boot `docker build . -t backend-service`<br/>
- run docker image backend service
`docker run -p 9999:9999 --name backend-service --link mysql-container:mysql -d backend-service `

2. container mysql (mysql-container) port:3306
- create image mysql <br/>
`docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=dbContainer -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6`
<br/>and if success will show `9deeb90cefbb80d4b38b97a18652ad35208ecba8b0afe3391702c65695bf90eb`<br/>
