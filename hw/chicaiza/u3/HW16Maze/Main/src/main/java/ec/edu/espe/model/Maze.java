/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michael Chicaiza SOFTCRAF DCCO ESPE
 */
public class Maze {
    private final int width, height;
    private final Cell[][] cells;
    private int startX, startY, endX, endY;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                cells[y][x] = new Cell();
        generate();
    }

    private void generate() {
        Random rand = new Random();
        startX = 0;
        startY = rand.nextInt(height);
        endX = width - 1;
        endY = rand.nextInt(height);

        cells[startY][startX].left = false;  // Entrada
        cells[endY][endX].right = false;     // Salida

        dfs(startX, startY, rand);
    }

    private void dfs(int x, int y, Random rand) {
        cells[y][x].visited = true;
        List<int[]> dirs = new ArrayList<>(Arrays.asList(
            new int[]{0, -1}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{1, 0}
        ));
        Collections.shuffle(dirs, rand);

        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < width && ny < height && !cells[ny][nx].visited) {
                if (d[0] == 1) {
                    cells[y][x].right = false;
                    cells[ny][nx].left = false;
                } else if (d[0] == -1) {
                    cells[y][x].left = false;
                    cells[ny][nx].right = false;
                } else if (d[1] == 1) {
                    cells[y][x].bottom = false;
                    cells[ny][nx].top = false;
                } else if (d[1] == -1) {
                    cells[y][x].top = false;
                    cells[ny][nx].bottom = false;
                }
                dfs(nx, ny, rand);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
