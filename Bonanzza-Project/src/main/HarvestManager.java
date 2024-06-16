package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HarvestManager {

    public void promptHarvest(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to harvest any fields? ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the fields to harvest (1, 2 or 3?)");
            String fieldsInput = scanner.nextLine();
            String[] fieldIndices = fieldsInput.split(",");
            for (String fieldIndex : fieldIndices) {
                try {
                    int index = Integer.parseInt(fieldIndex.trim()) - 1;
                    harvestField(player, index);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Invalid field index: " + fieldIndex);
                }
            }
        }
    }

    private void harvestField(Player player, int fieldIndex) {
        if (fieldIndex < 0 || fieldIndex >= player.getFields().size()) {
            System.out.println("Invalid field index.");
            return;
        }

        List<String> field = player.getFields().get(fieldIndex);
        if (field.isEmpty()) {
            System.out.println("Field " + (fieldIndex + 1) + " is empty, nothing to harvest.");
            return;
        }

        player.addHarvestedBeans(new ArrayList<>(field));
        field.clear();
    }
}