public class Utils{
    public int[] arrayCopy(int[] arr){
        int[] ac = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            ac[i] = arr[i];
        }
        return ac;
    }

    
}
