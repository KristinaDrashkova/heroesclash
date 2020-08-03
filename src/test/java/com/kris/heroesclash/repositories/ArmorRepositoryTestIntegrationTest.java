package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Armor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArmorRepositoryTestIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArmorRepository armorRepository;

    @Test
    public void whenFindByNameThenReturnArmor() {
        // given
        Armor testArmor = new Armor("Light", 5);
        entityManager.persist(testArmor);
        entityManager.flush();

        // when
        Armor found = armorRepository.getByName(testArmor.getName());

        //then
        assertEquals(testArmor.getName(), found.getName());
    }

    @Test
    public void whenFindByDefenseThenReturnArmor() {
        // given
        Armor testArmorOne = new Armor("Light", 5);
        Armor testArmorTwo = new Armor("Heavy", 10);
        Armor testArmorThree = new Armor("Magic", 5);
        entityManager.persist(testArmorOne);
        entityManager.persist(testArmorTwo);
        entityManager.persist(testArmorThree);
        entityManager.flush();

        // when
        List<Armor> armors = armorRepository.findByDefense(5);

        // then
        assertEquals(armors.size(), 2);
    }

    @Test(expected = PersistenceException.class)
    public void whenCreateNewArmorWithSameNameThrowException() {
        // given
        Armor testArmorOne = new Armor("Light", 5);
        Armor testArmorTwo = new Armor("Light", 10);
        entityManager.persist(testArmorOne);
        entityManager.flush();

        // when
        entityManager.persist(testArmorTwo);
        entityManager.flush();
    }
}