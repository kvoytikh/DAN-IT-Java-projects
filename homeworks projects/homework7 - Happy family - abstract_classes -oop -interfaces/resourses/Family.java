package com.company;

import com.company.interfaces.HumanCreator;

import java.util.Arrays;
import java.util.Random;

public class Family implements HumanCreator {
    private Woman mother;
    private Man father;
    private Human[] children;
    private Pet pet;

    public Human[] getChildren() {
        return children;
    }
    Random random = new Random();
    public Pet getPet() {
        return pet;
    }

    public Family(Woman mother, Man father, Human[] children, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
        mother.setFamily(this);
        father.setFamily(this);
    }
    public void addChild(Human child) {
        Human[] newArrayOfChildren = Arrays.copyOf(children, children.length + 1);
        newArrayOfChildren[newArrayOfChildren.length - 1] = child;

        for (Human iChl : newArrayOfChildren) {
            iChl.setFamily(this);
        }
        this.children = newArrayOfChildren;
    }
    /*----delete by index of array------*/
    public void deleteChild(int index) {
        if(children.length == 0) {
            throw new IllegalArgumentException("There is not children");
        }
        if(children.length - 1 < index) {
            throw new ArrayIndexOutOfBoundsException("There is not this index");
        }
        Human[] newArrayOfChildren = Arrays.copyOf(children, children.length - 1);

        System.arraycopy(children, 0, newArrayOfChildren, 0, index);
        System.arraycopy(children, index + 1, newArrayOfChildren, index, children.length - index - 1);

        this.children = newArrayOfChildren;
    }
    public int countFamily() {
        return 2 + children.length;
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
        if (pet == family.getPet()) {
            Human[] chld = family.getChildren();
            
            for (int i = 0; i < children.length; i++) {
                if (!(children[i] == chld[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return children.hashCode();
    }

    public void deleteChildByName(Human person) {
        if(children.length == 0) {
            throw new IllegalArgumentException("There is not children");
        }
        Human[] newArrayOfChildren = Arrays.copyOf(children, children.length - 1);

        int index = 0;
        for(int i = 0; i < children.length; i++) {
            if((children[i].equals(person)) && (children[i].hashCode() == person.hashCode())) {
                index = i;
            }
        }

        System.arraycopy(children, 0, newArrayOfChildren, 0, index);
        System.arraycopy(children, index + 1, newArrayOfChildren, index, children.length - index - 1);

        this.children = newArrayOfChildren;
    }
    @Override
    public String toString() {
        return "Mother: " + mother + "\nFather: " + father + "\nChildren: " + Arrays.toString(children);
    }
    @Override
    protected void finalize() {
        System.out.println("Удаление обьекта семьи!");
    }
}
