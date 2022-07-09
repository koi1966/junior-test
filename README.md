# junior-test
Used :
https://www.baeldung.com/spring-boot-h2-database
https://www.baeldung.com/mapstruct
https://www.baeldung.com/java-mapstruct-mapping-collections
https://stackoverflow.com/questions/47676369/mapstruct-and-lombok-not-working-together
https://stackoverflow.com/questions/70483299/hibernate-disable-alter-table-to-add-foreign-key-and-disable-alter-table-to-add?noredirect=1&lq=1
https://stackoverflow.com/questions/221379/hibernate-hbm2ddl-auto-update-in-production

https://java-online.ru/hibernate-entities.xhtml
https://function-x.ru/sql_subqueries.html

Создание Spring Security REST API с использованием JWT токена
https://www.youtube.com/watch?v=yRnSUDx3Y8k


Окай, потрібно зробити сервер на наступних технологіях: Java 8, Spring Boot, Spring Data, Apache Maven. 
БД in-memory, скажімо H2. В базі даних зв'язок один до багатьох між User та Article. 
User має такі поля: id, name, age. Article має такі поля: id, text, color (enum). 
На старті аплікації в БД повинно добавлятися 5-10 випадкових Users з Articles. 
Потрібно зробити наступний АРІ:
1/ Дістати всіх Users, в яких age більше за якесь значення
2/ Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а
3/ Дістати унікальні name з Users, в яких більше ніж 3 Articles
4/ Зберегти User
5/ Зберегти Article
6/ Також потрібно зробити наступний тип security: JWT-based
7/ Також потрібно написати 1-2 JUnit тести на будь який з цих методів АРІ (на контролери, на сервіси, на ДАО-рівень). 
Тести повинні бути (!) якісні

Залити цей код на GitHub і написати README як проект запускати
Створити колекцію в Postman або написати запити за допомогою curl тулзи, щоб можна було легко потестувати 
(залити це в README або будь яким іншим відомим способом)

Якісь приклади можна переглянути скажімо в нас аккаунті компанії 
Tech1: https://github.com/tech1-io/tech1-temple-java + 
https://github.com/tech1-io/tech1-skeletons. 
Якщо буде тобі щось корисне не поскупись на зірочку 🙂

SELECT * FROM USERS
WHERE ID IN (SELECT
user_id FROM article WHERE color='ORANGE')


SELECT users.id, users.name, users.age, article.color, article.text 
FROM users INNER JOIN article 
ON users.ID = article.user_id 
where article.color = 'GREEN'

SELECT users.id, users.name, users.age, article.color, article.text
FROM users LEFT OUTER JOIN article
ON users.ID = article.user_id 

SELECT users.id, users.name, users.age, article.color, article.text
FROM users INNER JOIN article
ON users.ID = article.user_id
ORDER BY users.id

select user_id, count(*) as kk
from article
group by  user_id
having count(*) > 3 


select *
from users
where
id in  (select user_id
from article
group by  user_id
having count(*) > 3)


Чтобы сохранить содержимое текстового файла в базу данных.


Создать таблицу 
Используйте java.io.Reader для чтения текстового файла
Используйте JDBC API (PreparedStatement) для выполнения инструкции INSERT.
String sql="INSERT INTO TableName (clobCol) VALUES (?)";
PrepareStatement ps=connection.prepareStatement(sql);
ps.setClob(1,readerObject);


