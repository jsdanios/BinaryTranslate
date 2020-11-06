package com.practice.BinaryTranslate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    public String textToBinary(String text) {
        StringBuilder result = new StringBuilder();
        char[] letters = text.toCharArray();
        for (char letter : letters) {
            result.append(String.format("%8s", Integer.toBinaryString(letter)).replaceAll(" ", "0"));
        }
        String output = result.toString();
        List<String> blocks = new ArrayList<>();
        int index = 0;
        while (index < output.length()) {
            blocks.add(output.substring(index, Math.min(index + 8, output.length())));
            index += 8;
        }
        return blocks.stream().collect(Collectors.joining(" "));
    }

    public String binaryToText(String binary) {
        StringBuffer result = new StringBuffer();
        if (binary.matches("[0-1\s]+")) {
            binary = binary.replaceAll("\\s", "");
            if (binary.length() % 8 == 0) {
                for (int i = 0; i < binary.length(); i += 8) {
                    result.append((char) Integer.parseInt(binary.substring(i, i + 8), 2));
                }
                return result.toString();
            } else {
                return "Make sure each code is the proper length. Try again.";
            }
        } else {
            return "Binary does not contain letters or symbols. Try again.";
        }
    }

}
