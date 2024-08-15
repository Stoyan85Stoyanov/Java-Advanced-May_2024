package JavaAdvancedExam_12_08_2024.surfers;

public class Surfer {
    private String name;
    private int age;
    private int experience;
    private Boolean ownsASurfBoard;
    private int money;

    public Surfer(String name, int age, int experience, Boolean ownsASurfBoard, int money) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.ownsASurfBoard = ownsASurfBoard;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public Boolean getOwnsASurfBoard() {
        return ownsASurfBoard;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setOwnsASurfBoard(Boolean ownsASurfBoard) {
        this.ownsASurfBoard = ownsASurfBoard;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return String.format("Surfer %s is %d years old and has %d years surfing experience.", name, age, experience);
    }
}
