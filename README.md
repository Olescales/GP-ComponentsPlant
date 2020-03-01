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
                  "sum" : 16000,
                  "currency" : "BYR",
                  "orderdate" : "2020-02-22",
                  "wage" : "PREPAID",
                  "condition" : "ONAPROVEMENT",
                  "goods" : 
                  [ {
                  "goodsID" : 1,
                  "quantity" : 10
                  },
                    {
                  "goodsID" : 3,
                  "quantity" : 5
                  },
                    {
                  "goodsID" : 4,
                  "quantity" : 2
                  }
                  ]
}
```
Response: ```201 Created```
```json
{
    "bookingID" : 5
}
```

## CP-3 Как "клиент" хочу посмотреть историю моих заказов;

Request:

```
GET /componentsPlant/clients/2
```
Response: ```200 OK```
```json
[
        {
                "sum" : 13005.80,
                "currency" : "BYN",
                "orderdate" : "2020-02-22",
                "wage" : "POSTPONEMENT",
                "condition" : "SHIPPED",
                "bookingID" : 2
        },
        {
                "sum" : 7230.82,
                "currency" : "BYN",
                "orderdate" : "2020-02-23",
                "wage" : "PREPAID",
                "condition" : "READYFORSHIPMENT",
                "bookingID" : 3
        },
        {
                "sum" : 3735.46,
                "currency" : "BYN",
                "orderdate" : "2020-02-27",
                "wage" : "PREPAID",
                "condition" : "ONAPPROVEMENT",
                "bookingID" : 4
        }
]
```

## CP-4 Как "администратор" хочу добавить новый товар Бочонок в ассортиментный перечень;

Request:
```
POST /componentsPlant/admin/goods
```
```json
{
    "name" : "barrel",
    "type" : "timberGoods",
    "description" : "forStout",
    "netcost" : 750,
    "releasecost" : 1000,
    "stocknumber" : 20001
}
```
Response: ```200 OK```
```json
{
    "goodsID" : 5
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
                "sum" : 3735.46,
                "currency" : "BYN",
                "orderdate" : "2020-02-27",
                "wage" : "PREPAID",
                "condition" : "ONAPPROVEMENT",
                "bookingID" : 4
        }
]
```
## CP-6 Как "администратор" хочу установить стоимость товара "бочонок" 900 рублей;

Request:
```
POST /componentsPlant/admin/goods/321
```
```json
{
    "name" : "barrel",
    "type" : "timberGoods",
    "description" : "forStout",
    "netcost" : 750,
    "releasecost" : 1100,
    "stocknumber" : 20001
}
```
Response: ```200 OK```

```json
{
    "responce" : "The changes are saved."
}
```

## CP-7 Как "кладовщик" хочу посмотреть список заказов утвержденных к сборке 

Request:
```
POST /componentsPlant/storeKeeper/orders
```
Response: ```200 OK```

```json
[
        {
          "orderdate" : "2020-02-27",
          "clientID" : 2,
          "condition" : "ONAPPROVEMENT",
          "bookingID" : 4
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

## CP-11 Как "клиент" хочу удалить мой заказ;

Request:

```
GET /componentsPlant/clients/1/orders/1
```
Response: ```200 OK```
```json
{
                "response" : "Order deleted!"
}
```
