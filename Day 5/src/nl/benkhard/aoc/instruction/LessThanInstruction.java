package nl.benkhard.aoc.instruction;

import nl.benkhard.aoc.program.Program;

public class LessThanInstruction extends Instruction {
    public LessThanInstruction(String[] parameterModes) {
        super(parameterModes);
    }

    @Override
    public int getNumberOfParameters() {
        return 3;
    }

    @Override
    public void execute(Program program) {
        int valueA = parameterModes[0] == 0 ? program.readAddress(parameters[0]) : parameters[0];
        int valueB = parameterModes[1] == 0 ? program.readAddress(parameters[1]) : parameters[1];
        int destinationAddress = parameterModes[2] == 0 ? parameters[2] : program.readAddress(parameters[2]);

        if(valueA < valueB) {
            program.writeAddress(destinationAddress, 1);
        } else {
            program.writeAddress(destinationAddress, 0);
        }
    }
}
