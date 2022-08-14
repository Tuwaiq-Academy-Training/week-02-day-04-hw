

Create Car dealership management system

Car Class:
ID, carType, price, model, stock

User Class:
ID, username, password, balance, arrayList(cars owned)

Logs Class:
ID, message


----------

Use project Lombok
Use Service layer



- Create end point for adding a Car
- Create end point for adding a user
- Create endpoint to list all cars
- Create endpoint that lists cars by type (Sedan |SUV| Truck)
- Create endpoint that purchase a car by sending car id and the user id and return “car purchased” (check if balance >= car price and subtract that amount from user balance and subtract 1 from the car stock, add that car to the user cars owned list)
- Create endpoint to resell the car that takes the car id and the user id (once the car is sold remove it from cars owned and increment the stock by 1 and add it to the balance again)
- Create endpoint that return the logs
