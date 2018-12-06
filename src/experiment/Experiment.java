package experiment;

import java.util.ArrayList;

public class Experiment {
  static int n = 100000;
  static int e = 100*n;
  
  public static void main(String[] args){
    System.out.println("oli");
    ArrayList<Integer>[] al = new ArrayList[n];
    for(int i = 0; i < n-1; i++){
      al[i] = new ArrayList<Integer>();
      al[i].add(i+1);
    }
    al[n-1] = new ArrayList<Integer>();
    
    for(int i = 0; i < e-(n-1); i++){
      int salida = (int) (Math.random() * n) ;
      int entrada = (int) (Math.random() * n) ;
      
      al[salida].add(entrada);
      if(i%1000==0)
        System.out.println(i);
    }
    System.out.println("oli");
  }

}
