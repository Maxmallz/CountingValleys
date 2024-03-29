import java.io.*;
import java.util.*;

public class Main {
    static int seaLevel = 0;

    static boolean isSeaLevel(){
        return seaLevel == 0;
    }

    static boolean isBelowSeaLevel(){
        return seaLevel < 0;
    }

    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        boolean isLikelyValley = false;
        char[] directions = s.toCharArray();

        for(int i = 0; i < n; i++){
            if(directions[i] == 'D'){seaLevel --;}
            else if(directions[i] == 'U'){seaLevel ++;}

            while(isBelowSeaLevel()){
                i++;
                if(directions[i] == 'D'){seaLevel --;}
                else if(directions[i] == 'U'){
                    seaLevel ++;
                    if(isSeaLevel()){
                        valleyCount++;
                        break;
                    }
                }
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
