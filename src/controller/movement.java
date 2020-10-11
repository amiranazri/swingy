package swingy.controller;

public class movement {
    int level = model.hero.level;
    int mapX = ((level - 1)*5 + 10 - (level / 2));
    int mapY = ((level - 1)*5 + 10 - (level / 2));
    int heroX = mapX / 2;
    int heroY = mapY / 2;
    
    public int moveForward(){
        heroY = heroY + 1;
        return (heroY);
    }

    public int moveBackward(){
        heroY = heroY - 1;
        return (heroY);
    }

    public int moveLeft(){
        heroX = heroX - 1;
        return (heroX);
    }

    public int moveRight(){
        heroX = heroX + 1;
        return (heroX);
    }    
}
