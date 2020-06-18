# 报刊订阅管理系统

## 概述

### 使用技术

该系统使用java编写，数据库采用SQLServer 2014。

### 模块介绍

该软件分为三大模块：分别为登录注册模块，用户操作模块和管理员操作模块。登录模块部分又分为管理员登录和用户登录。管理员不能注册，只有用户才可以注册。

在登录注册模块，用户可以点击注册按钮进入到用户注册页面注册页面，输入自己的相关信息进行注册。若输入的信息符合要求则注册成功，则做出相应的提示。用户注册之后即可进行用户的登录操作，进行用户的登录需要用户输入账号和密码，验证正确之后方可正常登录，进入到用户的操作也页面。管理员的登录页面和用户的登录页面大同小异，都需要输入正确的账号和密码方可进入相应的操作界面进行相关的操作。

在用户的操作模块，又可以分为三个部分，分别为用户的个人信息，订阅报刊，查看报刊三个部分。在个人信息部分，用户可以在界面上看到自己的个人信息，也可以对个人信息进行修改。订阅报刊界面会显示近期的报刊，用户可以根据显示出来的报刊进行报刊的订阅，订阅的报刊将录入到数据库中。查看订单部分则可以查看自己曾经订阅过的订单，订单上会显示相应的报刊的订阅份数和订阅价格。

管理员操作模块则有四个功能模块。分别为录入报社，录入报刊，查询功能和统计功能。管理员在需要添加新的报社的时候可以打开录入报社的页面进行报社的录入工作。当一个报社需要添加报刊的时候，管理员可以在录入报刊的页面进行报刊的录入操作。管理员同时也可以查看相关的信息，在查询功能界面，可以分为三个方面进行查询，分别为按用户查询，按报社查询和按报刊查询。统计功能也是按这三部分进行统计，当选择按用户来进行统计时，可以统计出每个用户订阅的订单和订阅份数以及订阅的总价格。按报刊进行统计可以统计出该某一种报刊销售的情况，包括销售的份数和销售总价格。按报社进行统计可以统计各个报社销售的情况，统计出该报社的报刊销售情况以及销售的份数。

### 界面一览

![注册页面](https://github.com/HuangBinTao/News/tree/master/img/注册界面.png)

![](.https://github.com/HuangBinTao/News/tree/master/img\用户订阅报刊.png)

![](https://github.com/HuangBinTao/News/tree/master/img\用户登录界面.png)

![](https://github.com/HuangBinTao/News/tree/master\img\用户操作界面.png)

![](https://github.com/HuangBinTao/News/tree/master\img\统计功能.png)

![](https://github.com/HuangBinTao/News/tree/master\img\双登录按钮页面.png)

![](https://github.com/HuangBinTao/News/tree/master\img\录入报社.png)

![](https://github.com/HuangBinTao/News/tree/master\img\后台登录页面.png)

![](https://github.com/HuangBinTao/News/tree/master\img\管理员录入报刊.png)

![](https://github.com/HuangBinTao/News/tree/master\img\管理员操作多按钮界面.png)

![](https://github.com/HuangBinTao/News/tree/master\img\查询功能3.png)

![](https://github.com/HuangBinTao/News/tree/master\img\查询功能2.png)

![](https://github.com/HuangBinTao/News/tree/master\img\查询功能1.png)

![](https://github.com/HuangBinTao/News/tree/master\img\查询功能.png)
