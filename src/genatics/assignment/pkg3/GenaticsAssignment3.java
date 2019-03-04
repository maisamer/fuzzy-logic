/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genatics.assignment.pkg3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mai
 */
public class GenaticsAssignment3 {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<memberShip> membship=new <memberShip>ArrayList();
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ArrayList<Variables> Var=new <Variables>ArrayList(); // = var1 10 2
        ArrayList<SubVariables> SubVar=new <SubVariables>ArrayList(); // input fuzzy sets
        ArrayList<Variables> OutputVar=new <Variables>ArrayList();  //output outvar name
        ArrayList<SubVariables> OutputSubVar=new <SubVariables>ArrayList();    //output fuzzy sets    
        ArrayList<makeRules> OutputVarfromRules=new <makeRules>ArrayList();
        ArrayList<makemap> forcenterpoint=new ArrayList<makemap >();
        double  todivvalue=0.0,todivsetname=0.0;
        File file = new File("D:\\material\\GA\\ass3\\sample.txt");

    try {
        // take input
        Scanner sc = new Scanner(file);
        int numbers,n2 = 0;
        numbers=sc.nextInt();
        for(int e=0;e<numbers;e++)
        {
         String name=sc.next();
         float value=sc.nextFloat();
         int numofset=sc.nextInt();
         Var.add(new Variables(name,value,numofset));
         
         for(int a=0;a<numofset;a++)
         {
            String s1,s2;
            s1=sc.next();
            s2=sc.next();
            //System.out.println(s1+" "+s2);
            if(s2.equals("trapezoidal"))
            {
               SubVar.add(new SubVariables(s1,s2,sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),sc.nextFloat()));

            }
            else 
            {
               SubVar.add(new SubVariables(s1,s2,sc.nextFloat(),sc.nextFloat(),sc.nextFloat()));             
            }
         }
        }   
        String name=sc.next();
        int num = sc.nextInt(); 
        OutputVar.add(new Variables(name,num));
        for(int e=0;e<num;e++)
        {
            String s1,s2;
            s1=sc.next();
            s2=sc.next();
            if(s2.equals("trapezoidal"))
            {
               OutputSubVar.add(new SubVariables(s1,s2,sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),sc.nextFloat()));
            }
            else 
            {
               OutputSubVar.add(new SubVariables(s1,s2,sc.nextFloat(),sc.nextFloat(),sc.nextFloat()));             
            }
        }
        int rulenumber; // rule numbers
        rulenumber=sc.nextInt();
        //System.out.println(rulenumber);
        // 2 var1 = Left AND var2 = A outputVar = X
        ArrayList<String> Inputs=new <String>ArrayList(); // var1
        ArrayList<String> Values=new <String>ArrayList(); // left
        ArrayList<String> Output=new <String>ArrayList(); // outvar
        ArrayList<String> OutputV=new <String>ArrayList();  // right      
        ArrayList<String> Logic=new <String>ArrayList();   // and or             
        ArrayList<Integer> f=new <Integer>ArrayList(); // number of premises
        ArrayList<Double> outp=new <Double>ArrayList(); //result of rules
        //rule input
        for(int e=0;e<rulenumber;e++)
        {
            f.add(sc.nextInt());
            for(int r=0;r<f.get(e);r++)
            {
                Inputs.add(sc.next());
                sc.next();
                Values.add(sc.next());
                if(r!=f.get(e)-1)
                 Logic.add(sc.next());
            }
            Output.add(sc.next());
            sc.next();
            OutputV.add(sc.next());             
        }
        
        //-----------fuzzy step -----------\\
        int c=0;
        for(int i=0;i<Var.size();i++){
            int sets=Var.get(i).geNumberOfSet();
            float vle =Var.get(i).getValue();            
            for(int j=0;j<sets;j++,c++){
                String shape =SubVar.get(c).getShapeName();
                String firstname = SubVar.get(c).getSubName();
                float x1,x2,x3,x4;
                x1=SubVar.get(c).getX1();
                x2=SubVar.get(c).getX2();
                x3=SubVar.get(c).getX3();
                double slp = 0;
                if(shape.equals("triangle")){//tringle
                  if(x1!=x2&&x1!=x3&&x2!=x3){//mid
                      if(vle>x1&&vle<x2){
                          slp = Function(x1,0,x2,1,vle);
                      }else if(vle>x2&&vle<x3){
                          slp = Function(x2,1,x3,0,vle);
                      }else{
                          slp = 0;
                      }
                  }
                  if(x2==x3||x1==x2){ // low or high
                     if(x1==x2)
                         x2=x3;
                     if(j==0){ // low
                        if(vle>x1&&vle<x2)
                            slp = Function(x1,1,x2,0,vle);
                        else if(vle==x1)
                            slp=1;
                        else
                            slp=0;
                     }
                     else{ //high
                        if(vle>x1&&vle<x2) 
                            slp = Function(x1,0,x2,1,vle);
                        else if(vle==x2)
                            slp=1;
                        else
                            slp=0;                           
                     }
                      
                  }
                  
                }else{ //trapezoidal
                   x4=SubVar.get(c).getX4();
                   if(!equal(x1,x2,x3,x4)){ // mid
                       if(vle>x1&&vle<x2)
                           slp = Function(x1,0,x2,1,vle);
                       
                       else if(vle>=x2&&vle<=x3)
                           slp =1;
                       
                       else if(vle>x3&&vle<x4)
                          slp = Function(x3,1,x4,0,vle); 
                       else
                           slp=0;
                   }
                   else{ // low or high
                      if(j==0){ // low
                          if(vle>=x2&&vle<=x3)
                              slp=1;
                          else if(vle>x3&&vle<x4)
                              slp = Function(x3,1,x4,0,vle);
                          else
                              slp=0;
                      }
                      else{ // high
                        if(vle>=x2&&vle<=x3)
                              slp=1;
                          else if(vle>x1&&vle<x2)
                              slp = Function(x1,0,x2,1,vle);
                          else
                              slp=0; 
                      }
                   }
                   
                }
                membship.add(new memberShip(firstname, shape,Var.get(i).getName(), slp));
                
            }
        }
        // print membership
        c=0;
        for(int i=0;i<Var.size();i++){
            System.out.println(Var.get(i).getName()+" :");
            for(int j=0;j<Var.get(i).geNumberOfSet();j++,c++){
                System.out.println("Nem ( " +membship.get(c).SubName +" "+membship.get(c).ShapeName+" ) = "+membship.get(c).vlue);
            }
        }
        
        // Inference of rules 
        c=0;
        int lg=0;
        for(int e=0;e<rulenumber;e++)
        {
            double s1=search(Inputs.get(c),Values.get(c));
            c++;
            for(int t=1;t<f.get(e);t++)
            {
                String l=Logic.get(lg);
                lg++;
                double s2=search(Inputs.get(c),Values.get(c));
                if(l.equals("AND")){
                    s1 = Math.min(s1,s2);
                }else{
                    s1 = Math.max(s1, s2);
                }
                c++;               
            }
            outp.add(s1);
                      
        }
        //print rules output
        for(int e=0;e<rulenumber;e++){
            int y=e+1;
            System.out.println("output of rule "+y+" is "+outp.get(e)+" "+OutputV.get(e));
            OutputVarfromRules.add(new makeRules(OutputV.get(e), outp.get(e)));
        }
        
       ///////////////////////////////////////////last 
       for(int i=0;i<OutputSubVar.size();i++){
            if(OutputSubVar.get(i).getShapeName().equals("triangle")){
                String  s=OutputSubVar.get(i).getSubName();
                Float ce=OutputSubVar.get(i).getX2();
                if(i==0||i+1==OutputSubVar.size()){ ce=OutputSubVar.get(i).getX3();}
                makemap p1=new makemap(s, ce);
                forcenterpoint.add(p1);
                
            }
            
                
        }
      
         for(int i=0;i< OutputVarfromRules.size();i++){
            todivvalue+= OutputVarfromRules.get(i).getValue();
         }
         for(int i=0;i< OutputVarfromRules.size();i++){
            for(int j=0;j<OutputSubVar.size();j++){
                if(OutputSubVar.get(j).getShapeName().equals("triangle")&&OutputSubVar.get(j).getSubName().equals( OutputVarfromRules.get(i).getName())){
                    for(int x=0;x<forcenterpoint.size();x++){
                        if(forcenterpoint.get(x).name.equals(OutputVarfromRules.get(i).getName())){
                            double v=forcenterpoint.get(x).centerpoint*OutputVarfromRules.get(i).getValue();
                            todivsetname+=v;
                        }
                    }
                }
                
                else if(OutputSubVar.get(j).getShapeName().equals("trapezoidal")&&OutputSubVar.get(j).getSubName().equals( OutputVarfromRules.get(i).getName())){
                    Float x1,x2,x3,x4;
                    x1=OutputSubVar.get(j).getX1();
                    x2=OutputSubVar.get(j).getX2();
                    x3=OutputSubVar.get(j).getX3();
                    x4=OutputSubVar.get(j).getX4();
                    ArrayList<Float>x=new  ArrayList<Float>();
                    ArrayList<Double>y=new  ArrayList<Double>();
                    if(x1==x2){
                        //x1,x2,x3=1,x4=0
                        x.add(x1);y.add(1.0);
                         x.add(x2);y.add(1.0);
                          x.add(x3);y.add(1.0);
                           x.add(x4);y.add(0.0);
                        
                    }else if(x3==x4){
                        //x1=0,x2=1x3=1,x4=1
                         x.add(x1);y.add(0.0);
                         x.add(x2);y.add(1.0);
                          x.add(x3);y.add(1.0);
                           x.add(x4);y.add(1.0);
                    }else{
                        //x1=0,x4=0
                        //x2=1,x3=1
                          x.add(x1);y.add(0.0);
                         x.add(x2);y.add(1.0);
                          x.add(x3);y.add(1.0);
                           x.add(x4);y.add(0.0);
                    }
                    //Get A
                    double A=0.0;
                    double bigR=0.0;
                    double forcx=0.0,forcy=0.0;
                    int G=x.size()-1;
                    for(int p=0;p<G;p++){
                        double p1=x.get(p)*y.get(p+1);
                        double p2=x.get(p+1)*y.get(p);
                        double r=p1-p2;
                         bigR+=r;
                         double rr=x.get(p)+x.get(p+1);
                         forcx+=(rr*r);
                         forcy+=(y.get(p)+y.get(p+1))*r;
                    }
                    A=bigR*0.5;
                    double Cx=(1/(6*A))*forcx;
                    double Cy=(1/(6*A))*forcy;
                    double v1=Cx*OutputVarfromRules.get(i).getValue();
                    todivsetname+=v1;
                }
        }
      }
      
       //////////////////////////////////////////end last 
        System.out.println(todivvalue/todivsetname);
        sc.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
        
    }
    
}       //
     public static double Function(float x1,float y1,float x2,float y2,float Xvalue)// output return value of y
    {
        double Slope;
        Slope=(y2-y1)/(x2-x1);        
        return (Slope*(Xvalue-x1))+y1;

    }

    private static boolean equal(float x1, float x2, float x3, float x4) {
        return (x1==x2||x1==x3||x1==x4||x2==x3||x2==x4||x3==x4);
    }

    private static double search(String get, String get0) {
        for(int i=0;i<membship.size();i++){
            if(get.equals(membship.get(i).varName)&&get0.equals(membship.get(i).SubName))
                return membship.get(i).vlue;
        }
        return -1;
    }
    
}
