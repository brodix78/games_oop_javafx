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
        int size = table.length;
        int cl = 0;
        int cr = 0;
        for (int i = 0; i < size; i++) {
            int v = 0;
            int g = 0;
            for (int n = 0; n < size; n++) {
                if (who.test(table[i][n])) {
                    g++;
                }
                if (who.test(table[n][i])) {
                    v++;
                }
            }
            if (g == size || v == size) {
                rsl = true;
                break;
            }
            if (who.test(table[i][i])) {
                cl++;
            }
            if (who.test(table[i][size - i - 1])) {
                cr++;
            }
        }
        if (cl == size || cr == size) {
            rsl = true;
        }
        return rsl;
    }

    public boolean hasGap() {
        return Arrays.stream(table).flatMap(Arrays::stream).
                filter(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO()).
                collect(Collectors.toList()).size() > 0;
    }
}