package com.company.services;

import com.company.Family;
import com.company.Human;
import com.company.Man;
import com.company.Pet;
import com.company.Woman;
import com.company.dao.CollectionFamilyDao;

import java.util.*;

public class FamilyService extends CollectionFamilyDao{
    Random random = new Random();
    CollectionFamilyDao familyDao;

    public FamilyService(CollectionFamilyDao familyDao) {this.familyDao = familyDao;}
        @Override
        public List<Family> getAllFamilies() {
            return familyDao.getAllFamilies();
        }

        @Override
        public Family getFamilyByIndex(int index) {
            if(index > familyList.size() - 1 || index < 0) return null;
            return familyList.get(index);
        }

        @Override
        public boolean deleteFamily(int index) {
            if(index > familyList.size() - 1 || index < 0) return false;
            return familyList.remove(familyList.get(index));
        }

        @Override
        public boolean deleteFamily(Family family) {
            return familyList.remove(family);
        }

        @Override
        public List<Family> saveFamily(Family family) {
            for (Family value : familyList) {
                if (value.equals(family)) return familyList;
            }
            familyList.add(family);
            return familyList;
        }

        @Override
        public void displayAllFamilies() {
            System.out.println(familyList);
        }

        @Override
        public List<Family> getFamiliesBiggerThan(int count) {
            List<Family> newArray = new ArrayList<>();
            for(Family family : familyList) {
                if(family.countFamily() > count) newArray.add(family);//count method
            }
            return newArray;
        }

        @Override
        public List<Family> getFamiliesLessThan(int count) {
            List<Family> newArray = new ArrayList<>();
            for(Family family : familyList) {
                if(family.countFamily() < count) newArray.add(family);//count method
            }
            return newArray;
        }

        @Override
        public int countFamiliesWithMemberNumber(int count) {
            int countFamily = 0;
            for(Family family : familyList) {
                if(family.countFamily() == count) countFamily++; //count method
            }
            return countFamily;
        }

        @Override
        public void createNewFamily(Human mother, Human father) {
            Family family = new Family((Woman)mother, (Man)father);
            saveFamily(family);
        }

        @Override
        public Family bornChild(Family family, String girlsName, String boysName) {
            int randomInt = random.nextInt(3);

            int birthday = 2001;

            int childIq = (family.getFather().getIq() + family.getMother().getIq())/2;

            Human child = null;
            if(randomInt == 1){
                child = new Woman(girlsName, family.getFather().getSurname(), birthday, childIq);
            } else {
                child = new Man(boysName, family.getFather().getSurname(), birthday, childIq);
            }
            family.addChild(child);//method

            return family;
        }

        @Override
        public Family adoptChild(Family family, Human child) {
            int childIq = (family.getFather().getIq() + family.getMother().getIq())/2;
            family.addChild(child); //method

            return family;        }

        @Override
        public void deleteAllChildrenOlderThan(int age) {
            for(Family family : familyList) {
                for(Human child : family.getChildren()) {
                    if((Calendar.YEAR - child.getYear()) > age) {
                        family.getChildren().remove(child);
                    }
                }
            }
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