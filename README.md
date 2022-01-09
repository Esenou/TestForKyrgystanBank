# TestForKyrgystanBank
Задача 

Приложение должно быть разработано на Java 8+ (Spring)
Должно быть использовано Hibernate
БД должна работать на PostgreSQL
Иметь логирование  
Для получения корректного ответа, нужно авторизоваться в запросе. Можете реализовать любой вид авторизации на Ваш выбор.
При получении некорректного тело запроса, выдавать корректный Exception в виде XML. 

  *Описание 
  
Написать приложение, которое принимает POST  запрос с JSON телом обрабатывает его и отдает ответ в виде XML;
Приложение принимает запросы на порт 5656;
Приложение должно уметь принимать запросы CHECK и PAY;
При PAY запросе должна быть запись в БД, со всеми указанными параметрами;

ТЕСТ КЕЙСЫ:

1) Авторизация
#запрос SIGNIN
http://localhost:5656/api/auth/signin
cуществуего user cлед результат:
![image](https://user-images.githubusercontent.com/36571539/148672854-7b69feca-f3d8-4470-a882-a217daf0ec2a.png)
не cуществуего user cлед результат:
![image](https://user-images.githubusercontent.com/36571539/148672484-62af1117-c178-4e16-9cf8-32a63d1c60a0.png)

#запрос SIGNUP
http://localhost:5656/api/auth/signup
   при создание нового user cлед результат:
   ![image](https://user-images.githubusercontent.com/36571539/148672524-a2970e19-c7d2-4fee-92c6-b2084ed3a923.png)
   уже cуществуего user cлед результат:
   ![image](https://user-images.githubusercontent.com/36571539/148672552-72916c64-afa4-4764-a44e-d8fa56d55960.png)
   
2) Запросы CHECK и PAY
#запрос CHECK
http://localhost:5656/api/user/check
![image](https://user-images.githubusercontent.com/36571539/148672617-cd2cad60-80f3-4d39-9e69-69424b205da8.png)

при некорректного тело запроса cлед результат:
![image](https://user-images.githubusercontent.com/36571539/148672624-daf6352f-aa90-4ba7-9642-3f32f0011a2b.png)

#запрос PAY
![image](https://user-images.githubusercontent.com/36571539/148672663-acdc1e82-62f6-4bd5-937c-7f5c2f9d92b3.png)
![image](https://user-images.githubusercontent.com/36571539/148672685-424a19a0-a7d3-4384-b7e5-9cb9b30a1977.png)

при не корректного user:
![image](https://user-images.githubusercontent.com/36571539/148672737-006a987f-f869-43e3-a508-b707370b3bdb.png)
при некорректного тело запроса cлед результат:
![image](https://user-images.githubusercontent.com/36571539/148672814-98120860-e911-4575-a81d-75f524416713.png)





