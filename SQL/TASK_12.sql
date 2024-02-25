/*Объединить все таблицы в одну, при этом сохраняя поля,
 указывающие на прошлую принадлежность к старым таблицам.*/
  
 INSERT INTO pets (id_family,lower_id)
 SELECT id_family,id FROM cats
 UNION SELECT id_family,id FROM dogs
 UNION SELECT id_family,id FROM hamsters;
 
 INSERT INTO pack_animals (id_family,lower_id)
 SELECT id_family,id FROM horses
 UNION SELECT id_family,id FROM donkeys;
 
 INSERT INTO all_animals (type_id,id_lower)
 SELECT type_id, id FROM pets
 UNION SELECT type_id, id FROM pack_animals;
 