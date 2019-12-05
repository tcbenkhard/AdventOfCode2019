package nl.benkhard.aoc.instruction;

import nl.benkhard.aoc.program.Program;

public class ExitInstruction extends Instruction {
    public ExitInstruction(String[] parameterModes) {
        super(parameterModes);
    }

    @Override
    public int getNumberOfParameters() {
        return 0;
    }

    @Override
    public void execute(Program program) {
        program.stop();
    }
}
