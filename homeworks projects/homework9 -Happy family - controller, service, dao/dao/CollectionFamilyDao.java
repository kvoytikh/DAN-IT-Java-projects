package com.company.dao;

import com.company.Family;
import com.company.Human;
import com.company.Man;
import com.company.Pet;
import com.company.Woman;

import java.util.*;

public class CollectionFamilyDao implements FamilyDao {
    public List<Family> familyList = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return familyList.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        return familyList.remove(familyList.get(index));
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyList.remove(family);
    }

    @Override
    public List<Family> saveFamily(Family family) {
        return familyList;
    }

    @Override
    public void displayAllFamilies(){}

    @Override
    public List<Family> getFamiliesBiggerThan(int count) {
        return null;
    }

    @Override
    public List<Family> getFamiliesLessThan(int count) {
        return null;
    }

    @Override
    public int countFamiliesWithMemberNumber(int count) {
        return 0;
    }

    @Override
    public void createNewFamily(Human mother, Human father) {
        Family family = new Family((Woman)mother, (Man)father);
        saveFamily(family);
    }

    @Override
    public Family bornChild(Family family, String girlsName, String boysName) {
        return family;
    }


    @Override
    public Family adoptChild(Family family, Human child) {
        return family;
    }

    @Override
    public void deleteAllChildrenOlderThan(int age) {
    }

    @Override
    public int count() {
        return familyList.size();
    }

    @Override
    public Family getFamilyById(int id) {
        return familyList.get(id);
    }

    @Override
    public Set<Pet> getPets(int index) {
        return familyList.get(index).getPet();
    }

    @Override
    public void addPet(int index, Pet pet) {
        familyList.get(index).getPet().add(pet);
    }
}
