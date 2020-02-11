# GP-ComponentsPlant

# Overview

Приложение для продвижения продукции фабрики по производству оборудования и аксессуаров для пивоваренной промышленности


# Сущности:

## Client (Клиент)  
Средне- или мелкооптовый торговый агент фабрики

Fields:
* name;
* legalAddress;
* accountNumberOfTheTaxpayer;
* country;
* bankAccount;
* email;
* password;
* discountCoefficient;

Links:
* account; 
* order

## Order (Заказ):  
Набор товаров производимых фабрикой, отгружаемый клиенту по определенной стоимости
        
Fields:
* sum;
* currency;
* dateOfTheOrder;
* wageType(postponement, prepay, barter);
* clientId;
* orderCondition(onApprovement, assembling, readyForShipment, shipped);
* orderID
* goodsMap;

Links:
* client;
* goods

## Goods (Товар):
Единица продукции производимая фабрикой

Fields:
* name;
* type;
* description;
* netCost;
* releaseCost;
* storeID;

Links: 
* order

## Staff(Персонал):
Работники фабрики включая дирекцию

Fields:
* name;
* lastName;
* sex;
* age;
* position;
* accessLevel;
* salary;
* department;
* workExperience;

Links:
* temporariryAbsent

# User Stories

## CP-1 Как "клиент" хочу зарегистрироваться в приложении;

Request:

```
POST /componentsPlant/clients/sign-up
```
```json
{
        "name" : "helg",
        "legalAddress" : "bagrationa street",
        "accountNumberOfTheTaxpayer" : 987654321,
        "country" : "belarus",
        "bankAccount" : 12345678901234567890,
        "email" : "me@client.com",
        "password" : "goodpassword"
}
```
Response: ```201 Created```

```
{
        "id" : 1
}
```

## CP-2 Как "клиент" хочу заказать 10 сувенирных бутылок, 5 бочек и 2 диспенсера;

Request:
```
POST /componentsPlant/clients/1/orders
```
```json
{
        "goodsMap" : {
                  "345" : "10",
                 "232" : "5",
                 "122" : "2"
        },
        "sum" : 16000,
        "currency" : "BYR",
        "clientId" : 1
}
```
Response: ```201 Created```
```json
{
    "orderID" : 123
}
```

## CP-3 Как "клиент" хочу посмотреть историю моих заказов;

Request:

```
GET /componentsPlant/clients/1/
```
Response: ```200 OK```
```json
[
        {
                "orderID" : 1,
                "sum" : 1000,
                "orderCondition" : "SHIPPED"
        },
        {
                "orderID" : 2,
                "sum" : 2500,
                "orderCondition" : "READYFORSHIPMENT"
        }
]
```

## CP-4 Как "администратор" хочу добавить новый товар Бочонок в ассортиментный перечень;

Request:
```
POST /componentsPlant/admin/goods/timberGoods
```
```json
{
    "name" : "barrel",
    "type" : "timberGoods",
    "description" : "forStout",
    "releaseCost" : "1000"
}
```
Response: ```200 OK```
```json
{
    "storeID" : 321
}
```


## CP-5 Как "администратор" хочу посмотреть список заказов "на утверждении";

Request:
```
GET /componentsPlant/admin/ordersForApprove
```
Response: ```200 OK```
```json
[
        {
                "id" : 43,
                "sum" : 1230,
                "condition" : "onApprovement",
                "client" : "def"
        },
        {
                "id" : 32,
                "sum" : 1470,
                "condition" : "onApprovement",
                "client" : "abc"
        }
]
```
## CP-6 Как "администратор" хочу установить стоимость товара "бочонок" 900 рублей;

Request:
```
POST /componentsPlant/admin/goods/timberGoods/321
```
```json
{
    "name" : "barrel",
    "type" : "timberGoods",
    "description" : "forStout",
    "releaseCost" : "900"
}
```
Response: ```200 OK```

```json
{
    "responce" : "Price changed."
}
```

## CP-7 Как "кладовщик" хочу посмотреть список текущих заказов на отгрузку 

Request:
```
GET /componentsPlant/storeKeeper/ordersForAssemble
```
Response: ```200 OK```

```json
[
        {
                "id" : 41,
                "listOfGoods" : [
                {
                        "storeID" : 1,
                        "quantity" : 5
                },
                {
                        "storeID" : 2,
                        "quantity" : 5
                }
                ],
                "condition" : "assembling",
                "client" : "qwer"
        },
        {
                "id" : 23,
                "listOfGoods" : [
                {
                        "storeID" : 3,
                        "quantity" : 5
                },
                {
                        "storeID" : 4,
                        "quantity" : 5
                }
                ],
                "condition" : "assembling",
                "client" : "asdf"
        }
]
```

## CP-8 Как "директор" хочу посмотреть сумму всех сделок по предоплате закрытых за 02.2020;

Request:
```
GET /componentsPlant/director/orders/2020/02/prepaidOrders
```
Response: ```200 OK```

```json
{
    "sum" : 123456
}
```

## CP-9 Как "директор" хочу посмотреть прибыль за февраль по категории стеклянные изделия;

Request:
```
GET /componentsPlant/director/orders/2020/02/glassGoods/profit
```
Response: ```200 OK```

```json
{
    "sum" : 25000
}
```
