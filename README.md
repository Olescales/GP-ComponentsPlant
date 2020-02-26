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
* aGoods

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
POST /componentsPlant/admin/aGoods/timberGoods
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
POST /componentsPlant/admin/aGoods/timberGoods/321
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

## CP-8 Как "директор" хочу посмотреть сумму всех сделок по предоплате за февраль;

Request:
```
GET /componentsPlant/director/orders/prepaidOrders
```
Response: ```200 OK```

```json
{
    "totalSumOfOrders" : 123456
}
```

## CP-9 Как "директор" хочу посмотреть прибыль за февраль по категории стеклянные изделия;

Request:
```
GET /componentsPlant/director/orders/prepaidOrders/{glassGoods}
```
Response: ```200 OK```

```json
{
    "totalSumOfProfit" : 25000
}
```

## CP-10 Как "кладовщик" хочу посмотреть список всех собранных заказов 

Request:
```
GET /componentsPlant/storeKeeper/orders
```
Response: ```200 OK```

```json
[
        {
                "orderID" : 1,
                "goodsList" : [ 
                {
                        "Goods" : {
                        "stockNumber" : 10000
                        },
                        "quantity" : 3
                },
                {
                        "Goods" : {
                         "stockNumber": 30000
                        },
                        "quantity" : 5
                }
                ],
                "bookingCondition" : "READYFORSHIPMENT",
                "clientID" : 1
         },
         {
                "orderID" : 2,
                "goodsList" : [ 
                {
                        "Goods" : {
                        "stockNumber" : 10001
                        },
                        "quantity" : 7
                }
                ],
                "bookingCondition" : "READYFORSHIPMENT",
                "clientID" : 1
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