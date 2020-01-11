package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void moveWhenClearWay(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        Cell[] rsl = {Cell.E3, Cell.F4, Cell.G5};
        assertThat(logic.move(Cell.D2, Cell.G5), is(true));
    }

    @Test
    public void moveWhenOnWay(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        logic.add(new BishopBlack(Cell.F4));
        assertThat(logic.move(Cell.D2, Cell.G5), is(false));
    }

    @Test
    public void moveWhenDistNotEmpty(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        logic.add(new BishopBlack(Cell.G5));
        assertThat(logic.move(Cell.D2, Cell.G5), is(false));
    }
}
