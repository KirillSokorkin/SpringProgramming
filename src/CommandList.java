/**
 * @author Кирилл Сокоркин R3137
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class CommandList {
    static void help() {
        System.out.println(
                "help : вывести справку по доступным командам\n" +
                        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "add {element} : добавить новый элемент в коллекцию\n" +
                        "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_by_id id : удалить элемент из коллекции по его id\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit :завершить программу (без сохранения в файл)\n " +
                        "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                        "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                        "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "average_of_minimal_point : вывести среднее значение поля minimalPoint для всех элементов коллекции\n" +
                        "print_unique_minimal_point : вывести уникальные значения поля minimalPoint всех элементов в коллекции\n" +
                        "print_field_ascending_personal_qualities_minimum : вывести значения поля personalQualitiesMinimum всех элементов в порядке возрастания");
    }

    static void info(TreeSet<LabWork> collection, LocalDateTime creation_date) {
        System.out.println("Тип: TreeSet \n" +
                "Дата инициализации: " + creation_date + '\n' +
                "Количество элементов: " + collection.size()

        );
    }

    static void show(TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();
        while (iter.hasNext()) {
            System.out.println('\n' + iter.next().toString() + '\n');
        }
    }

    static LabWork remove_by_id(int id, TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();

        while (iter.hasNext()) {
            LabWork temp = iter.next();
            if (temp.getId() == id) return temp;
        }
        return null;
    }

    static void print_unique_minimal_point(TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();
        ArrayList<Long> arrayList = new ArrayList<>();
        while (iter.hasNext()) {
            LabWork temp = iter.next();
            if(arrayList.contains(temp.getMinimalPoint()))
            {
                return;
            }
            else{
                arrayList.add(temp.getMinimalPoint());
                System.out.println(temp.getMinimalPoint());

            }

        }
    }

    static LabWork remove_lower(int id, TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();
        while (iter.hasNext()) {
            LabWork temp = iter.next();
            if (temp.getId() < id) return temp;
        }
        System.out.println("ID не найден");
        return null;
    }

    static LabWork remove_greater(int id, TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();
        while (iter.hasNext()) {
            LabWork temp = iter.next();
            if (temp.getId() > id) return temp;
        }
        System.out.println("ID не найден");
        return null;
    }

    static LabWork add() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя для LabWork");
        String name = sc.nextLine();
        while (true) {
            if (name.isEmpty()) {
                System.out.println("Введите что-нибудь");
                name = sc.nextLine();
            } else break;
        }

        System.out.println("Введите Координаты для LabWork");
        String str_coords = sc.nextLine();
        double x;
        float y;
        while (true) {
            try {
                String[] str_array = str_coords.split(" ", 2);
                x = (double) Double.parseDouble(str_array[0]);
                y = (float) Float.parseFloat(str_array[1]);
                break;
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите попытку");
                str_coords = sc.nextLine();
            }
        }
        Coordinates coordinates = new Coordinates(x, y);

        System.out.println("Введите Минимальный Балл для LabWork");
        String str_minimalPoint = sc.nextLine();
        Long minimal_point;
        while (true) {
            try {
                if (str_minimalPoint.isEmpty()) {
                    minimal_point = null;
                    break;
                }
                minimal_point = Long.parseLong(str_minimalPoint);
                break;

            } catch (Exception e) {
                str_minimalPoint = sc.nextLine();
                System.out.println("Введите число типа Long или оставьте строку пустой");
            }
        }

        System.out.println("Введите Минимальный балл Личностных качеств для LabWork");
        String str_presQ = sc.nextLine();
        Long personalQualitiesMinimum;
        while (true) {
            try {
                if (str_presQ.isEmpty()) {
                    personalQualitiesMinimum = null;
                    break;
                }
                personalQualitiesMinimum = Long.parseLong(str_presQ);
                break;

            } catch (Exception e) {
                str_presQ = sc.nextLine();
                System.out.println("Введите число типа Long или оставьте строку пустой");
            }
        }

        System.out.println("Введите Описание для LabWork");
        String description = sc.nextLine();
        while (true) {
            if (description.isEmpty()) {
                System.out.println("Описание не может быть пустым. Введите ещё раз^");
                description = sc.nextLine();
            } else break;
        }

        System.out.println("Введите Сложность для LabWork");
        String str_difficulty = sc.nextLine();
        Difficulty difficulty;
        while (true) {
            try {
                if (str_difficulty.isEmpty()) {
                    difficulty = null;
                    break;
                }
                difficulty = Difficulty.valueOf(str_difficulty);
                break;
            } catch (Exception e) {
                System.out.println("Введён неприемлемый параметр. Введите ещё раз.");
                str_difficulty = sc.nextLine();
            }
        }

        System.out.println("Введите Название Предмета для LabWork");
        String str_discipline = sc.nextLine();
        while (true) {
            if (str_discipline.isEmpty()) {
                System.out.println("Название Предмета не может быть пустым. Введите ещё раз.");
                str_discipline = sc.nextLine();
            }
            else break;
        }
        Discipline discipline = new Discipline(str_discipline, 0, 0, 0, 0);
        sc.close();

        return new LabWork(name, coordinates, minimal_point, personalQualitiesMinimum, description, difficulty, discipline);
    }

    static LabWork add_if_min(TreeSet<LabWork> collection) {
        LabWork temp = add();
        if (temp.compareTo(collection.first()) < 0)
            return temp;
        else return null;
    }

    static void clear(TreeSet<LabWork> collection) {
        collection.clear();
    }

    static void update(int id, TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();

        while (iter.hasNext()) {
            LabWork temp = iter.next();
            if (temp.getId() == id) {
                collection.remove(temp);
                collection.add(CommandList.add());
            }
        }
    }

    static LabWork add_if_max(TreeSet<LabWork> collection) {
        LabWork temp1 = add();
        if (temp1.compareTo(collection.last()) > 0)
            return temp1;
        else return null;
    }

    static void average_of_minimal_point(TreeSet<LabWork> collection) {
        Iterator<LabWork> iter = collection.iterator();
        long sum = 0;
        long quan = 0;
        while (iter.hasNext()) {

            LabWork temp = iter.next();
            sum = sum + temp.getMinimalPoint();
            quan = quan + 1;
        }
        double rez = sum / quan;
        System.out.println("Средний Минимальный Балл Коллекции : " + rez);
    }
}
