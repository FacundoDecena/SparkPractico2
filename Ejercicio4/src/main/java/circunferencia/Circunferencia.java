package circunferencia;

public class Circunferencia {
    public double perimetro(double r) throws NumberFormatException{
        if (r < 0.01)
            throw new NumberFormatException("Numero menor al minimo");
        return 2 * Math.PI * r;
    }
    public double area(double r) throws NumberFormatException{
        if (r < 0.01)
            throw new NumberFormatException("Numero menor al minimo");
        return Math.PI * r * r;
    }
}
