public class Runway
{
    private String name;
    private boolean isAvailable;

    Runway(String name, boolean isAvailable){
        this.name = name;
        this.isAvailable = isAvailable;
    } 

    public String getRunwaysName(){
        return name;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setRunwaysName(String name){
        this.name=name;
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }
}
