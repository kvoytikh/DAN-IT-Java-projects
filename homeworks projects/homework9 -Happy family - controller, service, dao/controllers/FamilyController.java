package com.company.controllers;

import com.company.Family;
import com.company.Human;
import com.company.Pet;
import com.company.services.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController{
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {this.familyService = familyService;}
    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return familyService.deleteFamily(index);
    }

    public boolean deleteFamily(Family family) { return familyService.deleteFamily(family);}

    public List<Family> saveFamily(Family family) {
        return familyService.saveFamily(family);
    }
    //---------
    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public int countFamiliesWithMemberNumber(int count) {
        return familyService.countFamiliesWithMemberNumber(count);
    }

    public void createNewFamily(Human mother, Human father) {
        familyService.createNewFamily(mother, father);
    }

    public Family bornChild(Family family, String girlsName, String boysName) { return familyService.bornChild(family, girlsName, boysName); }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int id) {
        return familyService.getFamilyById(id);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}
