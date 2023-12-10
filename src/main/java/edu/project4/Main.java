package edu.project4;

public final class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        FractalInferno fractalInferno = new FractalInferno();
        var image = fractalInferno.multiThreadRender(
            1080,
            1920,
            100,
            25,
            1_000_000,
            10,
            NonLinearTransformator.NonLinearType.HYPERBOLIC
        );
        image.gammaCorrection(1);
        image.createFile("src/main/java/edu/project4/images/Fractal_Inferno");
    }
}