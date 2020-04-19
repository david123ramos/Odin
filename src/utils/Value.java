package utils;

import java.awt.Color;

public class Value {
    
    private  int key;
    private  Color color;
    
    public Value(int key, Color color){
        this.key = key;
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
