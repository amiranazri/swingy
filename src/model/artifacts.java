package swingy.model;

import java.util.Random;

public class artifacts {
    
    String[] armor = {"Mystery Cloak", "Star Helm", "Golemskin Breeches", "Rivera Dancers", "Grasps of Essence", "King's Sword of Haste"};
    
    String[] currentWeapon = {"War Blade", "Maw Axe", "Scythe", "Hunting Bow"};

    private artifacts(){}

    public String getArtifacts()
    {
        Random randomArtifact = new Random();
        int randomNumber = randomArtifact.nextInt(armor.length);
        return (artifacts[randomNumber]);
    }

    public String getCurrentWeapon()
    {
        Random randomWeapon = new Random();
        int randomNumber2 = randomWeapon.nextInt(currentWeapon.length);
        return (artifacts[randomNumber2]);
    }

}
