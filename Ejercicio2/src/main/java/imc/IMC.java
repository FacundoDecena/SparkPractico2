package imc;

import lombok.Data;

@Data
public class IMC {
    static final double IN =  18.5;
    static final double N =  24.9;
    static final double MN =  29.9;
    private double weigth;
    private double height;
    private double imc;

    public IMC(double weight, double height){
        this.weigth = weight;
        this.height = height;
        this.imc = this.weigth/(this.height * this.height);
    }

    public String calculateIMC(){
        if (imc < IN)
            return "Peso inferior al normal";
        if (imc < N)
            return "Peso normal";
        if (imc < N)
            return "Peso superior al normal";

        return "Obesidad";

    }
}