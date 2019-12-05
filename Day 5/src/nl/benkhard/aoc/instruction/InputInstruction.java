package nl.benkhard.aoc.instruction;

import nl.benkhard.aoc.program.Program;

public class InputInstruction extends Instruction {

    public InputInstruction(String[] parameterModes) {
        super(parameterModes);
    }

    @Override
    public int getNumberOfParameters() {
        return 1;
    }

    @Override
    public void execute(Program program) {
        int input = program.getInput();
        program.writeAddress(parameters[0], input);
    }
}
