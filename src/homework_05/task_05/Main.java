package homework_05.task_05;

        /*
        Задание 5
        Используя Intelij IDEA создать проект, пакет.
        Создать class Main, в нем создать список, добавить учителей, которых вы только сможете вспомнить со школы.
        И получить индекс самого лучшего учителя и самого не очень. Вывести список в консоль.
         */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    private static ArrayList<String> listTeachers = new ArrayList<>();
    public static ArrayList<String> listSubject = new ArrayList<>();
    private static ArrayList<String> listBall = new ArrayList<>();

    private static ArrayList<Integer> listBallInt = new ArrayList<>();
    private static ArrayList<Integer> listBallInt2 = new ArrayList<>();
    private static ArrayList<Integer> counter = new ArrayList<>();
    private static final String TITLE = "\n___________System Log___________";
    private static String gradeTitle = "";


    public static void main(String[] args) {
        // arrListAllData(); // Массив с листами

        // Вывести по порядку + индекс + топ по индексу
        editListTeachers(arrTeachers());
        listTeachersPrint();
        convertInt2();
        enumerationBall();
        convertInt3();
        convertInt3(1);
    }

    // Массив данных Предмет / ФИО / оценка учеников
    public static String[][] arrTeachers() {
        //1-10
        String[] teachers_01 = new String[]{"Физика", "ФИО teachers_01 ", "10",};
        String[] teachers_02 = new String[]{"Математика", "ФИО teachers_02 ", "8",};
        String[] teachers_03 = new String[]{"Химия", "ФИО teachers_02 ", "7",};
        String[] teachersAll = new String[]{String.valueOf(teachers_01), String.valueOf(teachers_02), String.valueOf(teachers_03)};

        String[][] allTeachers = {
                {"Физика", "ФИО teachers_01 ", "5",},    // [0][0]
                {"Математика", "ФИО teachers_02 ", "5",}, // [1][0]
                {"Химия", "ФИО teachers_03 ", "6",},
                {"Английский", "ФИО teachers_04 ", "2",}, // [2][0]
                {"Сопротивление материалов", "ФИО teachers_05 ", "1",}, // [2][0]
        };
        return allTeachers;
    }



    public static void convertInt(){
        String test = "2";
        int i = Integer.parseInt(test.trim());
        System.out.println(i+2);
    }

    public static void convertInt2(){

        System.out.println(TITLE + "Конвертор convertInt2() конвертирует String listBall в Integer listBallInt для понимания балла от учеников");

        Iterator<String> iteratorBall = listBall.iterator();
        while (iteratorBall.hasNext()) {
            int i = Integer.parseInt(iteratorBall.next().trim());
            listBallInt.add(i);
        }
       //listTeachersPrint2();
    }



    public static void enumerationBall() {
        System.out.println(TITLE + "Рейтинг относительно оценки учеников " + gradeTitle);
        for (int a = 0; a < listBallInt.size(); a++){
            int i =  listBallInt.indexOf(Collections.max(listBallInt));  // максимальное значение listBallInt
            System.out.println("Преподаватель " + listTeachers.get(i) + " | Предмет : " + listSubject.get(i) + " | Оценка учеников " + gradeTitle  + listBallInt.get(i));
            listBallInt.set(i,0);  // установим 0 по индексу i      System.out.println(listBallInt.get(i));
        }
        gradeTitle = "";
    }

    public static int subjectBall (String subject){
                int subjectBallInt = 0;
        switch (subject) {
            case "Математика":
                subjectBallInt = 10;
                break;
            case "Химия":
                subjectBallInt = 9;
                break;
            case "Английский":
                subjectBallInt = 8;
                break;
            case "Физика":
                subjectBallInt = 7;
                break;
            default:
                subjectBallInt = 1;
        }
        return subjectBallInt;
    }

    public static void convertInt3(){
        gradeTitle = "+ коэффициент предмета ";
        for(int p = 0; p < listBall.size(); p++){
            int b = subjectBall(listSubject.get(p));
            int i = Integer.parseInt(listBall.get(p).trim());
            listBallInt.set(p,i + b);
        }
        enumerationBall();
    }

    public static void convertInt3(int start){
        gradeTitle = "+ коэффициент предмета + index в листе ";
        for(int p = 0; p < listBall.size(); p++){
            int b = subjectBall(listSubject.get(p));
            int i = Integer.parseInt(listBall.get(p).trim());
          //  int index = p;
            listBallInt.set(p,i + b + p); // + index в листе
        }
        enumerationBall();
    }

    public static void listTeachersPrint2() {
        Iterator<Integer> iteratorCounter = listBallInt.iterator();

        while (iteratorCounter.hasNext()) {
            int integerCounter = iteratorCounter.next();
            System.out.println(integerCounter + 2);
        }
    }



    // Формируем листы
    public static void editListTeachers(String[][] allT) {
        System.out.println(TITLE + "Формируем 3 листа listSubject /  listTeachers / listBall вводные из String[][] allTeachers");
        for (int i = 0; i < allT.length; i++) {
            listSubject.add(allT[i][0]);
            listTeachers.add(allT[i][1]);
            listBall.add(allT[i][2]);
        }
    }

    // записать листы в массив // Массив с листами
    public static String[] arrListAllData() {
        String[] teachersAll = new String[3];
        teachersAll[0] = String.valueOf(listSubject);
        teachersAll[1] = String.valueOf(listTeachers);
        teachersAll[2] = String.valueOf(listBall);
        System.out.println(teachersAll);
        return teachersAll;
    }

    public static void counter(ArrayList<String> listForCounter ) {
        for (int i = 0; i < listForCounter.size(); i++){
            counter.add(i,i);
        }
    }


    public static void listTeachersPrint() {
        System.out.println(TITLE + "Рейтинг относительно индекса в листе");
        counter(listTeachers);
        // с помощью итератора можем бегать по нашему списку
        Iterator<String> iteratorTeachers = listTeachers.iterator();
        Iterator<String> iteratorSubject = listSubject.iterator();
        Iterator<String> iteratorBall = listBall.iterator();
        Iterator<Integer> iteratorCounter = counter.iterator();

        // спрашиваем есть ли следующий элемент в списке, если true, то будет реализовано тело while
        while (iteratorTeachers.hasNext() && iteratorSubject.hasNext() && iteratorBall.hasNext() && iteratorCounter.hasNext()) {
            // переходим к следующему элементу в списке и его выводим
            // для поиска индекса значения в листе можно использовать метод indexOf(), НО это будет не корректно если в листе есть повторы
            String integerTeachers = iteratorTeachers.next();
            String integerSubject = iteratorSubject.next();
            String integerBall = iteratorBall.next();
            int counterS = iteratorCounter.next();
            System.out.println("index [" + counterS + "] " + integerTeachers + " | Предмет: " + integerSubject + " | Оценка учеников: " + integerBall);
        }
        System.out.println(TITLE + " MAX & MIN index " + "\nСамый высокий индекс[" + (listTeachers.size()-1) +"] в листе у " + listTeachers.get(listTeachers.size() - 1) + " Предмет : " + listSubject.get(listTeachers.size() - 1));
        System.out.println("Самый низкий индекс [0] в листе у " + listTeachers.get(0) + " Предмет : " + listSubject.get(0));
    }

}
