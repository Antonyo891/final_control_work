/*Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года,
 но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать 
 возраст животных в новой таблице*/

 CREATE TABLE young_animals
 SELECT *, (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))
 ) as month FROM cats 
 WHERE (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))) 
 between 12 and 36
 union 
 SELECT *, (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))
 ) as month FROM dogs 
 WHERE (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))) 
 between 12 and 36
 union 
 SELECT *, (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))
 ) as month FROM hamsters
 WHERE (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))) 
 between 12 and 36
 union 
 SELECT *, (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))
 ) as month FROM horses 
 WHERE (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))) 
 between 12 and 36
 union 
 SELECT *, (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))
 ) as month FROM donkeys 
 WHERE (
 select PERIOD_DIFF(DATE_FORMAT(NOW(),'%y%m'),DATE_FORMAT(birthdate,'%y%m'))) 
 between 12 and 36;