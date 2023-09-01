package tests;

import controller.CalculadoraImc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteCalculadoraImc {

    CalculadoraImc c;

    @Before
    public void setup() {
        c = new CalculadoraImc();
    }

    @Test
    public void testeAdultoBaixoPesoMuitoGrave() {
        Assert.assertEquals("Baixo peso muito grave",
                c.calcularImc(48.0, 1.749, 19, "masculino"));
    }

    @Test
    public void testeAdultoBaixoPesoGraveMin() {
        Assert.assertEquals("Baixo peso grave",
                c.calcularImc(49.0, 1.749, 19, "masculino"));
    }

    @Test
    public void testeAdultoBaixoPesoGraveMax() {
        Assert.assertEquals("Baixo peso grave",
                c.calcularImc(52.0, 1.75, 19, "masculino"));
    }

    @Test
    public void testeAdultoBaixoPesoMin() {
        Assert.assertEquals("Baixo peso",
                c.calcularImc(50, 1.71, 19, "masculino"));
    }

    @Test
    public void testeAdultoBaixoPesoMax() {
        Assert.assertEquals("Baixo peso",
                c.calcularImc(53, 1.70, 19, "masculino"));
    }

    @Test
    public void testeAdultoPesoNormalMin() {
        Assert.assertEquals("Peso normal",
                c.calcularImc(54, 1.70, 19, "masculino"));
    }

    @Test
    public void testeAdultoPesoNormalMax() {
        Assert.assertEquals("Peso normal",
                c.calcularImc(72, 1.70, 19, "masculino"));
    }

    @Test
    public void testeAdultoSobrepesoMin() {
        Assert.assertEquals("Sobrepeso",
                c.calcularImc(73, 1.70, 19, "masculino"));
    }

    @Test
    public void testeAdultoSobrepesoMax() {
        Assert.assertEquals("Sobrepeso",
                c.calcularImc(86, 1.70, 19, "masculino"));
    }

    @Test
    public void testeAdultoObesidadeGrau1Min() {
        Assert.assertEquals("Obesidade grau I",
                c.calcularImc(98, 1.80, 19, "masculino"));
    }

    @Test
    public void testeAdultoObesidadeGrau1Max() {
        Assert.assertEquals("Obesidade grau I",
                c.calcularImc(113, 1.80, 19, "masculino"));
    }

    @Test
    public void testeAdultoObesidadeGrau2Min() {
        Assert.assertEquals("Obesidade grau II",
                c.calcularImc(114, 1.80, 19, "masculino"));
    }

    @Test
    public void testeAdultoObesidadeGrau2Max() {
        Assert.assertEquals("Obesidade grau II",
                c.calcularImc(129, 1.80, 19, "masculino"));
    }

    @Test
    public void testeAdultoObesidadeGrau3() {
        Assert.assertEquals("Obesidade grau III (obesidade mórbida)",
                c.calcularImc(130, 1.80, 19, "masculino"));
    }

    @Test
    public void testeIdosoBaixoPesoFeminino() {
        Assert.assertEquals("Baixo peso",
                c.calcularImc(63.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoPesoNormalFemininoMin() {
        Assert.assertEquals("Peso normal",
                c.calcularImc(64.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoPesoNormalFemininoMax() {
        Assert.assertEquals("Peso normal",
                c.calcularImc(78.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoSobrepesoFemininoMin() {
        Assert.assertEquals("Sobrepeso",
                c.calcularImc(79.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoSobrepesoFemininoMax() {
        Assert.assertEquals("Sobrepeso",
                c.calcularImc(92.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoObesidadeGrau1FemininoMin() {
        Assert.assertEquals("Obesidade grau I",
                c.calcularImc(93.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoObesidadeGrau1FemininoMax() {
        Assert.assertEquals("Obesidade grau I",
                c.calcularImc(106.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoObesidadeGrau2FemininoMin() {
        Assert.assertEquals("Obesidade grau II",
                c.calcularImc(108.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoObesidadeGrau2FemininoMax() {
        Assert.assertEquals("Obesidade grau II",
                c.calcularImc(121.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoObesidadeGrau3Feminino() {
        Assert.assertEquals("Obesidade grau III (obesidade mórbida)",
                c.calcularImc(122.0, 1.7, 66, "feminino"));
    }

    @Test
    public void testeIdosoBaixoPesoMasculino() {
        Assert.assertEquals("Baixo peso",
                c.calcularImc(63.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoPesoNormalMasculinoMin() {
        Assert.assertEquals("Peso normal",
                c.calcularImc(64.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoPesoNormalMasculinoMax() {
        Assert.assertEquals("Peso normal",
                c.calcularImc(78.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoSobrepesoMasculinoMin() {
        Assert.assertEquals("Sobrepeso",
                c.calcularImc(79.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoSobrepesoMasculinoMax() {
        Assert.assertEquals("Sobrepeso",
                c.calcularImc(86.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoObesidadeGrau1MasculinoMin() {
        Assert.assertEquals("Obesidade grau I",
                c.calcularImc(90.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoObesidadeGrau1MasculinoMax() {
        Assert.assertEquals("Obesidade grau I",
                c.calcularImc(101.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoObesidadeGrau2MasculinoMin() {
        Assert.assertEquals("Obesidade grau II",
                c.calcularImc(102.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoObesidadeGrau2MasculinoMax() {
        Assert.assertEquals("Obesidade grau II",
                c.calcularImc(115.0, 1.7, 66, "masculino"));
    }

    @Test
    public void testeIdosoObesidadeGrau3Masculino() {
        Assert.assertEquals("Obesidade grau III (obesidade mórbida)",
                c.calcularImc(116.0, 1.7, 66, "masculino"));
    }

}
