package by.matrosov.algorithms;

public class Enumeration {
    public static void main(String[] args) {
        int[] abc = new int[]{5, 6, 8, 9};//множество допустимых символов
        int size = 3;//кол-во элементов
        int[] arr = new int[size];//массив для хранения текущего варианта множества

        outer: while(true){//вечный цикл

            //вывод варианта множества на экран
            for(int ndx : arr){
                System.out.print(abc[ndx]);
            }
            System.out.println();

            int i = size - 1;//ставим курсов в самую правую ячейку
            while(arr[i] == abc.length - 1){//движемся влево, если ячейка переполнена
                arr[i] = 0;//записываем в ячейку 0, т.к. идет перенос разряда
                i--;//сдвиг влево
                //если перенос влево невозможен, значит перебор закончен
                if(i < 0)break outer;
            }
            arr[i]++;//увеличиваем значение ячейки на единицу
        }
    }
}