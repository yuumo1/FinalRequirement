/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalrequirement;

/**
 *
 * @author Erika
 */
import java.util.Scanner;
public class FinalRequirement {

    //to check if a number is prime number
    private static boolean isPrime(int num){
        if (num<2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
    }
        return true;
}
    
    // this performs merge sorting on the characters
     private static void mergeSort(char[] arr, int low, int high) {
        if (low < high) {
            int mid =  low + (high - low) / 2;
            // Recursive calls for left and right halves
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            // Merge the sorted halves
            merge(arr, low, mid, high);
        }
    }// Function to merge two halves of an array
    private static void merge(char[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Creating temporary arrays
        char[] left = new char[n1];
        char[] right = new char[n2];

        // Copy data to temporary arrays left[] and right[]


    for (int i = 0; i < n1; ++i)
            left[i] = arr[low + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = low;
        
        while (i < n1 && j < n2) {
            if (left[i] >= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[], if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[], if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

        public static void main(String[] args) {
        
          Scanner scanner = new Scanner(System.in);
        //instantiate 
        boolean run = true;
        boolean correct = true;
        boolean asdads= true;
        
        //while loop for input statements with conditions
        while(run){
        int count=0;
        int i=0;
        
         System.out.println("Enter a comma-separated list of alphabetical and special characters:");
         String input = scanner.nextLine();
         String[] charArray2 = input.split(",");
         for(String temp: charArray2){
         
         charArray2[i]=temp;
         i++;
         
         count++;
         }
         for(i=0; i<count; i++){
             //using regex for character length
             if(charArray2[i].length()!=1 ||  input.matches(".*\\d.*") ||
                input.endsWith(",")){
                         System.out.println("Invalid input! Please enter a valid list without numerical or floating-point values, and ensure proper commas. \n");
             // to check if input is correct         
         correct=false;   
             break;
         }
             
             else{
                 correct=true;
              
                     }
             
        }
        // replacing input comma
        if(correct){
            input = input.replaceAll(",", "");
        char[] charArray = input.toCharArray();
        
        //
       
        int index = 0;
        
        StringBuilder sb = new StringBuilder(charArray.length);
        for (Character c : charArray) {
            if (!isPrime((int)c)) {
       
                
               sb.append(c.charValue());
           
           }
            
        }
       
        // convert to String
        String test = sb.toString();
        // ascending order
        char[] array = test.toCharArray();
        for(char c: array){
        array[index++]=c;
     
        }
        //using merge sort to display output in descending order
        mergeSort(array, 0, index - 1);

        System.out.println("Sorted and filtered result: " + String.valueOf(array));
        
            run=false;       
        
        // Ask user to run again or exit
        System.out.println("Do you want to run again? (yes/no)");
        String runAgain = scanner.nextLine().toLowerCase();
        
        while (asdads){
            
        //Recursively call the main method if the user wants to run again
        if ("yes".equals(runAgain)) {
            main(args);
            break;
        } else if("no".equals(runAgain)){
            System.out.println("Exiting the program.");
            asdads = false;
        }
        
        else {
            System.out.println("Please choose between yes or no.");
            runAgain = scanner.nextLine().toLowerCase();
        }
        }  
        }
        
        }
    }
}