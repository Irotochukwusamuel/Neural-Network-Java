abstract class Main{
    public String name = "sinclair";
    public int age = 29;
    public abstract void study();
}

class Student extends Main {
    public void study(){
        System.out.println("Studying all day and my name is " + name);
    }
}

class Person {
    private int age;

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}