package by.tms.storage;

import java.util.Arrays;
import java.util.List;

public class CalculatorInside {
    public List<String> operList = Arrays.asList("sum","div","minus","multiply");

    public String result (float firstNum, float secondNum, String operation) {
        switch (operation) {
            case "sum":
                return firstNum + " + " + secondNum + " = " + sum(firstNum, secondNum);
            case "div":
                return firstNum + " / " + secondNum + " = " + div(firstNum, secondNum);
            case "minus":
                return firstNum + " - " + secondNum + " = " + minus(firstNum, secondNum);
            case "multiply":
                return  firstNum + " * " + secondNum + " = " + multiply(firstNum, secondNum);
            default:
                return "Oops... Something is wrong";
        }
    }

    private float sum(float firstNum, float secondNum) {
        return firstNum + secondNum;
    }

    private float minus(float firstNum, float secondNum) {
        return firstNum - secondNum;
    }

    private float div(float firstNum, float secondNum) {
        return firstNum / secondNum;
    }

    private float multiply(float firstNum, float secondNum) {
        return firstNum * secondNum;
    }

    public List<String> getListOper(){
        return operList;
    }
}
