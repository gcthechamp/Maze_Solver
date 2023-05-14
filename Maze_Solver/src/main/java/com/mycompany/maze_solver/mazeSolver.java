/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Gopal Satyam
 */
public class mazeSolver extends JFrame 
{
  private int[][] maze = 
  {{1,1,1,1,1,1,1,1,1,1,1,1,1},
   {1,0,1,0,0,1,0,1,0,0,0,1,1},
   {1,0,0,0,0,0,1,1,1,1,0,0,1},
   {1,0,1,0,1,0,0,1,1,0,0,0,1},
   {1,0,1,0,0,0,0,0,0,1,1,0,1},
   {1,0,0,0,1,0,0,1,0,1,1,0,1},
   {1,0,0,0,0,1,0,1,0,1,1,0,1},
   {1,1,1,1,0,1,0,1,0,0,1,0,1},
   {1,0,1,0,0,0,0,0,0,0,0,9,1},
   {1,1,1,1,1,1,1,1,1,1,1,1,1}};
  
   List<Integer> path = new ArrayList<>();
   
   public mazeSolver()
   {
       this.setTitle("Maze Solver");
       this.setSize(1000,500);
       this.setVisible(true);
     
       this.setLayout(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       DFS.dfs(maze, 1, 1, path);
       //System.out.print(path);
       
       
       
   }
   
   @Override
   public void paint(Graphics g)
   {
       g.translate(100,100);
       //Filling rectangle grids with colors
       for(int i=0; i<maze.length; i++)
       {
           for(int j=0; j<maze[0].length; j++)
           {
               Color color; //color object will be used to do the coloring
               switch(maze[i][j])
               {
                   case 1 : color = Color.WHITE; //coloring the obstacles
                            break;
                   case 9 : color = Color.BLUE; //coloring the destination grid
                            break;
                   default : color = Color.BLACK; //coloring the pathways
               }  
               g.setColor(color); //Setting the color selected for coloring the current grid
               g.fillRect(30*j, 30*i, 30, 30); //deciding each grid to be 30 width and 30 height and filling it with color
               
               g.setColor(Color.RED); //Setting the color for the borders of the grids
               g.drawRect(30*j,30*i,30,30); //Drawing the borders
           }
       }
       
       for(int i=0; i<path.size(); i+=2)
       {
           int pathX = path.get(i);
           int pathY = path.get(i+1);
           
           g.setColor(Color.GREEN);
           g.fillRect(30*pathX, 30*pathY, 20, 20);
       }
   }
           
   public static void main(String[] args)
   {
       mazeSolver ms = new mazeSolver();
   }
}
 
   

