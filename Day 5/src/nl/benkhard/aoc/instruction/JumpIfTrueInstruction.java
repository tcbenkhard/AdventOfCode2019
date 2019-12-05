package nl.benkhard.aoc.instruction;

import nl.benkhard.aoc.program.Program;

public class JumpIfTrueInstruction extends Instruction {
    private int instructionSize;

    public JumpIfTrueInstruction(String[] parameterModes) {
        super(parameterModes);
        instructionSize = getNumberOfParameters()+1;
    }

    @Override
    public int getNumberOfParameters() {
        return 2;
    }

    @Override
    public void execute(Program program) {
        int valueA = parameterModes[0] == 0 ? program.readAddress(parameters[0]) : parameters[0];
        int valueB = parameterModes[1] == 0 ? program.readAddress(parameters[1]) : parameters[1];
        if(valueA != 0) {
            program.setPointer(valueB);
            instructionSize = 0;
        }
    }

    @Override
    public int getInstructionSize() {
        return instructionSize;
    }
}
