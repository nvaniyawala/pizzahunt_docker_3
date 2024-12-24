

### Steps to run this project on docker

1. Open the Microservices POM project in NetBeans and clean build it. POM project contains all the microservices
   - Customer service
   - Delivery service
   - Ordering service
   - Management service
   - Preparation service
   - Payment service
   - and one Common java application contains all the utils.
     All the services are doing their respective tasks.

     If you want to modify/update image of services, go to the folder of respective microservice and run the bat file to build image of that service. the batch file will also push updated image to docker hub.You can also update images of databse as well as frontend on docker hub(if required)

     
2. Now to create containers from updated image by running the batch file "RunDockerContainers.bat" present in folder - "REST_OrderDeliverySys-master_docker_3"

- Services are set up on these ports on docker Although you can modify ports accrodingly. 
  - customer : 9010:8080
  - delivery : 9020:8080
  - management : 9030:8080
  - ordering : 9040:8080
  - payment : 9050:8080
  - preparation : 9060:8080
  - frontend : 9070:8080
  - pizza_app_db : 3506:3306

3. Now start frontend

   -  use the application running on `http://localhost:9070`.

Note: Order of the respective outlets will be assigned to those delivery persons only who are employees of that outlet. So you can see customers' ordres list only after logged into that delivery persons account, whom orders are allocated by their respective outlet branch. `i.e:` You are as a customer ordering food from vesu branch, so you as delivery person can only see assigned orders list, if you are employee of vesu branch and one to whom order is assigned.
