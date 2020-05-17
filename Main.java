import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.stream.Stream;
import java.util.*;
// import java.io.File;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Argument is too short.");
            return;
        }
        String line_result = null;
        Path path = Paths.get(args[0]);
        int line_number = Integer.parseInt(args[1]);

        try (Stream<String> lines = Files.lines(path)) {
            line_result = lines.skip(line_number).findFirst().orElse(null);
            if (line_result == null) System.err.println("out of lines.");
            else System.out.println(line_result);
        }

        {
            List<String> lines = Files.readAllLines(path);
            if (lines.size() < line_number) System.err.println("out of lines.");
            else {
                line_result = lines.get(line_number);
                System.out.println(line_result);
            }
        }

        try (BufferedReader br = Files.newBufferedReader(path);
                Stream<String> lines = br.lines();) {
            line_result = lines.skip(line_number).findFirst().orElse(null);
            if (line_result == null) System.err.println("out of lines.");
            else System.out.println(line_result);
        }

        try (BufferedReader br = Files.newBufferedReader(path)) {
            // skip動作
            for (int i = 0; i < line_number; i++) {
                br.readLine();
            }
            if ((line_result = br.readLine()) == null) System.err.println("out of lines.");
            else System.out.println(line_result);
        }
    }
}