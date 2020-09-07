package test;

import com.company.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static javax.swing.UIManager.put;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Map<String, String> schedule = new LinkedHashMap<>() {{
        put(DayOfWeek.MONDAY.name(), "play");
        put(DayOfWeek.TUESDAY.name(), "me");
    }};

    HashSet<String> hab = new HashSet<>(){{
        add("gav");
        add("foul");
    }};


    Pet pet1 = new Dog("Bon", 3, 37, hab);
    Pet pet2 = new Fish("Nemo", 3, 37, hab);
    Set<Pet> pet = new HashSet<>() {{
        add(pet1);
        add(pet2);
    }};

    Woman pMother = new Woman("Kristina", "Voytikh", 1988, 17);
    Man pFather = new Man("Sasha", "Melnik", 1979, 23);
    Human pChildren1 = new Human("Child1", "Surn1", 1991, 23);
    Human pChildren2 = new Human("Child2", "Surn2", 1991, 78);

    List<Human> children = new ArrayList<>() {{
        add(pChildren1);
        add(pChildren2);
    }};

    Family family = new Family(pMother, pFather, children, pet);
    Human person = new Human("Vlada", "Lila", 2001, 19, family, schedule);
    Human person1 = new Human("Vlada", "Lila", 2001, 19, family, schedule);
    Human person2 = new Human("Vlada", "Lila", 2001, 19, family, schedule);
    Human person3 = new Human("Vlad", "Lil", 2001, 19, family, schedule);

    @Test
    public void testToString() {
        String result = "Human{name='Vlada', surname=Lila', year=2001, iq=19 schedule = {MONDAY=play, TUESDAY=me}";

        assertEquals(result, person.toString());
    }
    @Test
    public void testEquals() {
        /*---рефлексивность----*/
        assertTrue(person.equals(person));
        assertEquals(person.hashCode(), person.hashCode());

        /*---симетричность---*/
        assertTrue(person.equals(person1));
        assertTrue(person1.equals(person));
        assertEquals(person.hashCode(), person1.hashCode());

        /*---транзитивность----*/
        assertTrue(person.equals(person1));
        assertTrue(person1.equals(person2));
        assertTrue(person.equals(person2));

        /*---согласованость----*/
        assertTrue(person.equals(person1));

        /*----сравнение null----*/
        assertFalse(person.equals(null));

        /*--false--*/
        assertFalse(person.equals(person3));
    }

}