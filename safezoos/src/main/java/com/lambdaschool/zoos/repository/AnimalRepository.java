package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.JustTheCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "SELECT a.animaltype, count(z.zooid) as justthecount FROM animal a JOIN zoo z on a.zooid = z.zooid GROUP BY a.animaltype", nativeQuery = true)
    ArrayList<JustTheCount> getAnimalCount();

}
