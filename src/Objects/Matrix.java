/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author luisl
 */
public class Matrix {
    private Box [][]boxes = new Box [9][9];
    
    private Integer random1;
    private Integer random2;
    private Integer [][]values={{2, 1, 5, 9, 3, 8, 4, 6, 7},
                                {7, 8, 6, 1, 2, 4, 3, 5, 9},
                                {9, 3, 4, 6, 5, 7, 2, 8, 1},
                                {8, 6, 9, 5, 4, 2, 1, 7, 3},
                                {1, 4, 3, 7, 8, 6, 5, 9, 2},
                                {5, 2, 7, 3, 9, 1, 8, 4, 6},
                                {6, 7, 2, 4, 1, 5, 9, 3, 8},
                                {4, 9, 8, 2, 6, 3, 7, 1, 5},
                                {3, 5, 1, 8, 7, 9, 6, 2, 4}};
    
    public Matrix(Integer difficulty){
        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++){
                this.boxes[i][j] = new Box();
            }
        }
        for(int i=0;i<difficulty;i++){
            this.setRandom();
            this.boxes[this.random1][this.random2].setShow(true);
        }
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.boxes[i][j].setValue(this.values[i][j]);
            }
        }
    }
    
    public void printAll(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(this.boxes[i][j].getShow()){
                    System.out.print(this.boxes[i][j].getValue()+" ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }
    
    public void setRandom(){
        ArrayList<Random> random= new ArrayList<>();
        this.random1=(int)(Math.random()*9);
        this.random2=(int)(Math.random()*9);
        random.add(new Random(random1,random2));
    }

    public Box[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(Box[][] boxes) {
        this.boxes = boxes;
    }

    public Integer getRandom1() {
        return random1;
    }

    public void setRandom1(Integer random1) {
        this.random1 = random1;
    }

    public Integer getRandom2() {
        return random2;
    }

    public void setRandom2(Integer random2) {
        this.random2 = random2;
    }
    
    
}
