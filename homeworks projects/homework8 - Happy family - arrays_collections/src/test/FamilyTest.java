package test;

import com.company.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
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

    Woman pMother = new Woman("Kristina", "Voytikh", 1988, 0);
    Man pFather = new Man("Sasha", "Melnik", 1979, 0);
    Human pChildren1 = new Woman("Child1", "Surn1", 1991, 0);
    Human pChildren2 = new Woman("Child2", "Surn2", 1991,0);
    Human pChildren3 = new Man("Child3", "Surn3", 1992, 0);

    List<Human> children = new ArrayList<>() {{
        add(pChildren1);
        add(pChildren2);
    }};

    Family family = new Family(pMother, pFather, children, pet);
    Family family1 = new Family(pMother, pFather, children, pet);
    Family family2 = new Family(pMother, pFather, children, pet);
    Family family3 = new Family(pMother, pFather, new ArrayList<>(){{add(pChildren1);}}, pet);

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
        int count1 = family.getChildren().size();

        family.deleteChildByName(pChildren1);
        assertEquals((count1 - 1), family.getChildren().size());

        /*---if there is not child---*/
        int count2 = family.getChildren().size();

        family.deleteChildByName(pFather);
        assertEquals(count2, family.getChildren().size());
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
        int count1 = family.getChildren().size();
        family.addChild(pChildren3);
        assertEquals(count1 + 1, family.getChildren().size());

        /*---was added right child---*/
        assertEquals(pChildren3, family.getChildren().get(family.getChildren().size() - 1));
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