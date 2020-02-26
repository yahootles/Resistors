/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resistors;

import javax.swing.JOptionPane;

/**
 *
 * @author antho6229
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] colours = {"BLACK", "BROWN", "RED", "ORANGE",
            "YELLOW", "GREEN", "BLUE", "VIOLET", "GREY", "WHITE"};
        String input;
        
        try{
            input = JOptionPane.showInputDialog("What is your resistor colour code?\nSeparate each colour by hyphens\n"
                    + "Ex. Red-Orange-Black");
            
            String[] inCols = input.split("-");
            if(inCols.length != 3){
                throw new RuntimeException();
            }
            int nums[] = new int[3];
            
            for(int i = 0; i < 3; i++){
                boolean flag = false;
                for(int j = 0; j < colours.length; j++){            
                    if(inCols[i].equalsIgnoreCase(colours[j])){
                        nums[i] = j;
                        flag = true;
                    }
                }
                if(!flag){
                    throw new RuntimeException();
                }
            }
            
            double value = (nums[0]*10 + nums[1])*(double)Math.pow(10, nums[2]);
            System.out.println(value);
        }catch(NullPointerException npe){
            System.exit(0);
        }catch(RuntimeException e){
            System.err.println("Invalid input. Program closing.");
        }
    }
}
