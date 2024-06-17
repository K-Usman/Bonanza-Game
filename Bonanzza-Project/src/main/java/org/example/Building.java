package org.example;

import java.util.*;

public class Building
{


    ArrayList<String> buildingDeck;
    Map<String, List<String>>  buildingdata;
    String type;
    String bean;
//    int price;
    String attribute;



    //    Building(String type,String bean, int price, String attribute) {
//        this.type = type;
//        this.bean = bean ;
//        this.price = price;
//        this.attribute = attribute;
//    }
    Building(){
        buildingDeck = new ArrayList<>();
        buildingdata = new HashMap<>();
        createBuildingDeck();

    }
    public void setType(String type) {
        this.type = type;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getType() {
        return type;
    }

    public String getBean() {
        return bean;
    }

//    public int getPrice() {
//        return price;
//    }

    public String getAttribute() {
        return attribute;
    }
    public ArrayList<String> getBuildingDeck() {
        return buildingDeck;
    }
    public  Map<String, List<String>> getBuildingdata() {
        return buildingdata;
    }
    private void addBuilding(String type, String bean, int price, String attributes) {
//        Map<String, String[]> buildingMetadata = new HashMap<>();
        List<String> list = Arrays.asList(type, String.valueOf(price), attributes);
        buildingdata.put(bean, list);
        buildingDeck.add(type);
//        buildingdata.put(bean,buildingMetadata);
    }

    private void createBuildingDeck() {
//        ArrayList<Building> buildings = new ArrayList<>();
        // Add building data
        System.out.println("create Building working?  ");
        addBuilding("1 Jail","Blue Beans", 1, "None");
        addBuilding("2 Jail","Blue Beans", 2, "Uses beanometer on the 2 Jail card");
        addBuilding("3 Jail","Blue Beans", 3, "Uses beanometer on the 3 Jail card");
        addBuilding("4 Jail","Blue Beans", 4, "The owner of the 4 Jail must watch for any harvest of blue beans by any player (including himself)");
        addBuilding("1 Blacksmith","Chili beans", 1, "None");
        addBuilding("2 Blacksmith","Chili beans", 2, "The 2 Blacksmith is like a “3rd bean field");
        addBuilding("3 Blacksmith","Chili beans", 3, "The 3 Blacksmith uses the beanometer on the 3 blacksmith card when harvesting chili beans instead of the beanometer on the chili bean cards");
        addBuilding("4 Blacksmith","Chili beans", 4, "The owner of the 4 Blacksmith may harvest a field with only one bean");
        addBuilding("1 General Store", "Stink beans", 1, "None");
        addBuilding("2 General Store", "Stink beans", 2, "The owner may store 1 Bean Card");
        addBuilding("3 General Store", "Stink beans", 3, "The owner may store 2 Bean Card");
        addBuilding("4 General Store", "Stink beans", 4, "The owner may store 3 Bean Card");
        addBuilding("1 Saloon", "Green beans", 1, "None");
        addBuilding("2 Saloon", "Green beans", 2, "The 2 Saloon is like a “3rd bean field”, but only green beans may be planted there");
        addBuilding("3 Saloon", "Green beans", 3, "The owner may may choose to plant one bean each of different types in one or more of his fields (BeanStewPlanting)");
        addBuilding("4 Saloon", "Green beans", 4, "The owner may may choose to plant one bean each of different types in one or more of his fields (BeanStewPlanting)");
        addBuilding("1 Farm", "Soy beans", 1, "None");
        addBuilding("2 Farm", "Soy beans", 2, "The attribute of the 2 Farm allows a player to plant soy beans in a field that already has other beans (numbered 14 or higher)");
        addBuilding("3 Farm", "Soy beans", 3, "The owner of the 3 Farm must always, like others, plant at least one bean card in phase");
        addBuilding("4 Farm", "Soy beans", 4, "The owner earns 5 gold coins from a harvest that would normally earn him exactly 4 gold coins");
        addBuilding("1 Bank", "Black-eyed beans", 1, "None");
        addBuilding("2 Bank", "Black-eyed beans", 2, " The attribute of the Bank must be taken at the exact time indicated on the card.");
        addBuilding("3 Bank", "Black-eyed beans", 3, " The attribute of the Bank must be taken at the exact time indicated on the card.");
        addBuilding("4 Bank", "Black-eyed beans", 4, " The attribute of the Bank must be taken at the exact time indicated on the card.");
        addBuilding("1 Indian tipi", "Red beans", 1, "None");
        addBuilding("2 Indian tipi", "Red beans", 2, "Earns an additional gold coin");
        addBuilding("3 Indian tipi", "Red beans", 3, "Earns an additional gold coin");
        addBuilding("4 Indian tipi", "Red beans", 4, "Earns an additional gold coin");
        addBuilding("1 Gold mine", "Garden beans", 1, "None");
        addBuilding("2 Gold mine", "Garden beans", 2, "Pays only 1 gold coin for a 3rd bean field");
        addBuilding("3 Gold mine", "Garden beans", 3, "Uses beanometer on the gold mine card");
        addBuilding("4 Gold mine", "Garden beans", 4, "Additional bean field");
        // Add other buildings as per rules
//        System.out.println(buildings);
//        return buildings;
    }
    public void shuffleBuilding() {
        Collections.shuffle(buildingDeck) ;
    }

}
