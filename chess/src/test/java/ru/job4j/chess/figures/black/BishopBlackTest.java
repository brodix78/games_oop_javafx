package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        Figure bishop = new BishopBlack(Cell.C5);
        assertThat(bishop.position(), is (Cell.C5));
    }

    @Test
    public void copyTest() {
        Figure bishop = new BishopBlack(Cell.D3);
        bishop = bishop.copy(Cell.A4);
        assertThat(bishop.position(), is (Cell.A4));
    }

    @Test
    public void wayTest() {
        Cell[] rsl = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(new BishopBlack(Cell.C1).way(Cell.C1, Cell.G5), is (rsl));
    }
}
