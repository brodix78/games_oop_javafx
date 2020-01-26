package job4j.tictactoe;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return checkWin(x -> x.hasMarkX());
    }

    public boolean isWinnerO() {
        return checkWin(o -> o.hasMarkO());
    }

    private boolean checkWin(Predicate<Figure3T> who) {
        boolean rsl = false;
        int size = this.table.length;
        int cl = 0;
        int cr = 0;
        for (int i = 0; i < size; i++) {
            int v = 0;
            int g = 0;
            while (g < size && who.test(this.table[i][g++])) {}
            while (v < size && who.test(this.table[v++][i])) {}
            if (g == size || v == size) {
                rsl = true;
                break;
            }
        }
        while (cl < size && who.test(this.table[cl][cl++])) {}
        while (cr < size && who.test(this.table[cr][size - 1 - cr++])) {}
        return rsl || cl == size || cr == size;
    }

    public boolean hasGap() {
        return Arrays.stream(table).flatMap(Arrays::stream).
                filter(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO()).
                collect(Collectors.toList()).size() > 0;
    }
}