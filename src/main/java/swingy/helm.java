package swingy;

import java.util.Random;

public class helm {
    private static String[] helm = {"Mystery Helm", "Harlequin Crest", "The Undead Crown", "Star Helm", "Hide Hood", "Pride's Fall" };

    private helm(){}

    public String getHelm()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(helm.length);
        return (helm[randomNumber]);
    }
}
