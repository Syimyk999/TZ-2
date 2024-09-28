package ForgottenValleyGame.java.example;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ForgottenValleyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите имя вашего персанажа:");
            String playerName = scanner.nextLine();
            System.out.println("Выберите класс персонажа: " + "\nВоин" + "\nМаг" + "\nРазбойник");
            String characterClass = scanner.nextLine();

            Player player = new Player(playerName, characterClass);

            GameHelper.savePlayerStats(player);
            player.displayStats();

            System.out.println("\t\t\n Этап 1: Вход в Долину ");
            System.out.println("\t\nВы стоите на краю Забытой Долины. " +
                    "Легенды глосят, что здесь скрыты несметные сокровища и древние тайны. ");
            System.out.println("\n Вы делаете первый шаг в неизвесность...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1. Иследовать лес.");
            System.out.println("2. Направиться к старой руине.");
            System.out.println("3. Сойти с тропы и обыскать окресности.");
            System.out.println("4. выйти из Долины.");

            try {
                int choice1 = GameHelper.getChoice(scanner, "1|2|3|4");
                switch (choice1) {
                    case 1 -> exploreForest(player, scanner);
                    case 2 -> exploreRuins(player, scanner);
                    case 3 -> searchSurroundings(player);
                    case 4 -> System.out.println("Вы покинули игру. Спасибо за участие ");

                    default -> throw new InvalidInputException("Неверный выбор.");
                }
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }

    public static void exploreForest(Player player, Scanner scanner)throws InvalidInputException {
        System.out.println("Лес полон шорохов и таинственных звуков." +
                "Вы наткнулись на таинственное свечение между деревьями.");
        System.out.println("1.Подабрать артефакт.");
        System.out.println("2.Оставить его и продолжить ислледование.");
        System.out.println("3.Вернуться на трапу.");

        int choice = GameHelper.getChoice(scanner, "1|2|3");
        switch (choice) {
            case 1 -> {
                System.out.println("Вы подабрали магический артефакт и получили +2 к магии.");
                player.modifyMagic(2);
                player.addItemToInventory("Магический артефакт", 1);
            }
            case 2 -> System.out.println("Вы решили не трогать артефакт.");
            case 3 -> System.out.println("Вы вернулись на трапу.");
            default -> throw new InvalidInputException("Неверный выбор.");
            }
        }
        public static void exploreRuins(Player player, Scanner scanner)throws InvalidInputException {
            System.out.println("Вы подашли к старой руине. Она выглядит заброшенной, но вы чувствуете странную энергию.");
            System.out.println("1.Войти в руину.");
            System.out.println("2.Исследовать окрестность.");
            System.out.println("3.Вернуться назад.");

            int choice = GameHelper.getChoice(scanner, "1|2|3");
            switch (choice) {
                case 1 -> {
                    System.out.println("Вы вошли в руину и нашли магическую сферу.");
                    player.addItemToInventory("Магическая сфера", 1);
                }
                case 2 -> System.out.println("Вы обашли руину, но ничего не нашли.");
                case 3 -> System.out.println("Вы вернулись назад.");
                default -> throw new InvalidInputException("Неверный выбор.");
            }
        }
        public static void searchSurroundings(Player player) {
            System.out.println("Вы обыскали окресности и нашли лечебные травы.");
            player.modifyHealth(10);
            player.addItemToInventory("Лечебные травы", 1);
        }
    }


