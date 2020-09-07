package test;

import com.company.Dog;
import com.company.Pet;
import com.company.Species;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

        HashSet<String> hab = new HashSet<>(){{
            add("gav");
            add("foul");
        }};

        Pet pet1 = new Dog("Bon", 3, 37, hab);
        Pet pet2 = new Dog("Bon", 3, 37, hab);
        Pet pet3 = new Dog("Bon", 3, 37, hab);
        Pet pet4 = new Dog("Bona", 3, 37, hab);

        @Test
        public void testToString () {
            String result = "DOG{nickname='Bon', age=3, trickLevel=37, habits=[foul, gav], can fly:no, number of legs: 4, has fur: yes}";

            assertEquals(result, pet1.toString());
        }
        @Test
        public void testEquals () {
            /*---рефлексивность----*/
            assertTrue(pet1.equals(pet1));
            assertEquals(pet1.hashCode(), pet1.hashCode());

            /*---симетричность---*/
            assertTrue(pet1.equals(pet2));
            assertTrue(pet2.equals(pet1));
            assertEquals(pet1.hashCode(), pet2.hashCode());

            /*---транзитивность----*/
            assertTrue(pet1.equals(pet2));
            assertTrue(pet2.equals(pet3));
            assertTrue(pet1.equals(pet3));

            /*---согласованость----*/
            assertTrue(pet1.equals(pet2));

            /*----сравнение null----*/
            assertFalse(pet1.equals(null));

            /*--false--*/
            assertFalse(pet1.equals(pet4));
        }

}