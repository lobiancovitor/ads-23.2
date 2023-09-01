package controller;

public class CalculadoraImc {

    public String calcularImc(double peso, double altura, int idade, String sexo) { // https://www.tuasaude.com/calculadora/imc/
        double imc = (peso / (altura * altura));
        String resultado = "";

        if (idade > 65) {
            if (sexo.equals("feminino")) {
                if (imc < 21.9) {
                    resultado = "Baixo peso";
                } else if (imc >= 22.0 && imc <= 27.0) {
                    resultado = "Peso normal";
                } else if (imc >= 27.1 && imc <= 32.0) {
                    resultado = "Sobrepeso";
                } else if (imc >= 32.1 && imc <= 37.0) {
                    resultado = "Obesidade grau I";
                } else if (imc >= 37.1 && imc <= 41.9) {
                    resultado = "Obesidade grau II";
                } else {
                    resultado = "Obesidade grau III (obesidade mórbida)";
                }
            } else if ((sexo.equals("masculino"))) {
                if (imc < 21.9) {
                    resultado = "Baixo peso";
                } else if (imc >= 22.0 && imc <= 27.0) {
                    resultado = "Peso normal";
                } else if (imc >= 27.1 && imc <= 30.0) {
                    resultado = "Sobrepeso";
                } else if (imc >= 30.1 && imc <= 35.0) {
                    resultado = "Obesidade grau I";
                } else if (imc >= 35.1 && imc <= 39.9) {
                    resultado = "Obesidade grau II";
                } else {
                    resultado = "Obesidade grau III (obesidade mórbida)";
                }
            }
        } else {
            if (imc < 16.0) {
                resultado = "Baixo peso muito grave";
            } else if (imc >= 16.0 && imc <= 16.99) {
                resultado = "Baixo peso grave";
            } else if (imc >= 17.0 && imc <= 18.49) {
                resultado = "Baixo peso";
            } else if (imc >= 18.50 && imc <= 24.99) {
                resultado = "Peso normal";
            } else if (imc >= 25.0 && imc <= 29.99) {
                resultado = "Sobrepeso";
            } else if (imc >= 30.0 && imc <= 34.99) {
                resultado = "Obesidade grau I";
            } else if (imc >= 35.0 && imc <= 39.99) {
                resultado = "Obesidade grau II";
            } else {
                resultado = "Obesidade grau III (obesidade mórbida)";
            }
        }

        return resultado;
    }
}
