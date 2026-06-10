public class CalculatorTest {
    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Test add
        check("add(10, 5) == 15", calc.add(10, 5) == 15);
        check("add(0, 0) == 0", calc.add(0, 0) == 0);
        check("add(-1, 1) == 0", calc.add(-1, 1) == 0);

        // Test subtract
        check("subtract(10, 5) == 5", calc.subtract(10, 5) == 5);
        check("subtract(5, 10) == -5", calc.subtract(5, 10) == -5);

        // Test multiply
        check("multiply(3, 4) == 12", calc.multiply(3, 4) == 12);
        check("multiply(0, 100) == 0", calc.multiply(0, 100) == 0);

        // Test divide
        check("divide(10, 5) == 2.0", calc.divide(10, 5) == 2.0);
        check("divide(7, 2) == 3.5", calc.divide(7, 2) == 3.5);

        // Test division by zero
        try {
            calc.divide(5, 0);
            fail("divide(5, 0) should throw exception");
        } catch (IllegalArgumentException e) {
            pass("divide(5, 0) throws IllegalArgumentException");
        }

        // Test power
        check("power(2, 3) == 8", calc.power(2, 3) == 8);
        check("power(5, 0) == 1", calc.power(5, 0) == 1);

        // Summary
        System.out.println("============================");
        System.out.println("Tests passed: " + passed);
        System.out.println("Tests failed: " + failed);
        System.out.println("============================");

        if (failed > 0) {
            System.exit(1);
        }
    }

    static void check(String name, boolean condition) {
        if (condition) {
            pass(name);
        } else {
            fail(name);
        }
    }

    static void pass(String name) {
        System.out.println("[PASS] " + name);
        passed++;
    }

    static void fail(String name) {
        System.out.println("[FAIL] " + name);
        failed++;
    }
}
