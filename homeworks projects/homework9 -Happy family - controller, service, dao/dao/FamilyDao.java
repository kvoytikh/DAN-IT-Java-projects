package com.company.dao;

import com.company.Family;
import com.company.Human;
import com.company.Pet;

import java.util.List;
import java.util.Set;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    List<Family> saveFamily(Family family);

    void displayAllFamilies();
    List<Family> getFamiliesBiggerThan(int count);
    List<Family> getFamiliesLessThan(int count);
    int countFamiliesWithMemberNumber(int count);
    void createNewFamily(Human mother, Human father);
    Family bornChild(Family family, String girlsName, String boysName);
    Family adoptChild(Family family, Human child);
    void deleteAllChildrenOlderThan(int age);
    int count();
    Family getFamilyById(int id);
    Set<Pet> getPets(int index);
    void addPet(int index, Pet pet);

}
