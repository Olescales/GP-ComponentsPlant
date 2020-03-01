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
* bookingCondition(onApprovement, assembling, readyForShipment, shipped);
* goodsList;

Links:
* client;
* aGoodsDTO

## Goods (Товар):
Единица продукции производимая фабрикой

Fields:
* name;
* type;
* description;
* netCost;
* releaseCost;
* stockNumber;

Links: 
* order

## Staff(Персонал):
Работники фабрики включая дирекцию

Fields:
* fio;
* gender;
* age;
* position;
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
                "bookingCondition" : "SHIPPED"
        },
        {
                "orderID" : 2,
                "sum" : 2500,
                "bookingCondition" : "READYFORSHIPMENT"
        }
]
```

## CP-4 Как "администратор" хочу добавить новый товар Бочонок в ассортиментный перечень;

Request:
```
POST /componentsPlant/admin/aGoodsDTO/timberGoods
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
GET /componentsPlant/admin/orders
```
Response: ```200 OK```
```json
[
        {
                "orderID" : 43,
                "sum" : 1230,
                "bookingCondition" : "ONAPPROVEMENT",
                "clientID" : 1
        },
        {
                "orderID" : 32,
                "sum" : 1470,
                "bookingCondition" : "ONAPPROVEMENT",
                "clientID" : 2
        }
]
```
## CP-6 Как "администратор" хочу установить стоимость товара "бочонок" 900 рублей;

Request:
```
POST /componentsPlant/admin/GoodsDTO/timberGoods/321
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
GET /componentsPlant/storeKeeper/orders
```
Response: ```200 OK```

```json
[
        {
                "orderID" : 41,
                "goodsList" : [ 
                {
                        "Goods" : {
                        "storeID" : 111
                        },
                        "quantity" : 10
                },
                {
                        "Goods" : {
                        "storeID" : 207
                        },
                        "quantity" : 5
                }
                ],
                "bookingCondition" : "ASSEMBLING",
                "clientID" : 41
         },
         {
                "orderID" : 23,
                "goodsList" : [ 
                {
                        "Goods" : {
                        "storeID" : 117
                        },
                        "quantity" : 11
                },
                {
                        "Goods" : {
                        "storeID" : 189
                        },
                        "quantity" : 4
                }
                ],
                "bookingCondition" : "ASSEMBLING",
                "clientID" : 52
         }
]
```

## CP-8 Как "директор" хочу посмотреть сумму всех сделок  за 22 февраля;

Request:
```
POST /componentsPlant/director/orders?orderdate=2020-02-22
```
Response: ```200 OK```

```json
{
    "totalSumOfOrders" : 13385.25
}
```

## CP-9 Как "директор" хочу посмотреть ассортимент стеклянных изделий;

Request:
```
POST /componentsPlant/director/orders?type=glassGoods
```
Response: ```200 OK```

```json
[
{
    "name" : "Bottle",
    "description" : "For liquids"
},
{
    "name" : "Bottle",
    "description" : "For liquids"
}
]
```

## CP-10 Как "клиент" хочу посмотреть ассортимент товаров фабрики 

Request:
```
GET /componentsPlant/clients/2/goods
```
Response: ```200 OK```

```json
[
         {
                "name" : "Bottle",
                "desription" : "For liquids",
                "releasecost" : 48.02
         },
         {
                "name" : "Glass",
                "desription" : "For liquids",
                "releasecost" : 75.89
         },
         {
                "name" : "Barrel",
                "desription" : "For spirits",
                "releasecost" : 1300.58
         },
         {
                "name" : "Dispencer",
                "desription" : "For pouring beer",
                "releasecost" : 3495.36
         }
]
```

## CP-11 Как "директор" хочу посмотреть список всех клиентов фабрики;

Request:
```
GET /componentsPlant/director/clients
```
Response: ```200 OK```

```json

{
     "clientID" : 1,
     "clientID" : 2,
     "clientID" : 3
}

```
