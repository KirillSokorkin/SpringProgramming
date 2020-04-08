/**
 * @author Кирилл Сокоркин R3137
 */
public class Coordinates {
    private double x; //Значение поля должно быть больше -722
    private float y;

    public Coordinates(double x, float y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * @return Координату X
     */
    public double getX() {
        return x;
    }
    /**
     * @return Координату Y
     */
    public float getY() {
        return y;
    }
}
