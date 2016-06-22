import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String list_name;
		Scanner user_input = new Scanner( System.in );
		List<String> list_of_items =new ArrayList <String>(Arrays.asList(args));
		
		System.out.println("Name Your List");
		list_name = user_input.next( );
        list_of_items = GetList();
        String show = null;
          for ( int i = 0; i < list_of_items.size() - 1; i++){
        	  show += list_of_items.get(i);  
        	  // not last item in list insert comma
        	  if (i < list_of_items.size() - 1){
        		 show += ",:";  
        		  
        	  }
          }
            
        		

		System.out.println(list_name +": " + show );
	}
   private static List<String> GetList(){
	   System.out.println("Enter Item for your inventory Press x when finished");
        Scanner list_input = new Scanner(System.in);    	   
	    String temp_input = list_input.next().toString();
	    
	    List<String> list_of_items =new ArrayList <String>(Arrays.asList());
	    
	    while(temp_input != "x"){
	        list_input = new Scanner(System.in);
	    	list_of_items.add(temp_input);
	        System.out.println("Enter Item for your inventory Press x when finished (temp_input = "+temp_input+")");
	        temp_input = list_input.next().toString();
	       
	    }
			   
	   return list_of_items;   
   }
}
