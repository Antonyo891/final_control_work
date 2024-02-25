# Итоговая контрольная работа. <br>
## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
## Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. <br> Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
**разработать класс в виде конструктора** <br>
## Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека). <br> 
 *:cat > Pets.txt <br> :Cats, Dogs, Hamsters <br>
:cat > Pack_Animals.txt <br> :horses, camels, donkey <br> :cat Pack_Animals.txt Pets.txt > Humans_Friends.txt <br> :cat Humans_Friends.txt <br>
horses, camels, donkey, cats, dogs, hamsters <br>
:mv Humans_Friends.txt Peoples_friends.txt* <br>

2. Создать директорию, переместить файл туда.<br>
*:mkdir Files <br> :mv Peoples_friends.txt /home/antonyo891/final_work/Files/*<br>

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория. <br> *: wget https://dev.mysql.com/get/mysql-apt-config_0.8.29-1_all.deb <br>: sudo dpkg -i mysql-apt-config_0.8.29-1_all.deb <br>: sudo apt install mysql-server -y*  <br>

4. Установить и удалить deb-пакет с помощью dpkg.<br> *: wget http://archive.ubuntu.com/ubuntu/pool/universe/n/nginx/nginx-full_1.18.0-6ubuntu14.4_amd64.deb <br> : sudo dpkg -i nginx-full_1.18.0-6ubuntu14.4_amd64.deb <br> : sudo dpkg -r nginx-full* <br>
5. Выложить историю команд в терминале ubuntu<br> [History](https://github.com/Antonyo891/final_control_work/blob/master/Files/Task_1-5.md "History"). 
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).<br> ![Diagrams](https://github.com/Antonyo891/final_control_work/blob/master/Files/Diagram.png). <br>
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека” <br> CREATE DATABASE IF NOT EXISTS Humans_friends; <br>
8. Создать таблицы с иерархией из диаграммы в БД <br> USE Humans_friends;<br>
CREATE TABLE IF NOT EXISTS Animals_type
(
id INT(2) NOT NULL AUTO_INCREMENT PRIMARY KEY,
type VARCHAR(25) NOT NULL UNIQUE
); <br>CREATE TABLE IF NOT EXISTS Family_animals
(
id INT(2) NOT NULL AUTO_INCREMENT PRIMARY KEY,
family VARCHAR(25) NOT NULL UNIQUE
); <br>CREATE TABLE IF NOT EXISTS Commands
(
id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
command VARCHAR(25) NOT NULL UNIQUE
); <br>INSERT INTO Animals_type (type) VALUES ('pets'),
('pack_animals'); <br>INSERT INTO Family_animals (family) VALUES 
('cat'),('hamster'),('dog'),
('horse'),('camel'),('donkey'); <br>INSERT INTO Commands (command) VALUES 
('voice'),('run'),('jump'),
('sit'),('go_home'),('to_eat'); <br>CREATE TABLE IF NOT EXISTS Cats
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_family INT(3) DEFAULT 1,
id_command INT(3) DEFAULT NULL,
name VARCHAR(25) NOT NULL,
birthdate DATE,
FOREIGN KEY (id_family)
REFERENCES Family_animals(id)
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_command)
REFERENCES Commands(id)
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Hamsters
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_family INT(3) DEFAULT 2,
id_command INT(3) DEFAULT NULL,
name VARCHAR(25) NOT NULL,
birthdate DATE,
FOREIGN KEY (id_family)
REFERENCES Family_animals(id) 
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_command)
REFERENCES Commands(id)
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Dogs
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_family INT(3) DEFAULT 3,
id_command INT(3) DEFAULT NULL,
name VARCHAR(25) NOT NULL,
birthdate DATE,
FOREIGN KEY (id_family)
REFERENCES Family_animals(id) 
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_command)
REFERENCES Commands(id)
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Horses
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_family INT(3) DEFAULT 4,
id_command INT(3) DEFAULT NULL,
name VARCHAR(25) NOT NULL,
birthdate DATE,
FOREIGN KEY (id_family)
REFERENCES Family_animals(id) 
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_command)
REFERENCES Commands(id)
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Camels
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_family INT(3) DEFAULT 5,
id_command INT(3) DEFAULT NULL,
name VARCHAR(25) NOT NULL,
birthdate DATE,
FOREIGN KEY (id_family)
REFERENCES Family_animals(id) 
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_command)
REFERENCES Commands(id)
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Donkeys
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_family INT(3) DEFAULT 6,
id_command INT(3) DEFAULT NULL,
name VARCHAR(25) NOT NULL,
birthdate DATE,
FOREIGN KEY (id_family)
REFERENCES Family_animals(id) 
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_command)
REFERENCES Commands(id)
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Pets
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
type_id INT(1) DEFAULT 1,
id_family INT(3),
lower_id INT NOT NULL,
CONSTRAINT anymals_type
FOREIGN KEY (type_id)
REFERENCES Animals_type(id) 
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS Pack_animals
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
type_id INT(1) DEFAULT 2,
id_family INT(3),
lower_id INT NOT NULL,
CONSTRAINT anymals_type
FOREIGN KEY (type_id)
REFERENCES Animals_type(id) 
ON UPDATE CASCADE ON DELETE CASCADE
); <br>CREATE TABLE IF NOT EXISTS All_animals
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
type_id INT(1),
id_lower INT  #id from table Pets or Pack Animals 
); <br>
9. Заполнить низкоуровневые таблицы именами(животных), командами <br>

которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
    * завести новое животное.
    * определять животное в правильный класс
    * увидеть список команд, которое выполняет животное
    * обучить животное новым командам
    * реализовать навигацию по меню
    * создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆ int переменной̆ на 1 при нажатие “Завести новое животное” 
    * Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. 
    * Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. 
    * Значение считать в ресурсе try, если при заведения животного заполнены все поля.