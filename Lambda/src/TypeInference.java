public class TypeInference {
    public static void main(String[] args) {
        StringLengthLambda myLambda = s -> s.length();
        System.out.println(myLambda.getLngth("hello Kaari"));
printLambda(s->s.length());
    }

    public static void printLambda(StringLengthLambda st) {
        System.out.println(st.getLngth("Hello lambda"));
    }


    interface StringLengthLambda {
        int getLngth(String s);
    }
}

