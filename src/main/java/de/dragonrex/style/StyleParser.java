package de.dragonrex.style;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StyleParser {

    public static Map<String, Object> parse(String style) {
        Map<String, Object> styleMap = new HashMap<>();

        String[] parts = style.split(" ");
        for (String part : parts) {
            if (part.startsWith("w-")) {
                // Bsp: w-200
                styleMap.put("width", Integer.parseInt(part.substring(2)));
            } else if (part.startsWith("h-")) {
                // Bsp: h-50
                styleMap.put("height", Integer.parseInt(part.substring(2)));
            } else if (part.startsWith("bg-[#")) {
                // Bsp: bg-[#5c4fe8]
                styleMap.put("bg.color", part.substring(4, part.length() - 1));
            } else if (part.startsWith("text-[#")) {
                // Bsp: text-[#e7e5f0]
                styleMap.put("text.color", part.substring(6, part.length() - 1));
            } else if (part.startsWith("rounded-")) {
                String size = part.substring(8);
                int radius = 0;
                switch(size) {
                    case "sm" -> radius = 2;
                    case "md" -> radius = 6;
                    case "lg" -> radius = 8;
                    case "xl" -> radius = 12;
                    case "2xl" -> radius = 16;
                    case "3xl" -> radius = 24;
                    case "full" -> radius = 999;
                    default -> {
                        if (size.startsWith("[") && size.endsWith("]")) {
                            try {
                                radius = Integer.parseInt(size.substring(1, size.length() - 1));
                            } catch (NumberFormatException e) {}
                        }
                    }
                }
                styleMap.put("border.radius", radius);
            }

            switch (part) {
                case "font-arial" -> styleMap.put("font.family", "Arial");
                case "font-sans" -> styleMap.put("font.family", "SansSerif");
                case "font-serif" -> styleMap.put("font.family", "Serif");
                case "font-mono" -> styleMap.put("font.family", "Monospaced");
                case "font-dialog" -> styleMap.put("font.weight", "Dialog");
                case "font-dialog-input" -> styleMap.put("font.weight", "DialogInput");
                case "font-bold" -> styleMap.put("font.weight", Font.BOLD);
                case "font-normal" -> styleMap.put("font.weight", Font.PLAIN);
                case "font-italic" -> styleMap.put("font.weight", Font.ITALIC);
                case "text-xs" -> styleMap.put("text.size", 10);
                case "text-sm" -> styleMap.put("text.size", 12);
                case "text-base" -> styleMap.put("text.size", 16);
                case "text-md" -> styleMap.put("text.size", 18);
                case "text-lg" -> styleMap.put("text.size", 20);
                case "text-xl" -> styleMap.put("text.size", 24);
                case "text-2xl" -> styleMap.put("text.size", 32);
            }
        }
        return styleMap;
    }
}
