package homework_05.task_02_03;

import java.util.ArrayList;
import java.util.ListIterator;

public class Zoo {


    /*
    Задание 2+
    Используя Intelij IDEA создать проект, пакет. Создать класс Zoo.
    В классе создать список, в который записать 8 животных через метод add(index, element).
    Вывести список в консоль.
     */

    private static ArrayList<String> listZoo = new ArrayList<>();

    public static void main(String[] args) {
        String[] arrZoo = new String[]{"Сизая чайка - Эл_1", "Домовый сыч - Эл_2", "Ушан бурый Эл_3", "Чирок-свистунок Эл_4", "Болотная черепаха Эл_5", "Зеленая пересмешка Эл_6", "Вьюрок Эл_7", "Уж водяной Эл_8"};
        System.out.println("task_02__________________________________");
        for (int i = 0; i < 8; i++) {
            listZoo.add(i, arrZoo[i]);
        }
        iteratorZooPrint();

        System.out.println("task_03__________________________________");

         /*
    Задание 3
    Используя Intelij IDEA создать проект, пакет. Используя класс Zoo Задания 2,
    удалить 3, 5, 7 животные, узнать размер списка и вывести в консоль.
        */

        /* for (int i = 3; i < 8; i++) {
            if (i % 2 != 0) {
                listZoo.remove(i-1);
            }
        }*/

        listZoo.remove(2);
        listZoo.remove(4-1);
        listZoo.remove(6-2);

        iteratorZooPrint();

        System.out.println("__________________________________Размер листа = " + listZoo.size());
    }

    private static void iteratorZooPrint(){
        // через оптимизированный итератор под cписки
        ListIterator<String> listIt = listZoo.listIterator();
        while (listIt.hasNext()) {
            String integer = listIt.next();
            System.out.println(integer);
        }
    }
}
