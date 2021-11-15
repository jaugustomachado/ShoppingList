<h1>BackEnd Project - REST API - SPRINGBOOT with database (SQL) - Product shopping list system (Sales)</h1>

Status:Concluded

Implementation of an API that manages a database with the necessary operations of a CRUD system (create, read, update, delete) to identify items and classify them according to their type (Ex: chocolate bar-food). In addition to the database, the API asks the user for the priced items and returns the value of each one corrected with the respective tax, as well as the total amount of taxes and the total sum of the shopping list.

Technologies needed to run the program:
JAVA / SQL (DATABASE)

Getting Started:

Create the database using MySQL -> In the script there is already the command for inputing the items that could be classified as food, book and medical products that were presented in the prospect.
Link to access the script : https://github.com/jaugustomachado/LiferayChallenge/blob/master/src/main/resources/scriptSQLDatabase.sql

Run the java program -> Link of the APP Class: https://github.com/jaugustomachado/LiferayChallenge/blob/master/src/main/java/augusto/sales/SalesApplication.java

Insert the items of the list as in the model : "1 book at 12.49" , to close the list just press enter at the end.

Ps: if the user insert an item different from the model the program will run the correct ones and will inform that the last item was inserted incorrectly.

Ps:The program considers an item as food, book or medical products only if the item is previously entered in the database with the respective classification indicating that. Otherwise, if an item isn't registered in the database or if its classification isn't food, book or medical products, the item will be taxed with the basic sale tax as the instructions demanded.

Ps:Regarding the import duty tax, only items that have in their descriptions the word "imported", will be taxed with it.

The entire list will be showed right after its closing, each line will contains the quantity ordered, description, corrected price multiplied by the quantity and at the end it will show the  total of taxes and the total of the purchase as well.

Example of input:

1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Example of Output:

Output 1:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Features of the springboot aplication (ItemsDatabaseManagement):LINK -> https://github.com/jaugustomachado/LiferayChallenge/tree/master/src/main/java/augusto/sales/ItemsDatabaseManagement

[X] - Search item by id
[X] - Search an item by description
[X] - Save a new item
[X] - Update an item
[X] - Delete an item

Author
 
* **José Augusto Machado Omena**: @jaugustomachado (https://github.com/jaugustomachado)
 
