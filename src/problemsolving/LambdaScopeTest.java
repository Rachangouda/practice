package problemsolving;

import java.util.function.Consumer;
//https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
public class LambdaScopeTest {

    int x=0;

    class FirstLevel{

        int x=1;

        void methodInFirstLevel(int x) {
            //x=99;

            Consumer<Integer> myConsumer = (y) -> {

                System.out.println("X = " + x);
                System.out.println("Y = " + y);
                System.out.println("FirstLevel X= " + this.x);
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
            };

            myConsumer.accept(x);
        }

        /*Consumer<Integer> myConsumer = (y) -> {

            System.out.println("X = " + x);
            System.out.println("Y = " + y);
            System.out.println("FirstLevel X= " + this.x);
            System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
        };*/

    }

    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
/*
Result
x = 23
y = 23
this.x = 1
LambdaScopeTest.this.x = 0*/
