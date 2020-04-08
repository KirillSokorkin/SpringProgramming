/**
 * @author Кирилл Сокоркин R3137
 * От данного класса создаются все Дисциплины, по которым создаются Лабораторные Работы
 */
public class Discipline {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int lectureHours;
    private long practiceHours;
    private int selfStudyHours;
    private long labsCount;

    public Discipline(String name, int lectureHours, long practiceHours, int selfStudyHours, long labsCount){
        this.name = name;
        this.labsCount = labsCount;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
        this.selfStudyHours = selfStudyHours;
    }
    /**
     * @return Название Дисциплины
     */
    public String toString(){
        return this.name;
    }

}