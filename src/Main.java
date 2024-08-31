import java.util.Arrays;
public class Main {
    public static void main(String[] args){

        int[] array = new int[] {10, 20, 20, 0, 10, 10, 20, 5, 20, 0, 0};
        int[][] num_frequencyTable = new int[array.length][2];
        initializeFrequencyTable(num_frequencyTable, -1);

        for (int i = 0; i < array.length; ++i){
            int frequency = 1;
            for (int k = i + 1; k < array.length; ++k){
                if(array[i] == array[k]){
                    frequency++;
                }
            }
            if (!isAlreadyCounted(num_frequencyTable, array[i])){
                addToFrequencyTable(num_frequencyTable, array[i], frequency);
            }
        }
        printTable(num_frequencyTable, false);
        printTable(num_frequencyTable, true);
    }
    static void addToFrequencyTable (int[][] table, int number, int frequency){
        for (int i = 0; i < table.length; i++)
            if(table[i][0] == -1){
                table[i][0] = number;
                table[i][1] = frequency;
                break;
            }
    }
    static boolean isAlreadyCounted(int[][] twoDimensionArray, int number){
        for (int i = 0; i < twoDimensionArray.length; ++i)
            if(number == twoDimensionArray[i][0])
                return true;

        return false;
    }
    static void initializeFrequencyTable(int[][] table, int val){
        for(int i = 0; i < table.length; ++i)
            Arrays.fill(table[i], val);
    }
    static void printTable(int[][] table, boolean detailed){
        for (int i = 0; i < table.length; i++){
            if(table[i][0] == -1)
                break;

            if(detailed){
                System.out.print(table[i][0] + " sayısı ");
                System.out.println(table[i][1] + " kere tekrar edildi.");
            } else {
                System.out.println(table[i][0] + " " + table[i][1]);
            }
        }
    }
}