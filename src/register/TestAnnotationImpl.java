package register;

import java.util.HashMap;

public class TestAnnotationImpl {

public void TestAnnotationImpl(){

}
        @AnnotationVariables(
                priority = "High",
                TestExecutionType = {"Smoke", "Functional", "UAT" }

        )
        void positiveLoginFunction(HashMap<String, String> params) {
            System.out.println("positiveLoginFunction");

        }

    @AnnotationVariables(
            priority = "Low",
            TestExecutionType = {"Smoke", "Functional", "UAT" }

    )

        void negativeLoginFunction(HashMap<String, String> params) {

            System.out.println("negativeLoginFunction");

        }

    @AnnotationVariables(
            priority = "Low",
            TestExecutionType = {"Functional" }

    )

    void loginWithSpecialChar(HashMap<String, String> params) {

        System.out.println("loginWithSpecialChar");

    }


    @AnnotationVariables(
            priority = "Low",
            TestExecutionType = {"Smoke", "Functional", "UAT" }

    )

        void longLogin(HashMap<String, String> params){
            System.out.println("longLogin");
        }


    }


