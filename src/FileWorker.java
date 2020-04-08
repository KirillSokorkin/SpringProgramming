import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class FileWorker {
    private String path;

    public FileWorker(String path){
        this.path = path;
    }

    public TreeSet<LabWork> readfromFile() throws FileNotFoundException {

        Scanner sc;
        TreeSet<LabWork> temp = new TreeSet<LabWork>();

        try {
             sc = new Scanner(new File(this.path));
        }
        catch (Exception e)
        {
            System.out.println("Файл недоступен");
            return temp;
        }

        while (sc.hasNext())
        {
            String line = sc.next();
            String [] parts = line.split("<_0_>");

            if (parts.length!=8) continue;

            if (parts[0].isEmpty()) continue;
            String name = parts[0];

            double x;
            float y;

            try {
                x = (double) Double.parseDouble(parts[1]);
                y = (float) Float.parseFloat(parts[2]);
            } catch (Exception e) {
                continue;
            }

            Coordinates coordinates = new Coordinates(x, y);

            Long minimal_point;

            try {
                if (parts[3].isEmpty()) {
                    minimal_point = null;
                }
                else {
                    minimal_point = Long.parseLong(parts[3]);
                    if (minimal_point <= 0) minimal_point = null;
                }
            } catch (Exception e) {
                continue;
            }

            Long personalQualitiesMinimum;

            try {
                if (parts[4].isEmpty()) {
                    personalQualitiesMinimum = null;
                }
                else {
                    personalQualitiesMinimum = Long.parseLong(parts[4]);
                }
            } catch (Exception e) {
                continue;
            }

            String description;
            if (parts[5].isEmpty()) continue;
            else description = parts[5];

            Difficulty difficulty;
            try {
                if (parts[6].isEmpty()) {
                    difficulty = null;
                }
                else
                difficulty = Difficulty.valueOf(parts[6]);
            } catch (Exception e) {
                continue;
            }


            String str_discipline = parts[7];

            if (str_discipline.isEmpty()) {
                continue;
            }
            Discipline discipline = new Discipline(str_discipline, 0, 0, 0, 0);

            temp.add(new LabWork(name, coordinates, minimal_point, personalQualitiesMinimum, description, difficulty, discipline));

        }
        sc.close();
        return temp;
    }

    public boolean writetoFile(TreeSet<LabWork> collection) throws IOException {

        FileOutputStream outstream;

        try {
            outstream = new FileOutputStream(new File(this.path));
        }
        catch (Exception e){
            System.out.println("Файл не найден или недоступен");
            return false;
        }

        Iterator<LabWork> iter = collection.iterator();

        while (iter.hasNext())
        {
            LabWork current = iter.next();
            String current_str = "";

            current_str+=current.getName()+"<_0_>";
            current_str+=current.getCoordinates().getX() + "<_0_>";
            current_str+=current.getCoordinates().getY() + "<_0_>";
            current_str+=current.getMinimalPoint().toString() + "<_0_>";
            current_str+=current.getPersonalQualitiesMinimum().toString() + "<_0_>";
            current_str+=current.getDescription() + "<_0_>";
            current_str+=current.getDifficulty().toString() + "<_0_>";
            current_str+=current.getDiscipline().toString() + "\n";

            outstream.write(current_str.getBytes());

        }

        outstream.close();
        return true;
    }


}
