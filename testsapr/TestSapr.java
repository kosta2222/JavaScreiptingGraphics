/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsapr;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author papa
 */
public class TestSapr {
 static int [] xPoints;  
 static int [] yPoints;
 static int n;
public static class MySapr extends JFrame{
 
	public static class Ris extends JPanel{
	public void paint(Graphics g){
Color c =new Color (0,0,255);
            g.setColor(c);
            setSize(500,500);		
n=xPoints.length;
g.drawPolyline(xPoints,yPoints,n);

	}
	}
        public MySapr() {
            setLayout(new FlowLayout());
            add(new Ris());
        }
  
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            ScriptEngine engine =
                new ScriptEngineManager().getEngineByName("javascript");
            //engine.eval(new FileReader("d:/program.js"));
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String s;
                while(!(s=reader.readLine()).equals("exit")){
                    if(s.matches("#include [a-z]+")){
                        String [] ar=s.split(" ");
                        String p="D:"+"\\"+ar[1]+".js";
                        engine.eval(new FileReader(p));
                  }
                    //System.out.println(s);
                    if(!s.matches("#include [a-z]+")){
                        System.out.println(engine.eval(s));
                    }
                }
        }
        catch(IOException ioEx)
        {
            ioEx.printStackTrace();
        }
        catch(ScriptException scrEx)
        {
            scrEx.printStackTrace();
        }
    }      
}
public  void doDrawPolyLine(int[] x,int[] y){
		xPoints=x;
		yPoints=y;
		n=xPoints.length;
                MySapr a=new MySapr();
		a.setVisible(true);
		a.setSize(700,700);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
    
    
}

