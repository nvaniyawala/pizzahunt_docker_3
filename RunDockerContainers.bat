@echo off
echo Creating Docker network: pizza_app_network
docker network create pizza_app_network


echo Starting pizza_app_db container...
docker run --name=pizzadb -p 3506:3306 --network=pizza_app_network -d nidhi999/pizza_app_db_image

echo Starting customer container...
docker run --name=customer -p 9010:8080 -m=400m --network=pizza_app_network -d nidhi999/customer_img

echo Starting delivery container...
docker run --name=delivery -p 9020:8080 -m=400m --network=pizza_app_network -d nidhi999/delivery_img

echo Starting management container...
docker run --name=management -p 9030:8080 -m=400m --network=pizza_app_network -d nidhi999/management_img

echo Starting ordering container...
docker run --name=ordering -p 9040:8080 -m=400m --network=pizza_app_network -d nidhi999/ordering_img

echo Starting payment container...
docker run --name=payment -p 9050:8080 -m=400m --network=pizza_app_network -d nidhi999/payment_img

echo Starting preparation container...
docker run --name=preparation -p 9060:8080 -m=400m --network=pizza_app_network -d nidhi999/preparation_img


echo Starting Docker Compose to start front end container...
docker-compose -f docker-compose.yaml up -d

echo All containers are deployed.
pause
