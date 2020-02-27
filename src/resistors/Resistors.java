/*
 * Andrew Thompson
 * February 27, 2020
 * Outputs the value of a resistor when the colour code is input
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
        //array of all possible colours
        String[] colours = {"BLACK", "BROWN", "RED", "ORANGE",
            "YELLOW", "GREEN", "BLUE", "VIOLET", "GREY", "WHITE"};
        String input;
        
        try{
            //get user input
            input = JOptionPane.showInputDialog("What is your resistor colour code?\nSeparate each colour by hyphens\n"
                    + "Ex. Red-Orange-Black");
            
            //split input on the dashes to isolate individual colour inputs
            String[] inCols = input.split("-");
            //there should only be 3 colours
            if(inCols.length != 3){
                throw new RuntimeException();
            }
            int nums[] = new int[3];
            
            //find corresponding number depnding on colour
            for(int i = 0; i < 3; i++){
                boolean flag = false;
                //compare input text against array values to determine what number it should be
                for(int j = 0; j < colours.length; j++){            
                    if(inCols[i].equalsIgnoreCase(colours[j])){
                        nums[i] = j;
                        flag = true;
                    }
                }//throw exception if one of the input strings does not match with any of the colours
                if(!flag){
                    throw new RuntimeException();
                }
            }
            //the value of the resistor
            double value = (nums[0]*10 + nums[1])*(double)Math.pow(10, nums[2]);
            //output
            System.out.println("You entered " + input);
            System.out.println("The value of the resistor is: " + value + " Ohms");
            
        }catch(NullPointerException npe){
            System.exit(0);
        }catch(RuntimeException e){
            System.err.println("Invalid input. Program closing.");
        }
    }
}
