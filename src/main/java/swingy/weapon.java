package swingy;

import java.util.Random;

public class weapon {
    private static String[] weapon = {"Pig Sticker", "Clipper", "Envious Blade", "Stiletto", "Scramasax", "Devil's Spine",
            "King's Sword of Haste", "Ghoul King's Blade", "God Butcher", "Amberwing", "Monster Hunter", "Wildwoord",
            "Widow's Thorn", "Hera's Law", "Akanesh", "Hundredth Spear", "Disembowler", "Vel" ,
            "Warden's Bow", "Longshot", "Raven's Wing", "Etrayu", "Maruki", "Hankyu" };

    private weapon(){}

    public static String getWeapon()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(weapon.length);
        return (weapon[randomNumber]);
    }
}
