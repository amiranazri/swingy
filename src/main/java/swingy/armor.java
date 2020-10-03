package swingy;

import java.util.Random;

public class armor {
    private static String[] armor = {"Mystery Cloak", "Cloak of Deception", "Shroud", "Black Feather", "Talma", "Cardinal",
            "Mystery Pants", "Hide Breeches", "Pox Faulds", "Chainmail Leggings", "Cain's Robes", "Golemskin Breeches",
            "Mystery Boots", "Lut Socks", "Rivera Dancers", "The Crudest Boots", "Cain's Sandals", "Greaves",
            "Mystery Gloves", "Gloves of Worship", "Hide Gloves", "Chainmail Gloves", "Grasps of Essence", "Cain's Scribe" };

    private armor(){}

    public String getArmor()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(armor.length);
        return (armor[randomNumber]);
    }
}
