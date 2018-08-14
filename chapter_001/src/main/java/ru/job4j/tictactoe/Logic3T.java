package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /*
    весь цикл на выигрыш Х.
    .hasMarkX - это поле помеченное крестиком из класса figure3t
    в if указаны условия  для победы по диагонали, вертикали и горизонтали на столе 3х3
    при желании наверно можно поменять
    если не выполняется условие (!г) по диагонали, то проверяется горизонталь, далее вертикаль
    если хоть одно условие сходится то побеждает Х
     */
    public boolean isWinnerX() {
        boolean r = false;
        if (this.table[0][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[2][2].hasMarkX()
                || this.table[2][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[0][2].hasMarkX()) {
            r = true;
        }
        if (!r) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][0].hasMarkX() && this.table[i][1].hasMarkX() && this.table[i][2].hasMarkX()) {
                    r = true;
                    break;
                }
            }
        }
        if (!r) {
            for (int in = 0; in < this.table.length; in++) {
                if (this.table[0][in].hasMarkX() && this.table[1][in].hasMarkX() && this.table[2][in].hasMarkX()) {
                    r = true;
                    break;
                }
            }
        }
        return r;
    }

    /*
    весь цикл на выигрыш О.
    .hasMarkО - это поле помеченное ноликом из класса figure3t
     в if указаны условия  для победы по диагонали, вертикали и горизонтали на столе 3х3
     при желании наверно можно поменять
    если не выполняется условие (!г) по диагонали, то проверяется горизонталь, далее вертикаль
    если хоть одно условие сходится то побеждает О
     */
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

    /*
    для ничьей нужно чтобы в одном ряду по диагонали, вертикали и горизонтали не было одинаковых маркеров
    для этого юзаем метод из задания 6.8 на дубликаты
     */
    public boolean hasGap() {
        boolean result = false;
        /*
        перебор массива на совпадения
         */
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[i].length; j++) {
                /*
                если в ряду есть и х и о то бросает ничью
                 */
                if (!this.table[i][j].hasMarkX() & !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        /*
        если нет то бросает победу х или о
         */
        return result;
    }
}