package week4;

public class ConflictingInterfaces implements IntOne,IntTwo{
    public static void main(String[] args) {

        //System.out.println(b);
        System.out.println(IntOne.b);

        IntOne intOne = new ConflictingInterfaces();
        IntTwo intTwo = new ConflictingInterfaces();

        intOne.method();
        intTwo.method();

    }

    @Override
    public void method() {
        System.out.println("Method #3");
    }
}

interface IntOne {
    int b = 0;
    default void method() {
        System.out.println("Method #1");
    }
}

interface IntTwo {
    int b = 0;
    default void method() {
        System.out.println("Method #2");
    }
}