package LessonTwo;

public class Main {

    public static void main(String[] args) {
        String[][] arr;
        arr = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        try {
            try {
                System.out.println(checkArrayLength(arr));
            } catch (MyArraySizeException e) {
                System.out.println(e);
            }
        } catch (MyArrayDataException e) {
            System.out.println(e);
            System.out.println("В ячейке: " + e.i + "/" +e.j + " лежит символ или текст вместо числа");
        }


    }

    public static int checkArrayLength(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int total = 0;
        if (arr.length != 4) {
            System.out.println("В массиве некорректное количество строк!!!");
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                System.out.println("В одной из строк некорректное количество столбцов!!!");
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    total += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return total;
    }
}
