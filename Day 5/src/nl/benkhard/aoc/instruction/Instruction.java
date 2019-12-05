package nl.benkhard.aoc.instruction;

import nl.benkhard.aoc.program.Program;

public abstract class Instruction {
    protected int[] parameters;
    protected int[] parameterModes = {0, 0, 0};

    public static Instruction create(int opCode) {
        String opString = String.valueOf(opCode);
        int instruction;
        String[] modes = {"0", "0", "0"};
        if(opString.length() > 1) {
            instruction = Integer.parseInt(opString.substring(opString.length() - 2));
            modes = opString.substring(0, opString.length() - 2).split("");
        } else {
            instruction = Integer.parseInt(opString);
        }

        switch (instruction) {
            case 1:
                return new AddInstruction(modes);
            case 2:
                return new MultiplyInstruction(modes);
            case 3:
                return new InputInstruction(modes);
            case 4:
                return new OutputInstruction(modes);
            case 5:
                return new JumpIfTrueInstruction(modes);
            case 6:
                return new JumpIfFalseInstruction(modes);
            case 7:
                return new LessThanInstruction(modes);
            case 8:
                return new EqualsInstruction(modes);
            case 99:
                return new ExitInstruction(modes);
            default:
                return new ExitInstruction(modes);
        }
    }

    public abstract void execute(Program program);

    public Instruction(String[] parameterModes) {
        if(parameterModes[0].equals("")) return;
        for(int i = 0; i < this.parameterModes.length; i++) {
            if(parameterModes.length-i > 0) {
                this.parameterModes[i] = Integer.parseInt(parameterModes[parameterModes.length-1-i]);
            } else {
                this.parameterModes[i] = 0;
            }
        }
    }

    public void setParameters(int[] parameters) {
        this.parameters = parameters;
    }

    public int getInstructionSize() {
        return getNumberOfParameters() + 1;
    }

    public abstract int getNumberOfParameters();
}
