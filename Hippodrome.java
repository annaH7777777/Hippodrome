package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    static  Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }
    public  Hippodrome(List<Horse> horses){
        this.horses = horses;

    }
    public void run() throws InterruptedException {
        for(int i = 0; i<100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (int i = 0; i<horses.size(); i++){
            horses.get(i).move();
        }
    }
    public void print(){
        for (int i = 0; i<horses.size(); i++){
            horses.get(i).print();
        }
        for (int i = 0; i<10; i++){
            System.out.println();
        }
    }
    public Horse getWinner(){
        double maxDistance = 0;
        for (int i = 0; i<horses.size(); i++){
            if (horses.get(i).distance >maxDistance)
                maxDistance = horses.get(i).distance;
        }
        Horse horse = null;
        for (int i = 0; i<horses.size(); i++){
            if (maxDistance == horses.get(i).distance) {
                horse = horses.get(i);
            }
        }
        return horse;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().name+"!");
    }

    public static void main(String[]args) throws InterruptedException {
        List<Horse> horses;
        game = new Hippodrome(new ArrayList<Horse>());

        Horse horse1 = new Horse("Blacky",3,0);
        Horse horse2 = new Horse("Gray",3,0);
        Horse horse3 = new Horse("White",3,0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();

        
    }
}
