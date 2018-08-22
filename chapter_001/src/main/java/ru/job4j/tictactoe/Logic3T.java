package ru.job4j.tictactoe;
public class Logic3T {
    private final Figure3T[][] table;
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }
    public boolean isWinnerX() {
        boolean result = false;
        if (this.table[0][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[2][2].hasMarkX()
                || this.table[2][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[0][2].hasMarkX()) {
            result = true;
        }
        if (!result) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][0].hasMarkX() && this.table[i][1].hasMarkX() && this.table[i][2].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            for (int in = 0; in < this.table.length; in++) {
                if (this.table[0][in].hasMarkX() && this.table[1][in].hasMarkX() && this.table[2][in].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    public boolean isWinnerO() {
        boolean r = false;
        if (this.table[0][0].hasMarkO() && this.table[1][1].hasMarkO() && this.table[2][2].hasMarkO()
                || this.table[2][0].hasMarkO() && this.table[1][1].hasMarkO() && this.table[0][2].hasMarkO()) {
            r = true;
        }
        if (!r) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][0].hasMarkO() && this.table[i][1].hasMarkO() && this.table[i][2].hasMarkO()) {
                    r = true;
                    break;
                }
            }
        }
        if (!r) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[0][i].hasMarkO() && this.table[1][i].hasMarkO() && this.table[2][i].hasMarkO()) {
                    r = true;
                    break;
                }
            }
        }
        return r;
    }
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[i].length; j++) {
                if (!this.table[i][j].hasMarkX() & !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}