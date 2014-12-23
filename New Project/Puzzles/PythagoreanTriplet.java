import java.util.HashSet;
import java.util.Set;


public class PythagoreanTriplet{

     public static void main(String []args){
      
    int a[] ={9, 2, 3, 4, 8, 5, 6, 10};
    System.out.println("Answer : "+findAllPythogoreanTriplets(a));
     }
     
      
/**
 * Step1: Square each of the elements in the array [O(n)]
 * Step2: Sort the array [O(n logn)]
 * Step3: For each element in the array, find all the pairs in the array whose sum is equal to that element [O(n2)]
 * 
 * Time Complexity: O(n2) 
 */
 
public static Set<Set<Integer>> findAllPythogoreanTriplets(int [] unsortedData) {

    // O(n) - Square all the elements in the array
    for (int i = 0; i < unsortedData.length; i++)
        unsortedData[i] *= unsortedData[i];

    // O(n logn) - Sort
    QuickSort sorter =  new QuickSort();
    sorter.sort(unsortedData);
    int [] sortedSquareData = unsortedData;
  		
    // O(n2)
    Set<Set<Integer>> triplets = new HashSet<Set<Integer>>();

    for (int i = 0; i < sortedSquareData.length; i++) {

        Set<Set<Integer>> pairs = findAllPairsThatSumToAConstant(sortedSquareData, sortedSquareData[i]);

        for (Set<Integer> pair : pairs) {
            Set<Integer> triplet = new HashSet<Integer>();
            for (Integer n : pair) {
                triplet.add((int)Math.sqrt(n));
            }
            triplet.add((int)Math.sqrt(sortedSquareData[i])); // adding the third element to the pair to make it a triplet
            triplets.add(triplet);
        }
    }

    return triplets;
}


public static Set<Set<Integer>> findAllPairsThatSumToAConstant(int [] sortedData, int constant) {

    // O(n)
    Set<Set<Integer>> pairs = new HashSet<Set<Integer>>();
    int p1 = 0; // pointing to the first element
    int p2 = sortedData.length - 1; // pointing to the last element
    while (p1 < p2) {
        int pointersSum = sortedData[p1] + sortedData[p2];
        if (pointersSum > constant)
            p2--;
        else if (pointersSum < constant)
            p1++;
        else {
            Set<Integer> set = new HashSet<Integer>();
            set.add(sortedData[p1]);
            set.add(sortedData[p2]);
            pairs.add(set);
            p1++;
            p2--;
        }
    }
    return pairs;
}
}
