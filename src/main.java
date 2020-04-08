import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * @author Кирилл Сокоркин R3137
 * Данный класс осуществляет работу всей программы
 */
public class main {
    public static void main(String [] args) throws FileNotFoundException {

        FileWorker current = new FileWorker("C:\\\\KMS\\1.txt");

        TreeSet<LabWork> collection = current.readfromFile();
        LocalDateTime creation_date = LocalDateTime.now();

        LabWork ssss = new LabWork("asdf", new Coordinates(1, 2), (long)1, (long)1, "asdfg", Difficulty.HARD, new Discipline("sdf", 0, 0, 0, 0));
        collection.add(ssss);

        HashSet<String> pathcollection = new HashSet<String>();

        commandReading(collection, creation_date, "System.in", pathcollection, current);

    }

    public static boolean commandReading(TreeSet<LabWork> collection, LocalDateTime creation_date,  String source, HashSet<String> pathcollection, FileWorker current){

        Scanner sc;

        if (source.equals("System.in"))
            sc = new Scanner(System.in);
        else {
            try{
                sc = new Scanner(new File(source));
            }
            catch (Exception e){
                System.out.println("Файл не найден");
                return false;
            }
        }
        String input = sc.nextLine();

        while (!input.equals("exit"))
        {
            String[] commandParts = input.split(" ");

            switch (commandParts[0].toLowerCase()) {
                case "help":
                    CommandList.help();
                    break;

                case "info":
                    CommandList.info(collection, creation_date);
                    break;

                case "show":
                    CommandList.show(collection);
                    break;

                case "print_unique_minimal_point":
                    CommandList.print_unique_minimal_point(collection);
                    break;

                case "average_of_minimal_point":
                    CommandList.average_of_minimal_point(collection);
                    break;

                case "add":
                    collection.add(CommandList.add());
                    break;

                case "clear":
                    CommandList.clear(collection);
                    break;

                case "print_field_ascending_personal_qualities_minimum":
                    CommandList.print_field_ascending_personal_qualities_minimum(collection);
                    break;

                case "remove_by_id":
                    try {
                        long id = Integer.parseInt(commandParts[1]);
                        collection.remove(CommandList.remove_by_id(id, collection));
                    } catch (Exception e1) {
                        System.out.println("ID не найден ");
                    }
                    break;

                case "remove_greater":
                    try {
                        int id = Integer.parseInt(commandParts[1]);
                        collection.remove(CommandList.remove_greater(id, collection));
                    } catch (Exception e) {
                        System.out.println("ID не найден");
                    }
                    break;

                case "remove_lower":
                    try {
                        int id = Integer.parseInt(commandParts[1]);
                        collection.remove(CommandList.remove_lower(id, collection));
                    } catch (Exception e2) {
                        System.out.println("ID не найден");
                    }
                    break;

                case "add_if_max":
                    LabWork B = CommandList.add_if_max(collection);
                    if (B!=null)
                        collection.add(B);
                    break;

                case "update":
                    try {
                        int id = Integer.parseInt(commandParts[1]);
                        CommandList.update(id, collection);
                    } catch (Exception e) {
                        System.out.println("л");
                    }
                    break;

                case "execute_script":

                    if (pathcollection.contains(commandParts[1]))
                        System.out.println("Файл был вызван ранее");
                    else {
                        pathcollection.add(commandParts[1]);
                        commandReading(collection, creation_date, commandParts[1], pathcollection, current);
                        pathcollection.remove(commandParts[1]);
                    }
                    break;

                case "save":
                    try{
                        current.writetoFile(collection);
                    }
                    catch (Exception e){
                        System.out.println("Что-то пошло не так");
                    }
                    break;

                default:
                    System.out.println("Команда не распознана");
            }
            if (!pathcollection.isEmpty() && !sc.hasNext()) {
                sc.close();
                return true;
            }

            input = sc.nextLine();
        }
        sc.close();
        return true;
    }
}
