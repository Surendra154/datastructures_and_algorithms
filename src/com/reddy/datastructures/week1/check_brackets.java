package com.reddy.datastructures.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        boolean isBalanced = true;
        boolean isPartiallyBalanced = false;
        int index = 0;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(new Bracket(next, position + 1)); // +1 since 1 indexing is needed as per the problem statement
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here

                Bracket bracket = null;
                if(!opening_brackets_stack.isEmpty()){ // eg: }[]()
                    bracket = opening_brackets_stack.pop();

                    if (!bracket.Match(next)){// implies its unbalanced return  position
                        isBalanced = false;
                        index = position+1;
                        break;
                    }else{
                        isPartiallyBalanced = true;
                    }
                }else {
                    isBalanced = false;
                    index = position+1;
                    break;
                }


            }
        }

        if(!opening_brackets_stack.isEmpty() && isPartiallyBalanced && index == 0){
            isBalanced=false;
            index = opening_brackets_stack.elementAt(0).position;
        }

        if(!opening_brackets_stack.isEmpty() && text.length() == opening_brackets_stack.size()){// for eg: {{{{{{{
            isBalanced=false;
            index = opening_brackets_stack.elementAt(0).position;
        }
        // Printing answer, write your code here
        if(isBalanced){
            System.out.println("Success");
        }else {
            System.out.println(index);
        }
    }
}
