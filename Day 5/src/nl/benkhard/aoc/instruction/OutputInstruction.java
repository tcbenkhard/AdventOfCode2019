package nl.benkhard.aoc.instruction;

import nl.benkhard.aoc.program.Program;

public class OutputInstruction extends Instruction {
    public OutputInstruction(String[] parameterModes) {
        super(parameterModes);
    }

    @Override
    public int getNumberOfParameters() {
        return 1;
    }

    @Override
    public void execute(Program program) {
        int valueA = parameterModes[0] == 0 ? program.readAddress(parameters[0]) : parameters[0];

        System.out.println(valueA);
    }
}
