package test;

import com.company.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    String[] hab = {"gav", "foul"};

    Pet pet1 = new Pet(Species.DOG, "Bon", 3, 37, hab);

    Human pMother = new Human("Kristina", "Voytikh", 1988);
    Human pFather = new Human("Sasha", "Melnik", 1979);
    Human pChildren1 = new Human("Child1", "Surn1", 1991);
    Human pChildren2 = new Human("Child2", "Surn2", 1991);
    Human pChildren3 = new Human("Child3", "Surn3", 1992);

    Family family = new Family(pMother, pFather, new Human[] {pChildren1, pChildren2}, pet1);
    Family family1 = new Family(pMother, pFather, new Human[] {pChildren1, pChildren2}, pet1);
    Family family2 = new Family(pMother, pFather, new Human[] {pChildren1, pChildren2}, pet1);
    Family family3 = new Family(pMother, pFather, new Human[] {pChildren1}, pet1);

    @Test
    public void testToString() {
        String result = "Mother: Human{name='Kristina', surname=Voytikh', year=1988, iq=0 schedule = null\n" +
                "Father: Human{name='Sasha', surname=Melnik', year=1979, iq=0 schedule = null\n" +
                "Children: [Human{name='Child1', surname=Surn1', year=1991, iq=0 schedule = null, Human{name='Child2', " +
                "surname=Surn2', year=1991, iq=0 schedule = null]";

        assertEquals(result, family.toString());
    }
    @Test
    public void testDeleteChildByName(){
        /*---if there is child----*/
        int count1 = family.getChildren().length;

        family.deleteChildByName(pChildren1);
        assertEquals((count1 - 1), family.getChildren().length);

        /*---if there is not child---*/
        int count2 = family.getChildren().length;

        family.deleteChildByName(pFather);
        assertEquals(count1, family.getChildren().length);
    }

    @Test
    public void testDeleteChild() {
        /*---if there is index----*/
        String result = "Mother: Human{name='Kristina', surname=Voytikh', year=1988, iq=0 schedule = null\n" +
                "Father: Human{name='Sasha', surname=Melnik', year=1979, iq=0 schedule = null\n" +
                "Children: [Human{name='Child1', surname=Surn1', year=1991, iq=0 schedule = null]";
        family.deleteChild(1);
        assertEquals(result, family.toString());

        /*---if there is not index---*/
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> family.deleteChild(2));;
    }

    @Test
    public void testAddChild() {
        /*---the array +1---*/
        int count1 = family.getChildren().length;
        family.addChild(pChildren3);
        assertEquals(count1 + 1, family.getChildren().length);

        /*---was added right child---*/
        assertEquals(pChildren3, family.getChildren()[family.getChildren().length- 1]);
    }
    @Test
    public void testCountFamily() {
        assertEquals(4, family.countFamily());
    }
    @Test
    public void testEquals() {
        /*---рефлексивность----*/
        assertTrue(family.equals(family));
        assertEquals(family.hashCode(), family.hashCode());

        /*---симетричность---*/
        assertTrue(family.equals(family1));
        assertTrue(family1.equals(family));
        assertEquals(family.hashCode(), family1.hashCode());

        /*---транзитивность----*/
        assertTrue(family.equals(family1));
        assertTrue(family1.equals(family2));
        assertTrue(family.equals(family2));

        /*---согласованость----*/
        assertTrue(family.equals(family1));

        /*----сравнение null----*/
        assertFalse(family.equals(null));

        /*--false--*/
        assertFalse(family.equals(family3));
    }
}