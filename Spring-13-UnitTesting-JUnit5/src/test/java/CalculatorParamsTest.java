import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParamsTest {
    @ParameterizedTest
    @ValueSource(strings = {"java","css","html"})

    public void testCase1(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,4,7,12,24})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    public void testCase2(int nums){
        Assertions.assertEquals(0,nums%3);
    }
    @ParameterizedTest
    @MethodSource("stringProvider")
    public void test4(String args){
        Assertions.assertNotNull(args);
    }
    public static String[]stringProvider(){
        String arr[]={"Java","JS","TC"};
        return arr;
    }
@ParameterizedTest
@CsvSource({
        "10,20,30",
        "100,200,300",
        "1,2,3"
})
    public void test5(int num1,int num2,int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }
@ParameterizedTest
@CsvFileSource(resources = "/sample.csv",numLinesToSkip = 1)
    public void test6(int num1,int num2,int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }


}
