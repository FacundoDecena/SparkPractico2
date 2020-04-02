package calculadora;

public class Calculadora {
    public double aKilogramo(double libra){
        return libra / 2.205;
    }
    public double aLibra(double kilos){
        return kilos * 2.205;
    }
    public double aKilometros(double millas){
        return millas * 1.609;
    }
    public double aMillas(double kilometros){
        return kilometros / 1.609;
    }
    public double aCelcius(double fahrenheit){
        return (fahrenheit - 32.0) * 5/9;
    }
    public double aFahrenheit(double celcius){
        return (celcius * 9/5) + 32.0;
    }
}
