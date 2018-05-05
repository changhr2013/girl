import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public void combinations(List<Integer> selectedList,List<Integer> data,int n){

        if(data.isEmpty()){
            return;
        }

        if(n==0){
            for (Integer i : selectedList) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        selectedList.add(data.get(0));
        combinations(selectedList,data.subList(1,data.size()),n-1);

        selectedList.remove(selectedList.size()-1);
        combinations(selectedList,data.subList(1,data.size()),n);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combinations(new ArrayList<>(), Arrays.asList(1,2,3),2);
    }
}