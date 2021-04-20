package LessonOne;

public class Cat implements RunAndJump{
    private final String name;
    private int might;
    private int stamina;

    public Cat(String name, int might, int stamina) {
        this.name = name;
        this.might = might;
        this.stamina = stamina;
    }

    @Override
    public boolean jump(Wall wall) {
        int height = wall.getHEIGHT();
        if (height <= might) {
            might -= height;
            System.out.println(name + " перепрыгнул стену, высотой в " + height + "!");
            System.out.println(name + " продолжает гонку!");
        } else {
            System.out.println(name + " не осилил стену, высотой в " + height + "!");
            System.out.println(name + " выбывает из гонки!");
            return false;
        }
        return true;
    }

    @Override
    public boolean run(Track track) {
        int length = track.getLENGTH();
        if (length <= stamina) {
            stamina -= length;
            System.out.println(name + " пробежал трек, длиной в " + length + "!");
            System.out.println(name + " продолжает гонку!");
        } else {
            System.out.println(name + " потратил всю выносливость, и не осилил трек длинной в " + length + "!");
            System.out.println(name + " выбывает из гонки!");
            return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
