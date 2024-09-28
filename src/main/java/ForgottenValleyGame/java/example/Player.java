package ForgottenValleyGame.java.example;

import java.util.HashMap;
import java.util.Map;

public class Player extends Character {
    private String characterClass;
    private Map<String, Integer> inventory = new HashMap<>();

    public Player(String name, String characterClass) {
        super(name, 100, 50, 1);
        this.characterClass = characterClass;
    }
    @Override
    public void displayStats() {
        System.out.println("Имя: " + name);
        System.out.println("Здоровье: " + health);
        System.out.println("Магия: " + magic);
        System.out.println("Уровень: " + level);
        System.out.println("Инвентарь: " + inventory);
    }
    public void modifyHealth(int amount) {
        health += amount;
        System.out.println("Здоровье изменено на " + amount + ". Текущая здоровье: " + health);
    }
    public void modifyMagic(int amount) {
        magic += amount;
        System.out.println("Магия  изменено на " + amount + ". Текущая магия: " + magic);
    }
    public void addItemToInventory( String item, int amount) {
        inventory.put(item, inventory.getOrDefault(item, 0) + amount);
        System.out.println(item + " добавлен винвентарь");
    }
}
