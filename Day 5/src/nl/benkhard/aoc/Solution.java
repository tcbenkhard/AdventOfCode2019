package nl.benkhard.aoc;

import nl.benkhard.aoc.program.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("Day 5/input.txt")));

        Program program = new Program(contents, 5);
        program.execute();
    }
}
