package com.company;

import com.company.interfaces.HumanCreator;

import java.util.*;

public class Family implements HumanCreator {
    private Woman mother;
    private Man father;
    private List<Human> children;
    private Set<Pet> pet;

    public List<Human> getChildren() {
        return children;
    }

    Random random = new Random();

    public Set<Pet> getPet() {
        return pet;
    }

    public Family(Woman mother, Man father, List<Human> children, Set<Pet> pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
        mother.setFamily(this);
        father.setFamily(this);
    }
    public void addChild(Human child) {
        children.add(child);
    }
    /*----delete by index of array------*/
    public void deleteChild(int index) {
        if(children.size() == 0) {
            throw new IllegalArgumentException("There is not children");
        }
        if(children.size() - 1 < index) {
            throw new ArrayIndexOutOfBoundsException("There is not this index");
        }
       children.remove(index);
    }
    public int countFamily() {
        return 2 + children.size();
    }

    private boolean random(){
        if (random.nextBoolean()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Human bornChild(String[] girlsNames, String[] mansNames) {
        String childName;
        int randomInt = random.nextInt(3);

        int birthday = 2001;

        int childIq = (this.father.getIq() + this.mother.getIq())/2;

        Human child = null;
        if(random()){
            childName = girlsNames[randomInt];
            child = new Woman(childName, this.father.getSurname(), birthday, childIq);
        } else {
            childName = mansNames[randomInt];
            child = new Man(childName, this.father.getSurname(), birthday, childIq);
        }
        this.addChild(child);
        child.setFamily(this);

        return child;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Family))
            return false;
        Family family = (Family)obj;
        if (pet == family.getPet() && children == family.getChildren()) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return children.hashCode();
    }

    public void deleteChildByName(Human person) {
        if(children.size() == 0) {
            throw new IllegalArgumentException("There is not children");
        }
       children.remove(person);
    }
    @Override
    public String toString() {
        return "Mother: " + mother + "\nFather: " + father + "\nChildren: " + Arrays.toString(children.toArray());
    }
    @Override
    protected void finalize() {
        System.out.println("Удаление обьекта семьи!");
    }
}
