// COMP 251 A1
// Name: Haochen Liu
// No collaborators.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class a1_real {
	
	public static int silence(int[] positions) {
		// Store the pair of language and its latest index in positions
		Hashtable<Integer,Integer> latest_position= new Hashtable<Integer,Integer>();
		int size= positions.length;
		// Initialize the minimum distance by the size of positions.
		int min_distance = size;
		// index counter
		int index = 0;
		for(int student: positions){
			// If the language is already stored in latest_position,
			if(latest_position.containsKey(student)) {
				// calculate the distance between this index and most recent index.
				int toCheck = index - latest_position.get(student);
				// If it is less than the current minimum, update the minimum.
				if(toCheck < min_distance){
					min_distance = toCheck;
				}
			}
			// Update the latest position of this language.
			latest_position.put(student,index);
			index ++;
		}

		return min_distance;
	}

	public static void main(String[] args) {
		try {
			String path = args[0];
      		File myFile = new File(path);
      		Scanner sc = new Scanner(myFile);
      		int num_students = sc.nextInt();
      		int[] positions = new int[num_students];
      		for (int student = 0; student<num_students; student++){
				positions[student] =sc.nextInt();
      		}
      		sc.close();
      		int answer = silence(positions);
      		System.out.println(answer);
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
  	}		
}