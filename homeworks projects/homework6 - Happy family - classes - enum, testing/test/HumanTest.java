package test;

import com.company.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    String[][] sch =   {{DayOfWeek.MONDAY.name(), "play"},
            {DayOfWeek.TUESDAY.name(), "me"}};
    String[] hab = {"gav", "foul"};

    Pet pet1 = new Pet(Species.DOG, "Bon", 3, 37, hab);

    Human pMother = new Human("Kristina", "Voytikh", 1988);
    Human pFather = new Human("Sasha", "Melnik", 1979);
    Human pChildren1 = new Human("Child1", "Surn1", 1991);
    Human pChildren2 = new Human("Child2", "Surn2", 1991);

    Family family = new Family(pMother, pFather, new Human[] {pChildren1, pChildren2}, pet1);
    Human person = new Human("Vlada", "Lila", 2001, 19, family, sch);
    Human person1 = new Human("Vlada", "Lila", 2001, 19, family, sch);
    Human person2 = new Human("Vlada", "Lila", 2001, 19, family, sch);
    Human person3 = new Human("Vlad", "Lil", 2001, 19, family, sch);

    @Test
    public void testToString() {
        String result = "Human{name='Vlada', surname=Lila', year=2001, iq=19 schedule = [[MONDAY, play], [TUESDAY, me]]";

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