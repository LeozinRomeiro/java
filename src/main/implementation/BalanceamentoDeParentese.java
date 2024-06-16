package main.implementation;

import java.util.Set;
import java.util.Stack;

public class BalanceamentoDeParentese {

    public static boolean solve(String expression){
        Set<Character> openSymbols=Set.of('(','{','[');
        Set<Character> closeSymbols=Set.of(')','}',']');
        Stack<Character> stack = new Stack<>();
        
        for(char c: expression.toCharArray()){
            if (openSymbols.contains(c)) {
                stack.push(c);
            }
            if (closeSymbols.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var open = stack.pop();
                if (open=='('&&c!=')'||open=='{'&&c!='}'||open=='['&&c!=']') {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve("({[]})"));
        System.out.println(solve("({[])"));
    }
}
