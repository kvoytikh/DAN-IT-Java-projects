package com.company;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Human[] getChildren() {
        return children;
    }

    public Pet getPet() {
        return pet;
    }

    static {
        System.out.println("Загружается новый класс " + Family.class.getSimpleName());
    }
    { System.out.println("Coздается новый обьект");}

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        mother.setFamily(this);
        father.setFamily(this);
    }
    public Family(Human mother, Human father, Human[] children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        mother.setFamily(this);
        father.setFamily(this);
    }
    public Family(Human mother, Human father, Human[] children, Pet pet) {
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
