package Unit3.Test3_7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个简单的抽奖游戏
 */
public class LotteryDrawing {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        //fill an array with number 1 2 3 ... n
        int [] number = new int[n];
        for(int i = 0;i<number.length;i++){
            number[i] = i + 1;
        }

        int [] result = new int [k];
        for(int i = 0; i < result.length; i++){
            int r =(int)(Math.random()*n);

            result[i] = number[r];
            number[r] = number[n-1];
            n--;
        }

        Arrays.sort(result);
        System.out.print("Bet the following combination. It'll make you rich!");
        for(int r:result){
            System.out.printf("%d\t",r);
        }
    }
}

