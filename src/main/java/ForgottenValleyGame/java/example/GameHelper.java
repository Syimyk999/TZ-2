package ForgottenValleyGame.java.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameHelper {
    public static int getChoice(Scanner scanner, String validPattern) throws InvalidInputException {
        Pattern pattern = Pattern.compile(validPattern);
        String input;
        Matcher matcher;

        input = scanner.nextLine().toLowerCase().trim();
        matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return Integer.parseInt(input);
        }else {
            throw new InvalidInputException(" Неверный ввод. Пожалуйста, выберите допустимый вариант. ");
        }
    }
    public static void savePlayerStats(Player player) {
        Runnable saveStatsTask = () -> {
            try(java.io.FileWriter writer = new java.io.FileWriter("player_stats.txt", true)) {
                writer.write("Имя: " + player.name + "\n");
                writer.write("Класс: " + player.getClass().getSimpleName() + "\n");
                writer.write("Здаровье: " + player.health + "\n");
                writer.write("Магия: " + player.magic + "\n");
                writer.write("Уровень: " + player.level + "\n\n");
                System.out.println(" Статы сохранены ");
            }catch (java.io.IOException e) {
                System.out.println(" Ошибка сохранение данных: " + e.getMessage());
            }
        };
        new Thread(saveStatsTask).start();
    }
}
