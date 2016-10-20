package register;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class TestAnnotationParser {

    public static void main(String[] args) {

        TestAnnotationParser testimp;
        testimp = new TestAnnotationParser();
        testimp.buildStateAnn();
    }


    void buildStateAnn() {

        Class<TestAnnotationImpl> obj = TestAnnotationImpl.class;

        Object clss = new TestAnnotationImpl();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("Name", "Value");

        for (Method method : obj.getDeclaredMethods()) {
            if(method.isAnnotationPresent(AnnotationVariables.class)) {

                Annotation methodAnnotation = method.getAnnotation(AnnotationVariables.class);
                System.out.println("Method.Name="+method.getName());


                AnnotationVariables statVar = (AnnotationVariables) methodAnnotation;
               String priority= statVar.priority();
                    System.out.println("priority"+priority);
                List<String> types = Arrays.asList(statVar.TestExecutionType());
                for (String tag : types) {
                    System.out.println("Type :"+tag);
                }

                if(priority.equalsIgnoreCase("High") &&  types.contains("Smoke")){
                    System.out.println(" Executing Method"+method.getName());
                    try {
                        method.invoke(clss, params);
                    }catch(Exception e){
                        System.out.println(e.toString());
                    }
                }


            }


        }

    }

}
