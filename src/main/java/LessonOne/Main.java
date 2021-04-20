package LessonOne;

public class Main {
    // инициализация участников гонки:
    public static RunAndJump robot = new Robot("R2D2", 10, 20);
    public static RunAndJump cat = new Cat("Terminator-Leopold", 20, 30);
    public static RunAndJump human = new Human("Obi-Wan", 15, 15);

    // инициализация препятствий:
    public static Obstacles wallOne = new Wall(12);
    public static Obstacles wallTwo = new Wall(2);
    public static Obstacles trackOne = new Track(18);
    public static Obstacles trackTwo = new Track(10);

    // массив участников гонки:
    public static RunAndJump[] party = {robot, cat, human};

    // массив препятствий:
    public static Obstacles[] obstacles = {wallOne, trackOne, wallTwo, trackTwo};

    // точка входа
    public static void main(String[] args) {
        championship(party, obstacles);
    }

    public static void championship(RunAndJump[] party, Obstacles[] obstacles) {
        String champions = "";
        for (int i = 0; i < party.length; i++) {
            System.out.println(party[i].getName() + "начинает гонку!");
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Wall) {
                    if(!party[i].jump((Wall) obstacles[j])) {
                        break;
                    }
                } else {
                    if(!party[i].run((Track) obstacles[j])) {
                        break;
                    }
                }
                if(j == obstacles.length - 1) {
                    champions += (" " + party[i].getName());
                }
            }
        }
        System.out.println("\nПобедители гонки на выживание:" + champions + "!");
    }


    // Тесты:
    public static void tests(){
        System.out.println("\n\n");
        robot.jump((Wall) wallOne);
        robot.jump((Wall) wallTwo);
        robot.run((Track) trackOne);
        robot.run((Track) trackTwo);
        System.out.println("\n\n");
        cat.jump((Wall) wallOne);
        cat.jump((Wall) wallTwo);
        cat.run((Track) trackOne);
        cat.run((Track) trackTwo);
        System.out.println("\n\n");
        human.jump((Wall) wallOne);
        human.jump((Wall) wallTwo);
        human.run((Track) trackOne);
        human.run((Track) trackTwo);

    }
}
