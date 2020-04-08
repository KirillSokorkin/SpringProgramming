/**
 * @author Кирилл Сокоркин R3137
 */
import java.time.LocalDate;

public class LabWork implements Comparable<LabWork>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Long personalQualitiesMinimum; //Поле может быть null, Значение поля должно быть больше 0
    private String description; //Поле не может быть null
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле не может быть null

    public LabWork(String name, Coordinates coordinates, Long minimalPoint, Long personalQualitiesMinimum, String description,
                   Difficulty difficulty, Discipline discipline){

        this.name = name;
        this.coordinates = coordinates;
        this.minimalPoint = minimalPoint;
        this.personalQualitiesMinimum = personalQualitiesMinimum;
        this.description = description;
        this.difficulty = difficulty;
        this.discipline = discipline;

        this.id = this.hashCode();
        this.creationDate = LocalDate.now();
    }

    /**
     * @param o Объект класса LabWork
     * @return 1, если ID больше и -1, если ID меньше
     */
    @Override
    public int compareTo(LabWork o) {
        if (this.id > o.id) return 1;
        if (this.id < o.id) return -1;
        return 0;
    }
    /**
     * @param name Название
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param coordinates Координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    /**
     * @param minimalPoint Минимальный балл
     */
    public void setMinimalPoint(Long minimalPoint) {
        this.minimalPoint = minimalPoint;
    }
    /**
     * @param personalQualitiesMinimum Минимальный балл за Личностные Качества
     */
    public void setPersonalQualitiesMinimum(Long personalQualitiesMinimum) {
        this.personalQualitiesMinimum = personalQualitiesMinimum;
    }
    /**
     * @param description Описание
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @param difficulty Сложность
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    /**
     * @param discipline Название Дисциплины
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    /**
     * @return ID Объекта
     */
    public int getId() {
        return id;
    }
    /**
     * @return Название Объекта
     */
    public String getName() {
        return name;
    }
    /**
     * @return Координаты Объекта
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    /**
     * @return Дату создания Объекта
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }
    /**
     * @return Минимальный балл Объекта
     */
    public Long getMinimalPoint() {
        return minimalPoint;
    }
    /**
     * @return Минимальный балл за Личностные качества Объекта
     */
    public Long getPersonalQualitiesMinimum() {
        return personalQualitiesMinimum;
    }
    /**
     * @return Описание Объекта
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return Сложность Объекта
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
    /**
     * @return Название Дисциплины Объекта
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString(){
        return "LabWork с id: " + id +'\n'
                + "Название Предмета: " + discipline +'\n'
                + "Название Работы: " + name +'\n'
                + "Сложность: " + difficulty +'\n'
                + "Минимальный Балл(Выполнение/ЛичностныеКачества): " + minimalPoint + "/" + personalQualitiesMinimum +'\n'
                + "Описание работы: " + description;
    }
}

