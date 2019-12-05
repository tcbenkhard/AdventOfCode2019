package nl.benkhard.aoc.program;

import nl.benkhard.aoc.instruction.Instruction;

import java.util.Arrays;

public class Program {
    private int pointer=0;
    private int[] memory;
    private boolean running;
    private int input;

    public Program(String programCode, int input) {
        String[] memoryStrings = programCode.split(",");
        memory = new int[memoryStrings.length];
        for(int i = 0; i < memoryStrings.length; i++) {
            memory[i] = Integer.parseInt(memoryStrings[i]);
        }
        this.input = input;
    }

    public int readAddress(int address) {
        return memory[address];
    }

    public void writeAddress(int address, int value) {
        memory[address] = value;
    }

    public void execute() {
        running = true;
        while(running) {
            Instruction instruction = Instruction.create(memory[pointer]);
            if(instruction.getNumberOfParameters() > 0) {
                int[] parameters = Arrays.copyOfRange(memory, pointer+1, pointer+instruction.getNumberOfParameters()+1);
                instruction.setParameters(parameters);
            }
            instruction.execute(this);
            pointer += instruction.getInstructionSize();
        }
    }

    public void printMemory() {
        for(int i = 0; i < memory.length; i++) {
            System.out.println(String.format("%d: %d", i, memory[i]));
        }
    }

    public int getInput() {
        return input;
    }

    public void stop() {
        running = false;
//        printMemory();
    }

    public void setPointer(int parameter) {
        pointer = parameter;
    }
}