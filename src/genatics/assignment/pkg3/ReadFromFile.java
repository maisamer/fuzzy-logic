/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genatics.assignment.pkg3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mustafa
 */
public class ReadFromFile {
    
    private int numberOfInputVariable;
    
    
    
    public static void ReadFile(String FILENAME) throws FileNotFoundException
    {
        ArrayList<Variables> Var=new <Variables>ArrayList();
        ArrayList<Variables> SubVar=new <Variables>ArrayList();
        ArrayList<Variables> OutputVar=new <Variables>ArrayList();
        ArrayList<Variables> OutputSubVar=new <Variables>ArrayList();
        
        float numbers;
        
        FileReader fr = new FileReader(FILENAME);
        BufferedReader br = new BufferedReader (fr);
        Scanner in = new Scanner (br);

        while (in.hasNextLine()) {
            System.out.println ( in.nextInt());
  }



      
        
    }

}
