package model;

public class Treasure {
    private String nameTreasure;
    private String urlImage;
    private double scoreToGive;
    private String locationTreasures;
    private int numberTreasures;
    private TreasureType typeTreasure;

    public Treasure(String nameTreasure, String urlImage, double scoreToGive, String locationTreasures, int numberTreasures, int typeTreasure){
        this.nameTreasure=nameTreasure;
        this.urlImage=urlImage;
        this.scoreToGive=scoreToGive;
        this.locationTreasures=locationTreasures;
        this.numberTreasures=numberTreasures;
        this.typeTreasure=TreasureType.values()[typeTreasure];
    }

    public String getNameTreasure(){
        return nameTreasure;

    }

    public void setNameTreasure(String nameTreasure){
        this.nameTreasure=nameTreasure;

    }

    public String getUrlImage(){
        return urlImage;

    }

    public void setUrlImage(String urlImage){
        this.urlImage=urlImage;

    }

    public double getScoreToGive(){
        return scoreToGive;

    }

    public void setScoreToGive(double scoreToGive){
        this.scoreToGive=scoreToGive;

    }

    public String getLocationTreasures(){
        return locationTreasures;

    }

    public void setLocationTreasures(String locationTreasures){
        this.locationTreasures=locationTreasures;

    }

    public int getNumberTreasures(){
        return numberTreasures;

    }

    public void setNumberTreasures(int numberTreasures){
        this.numberTreasures=numberTreasures;

    }


    public String toString(){
        return "Tresure\n"+
        "Name of the Treasure "+nameTreasure
        +"\nurl Image of the Tresure: "+urlImage
        +"\nLocation of the Treasure: "+locationTreasures;

    }


}
