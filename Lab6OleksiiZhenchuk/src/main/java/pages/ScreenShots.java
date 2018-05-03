package pages;

public class ScreenShots<Integer,PageSnapshot> {
    private Integer key;
    private PageSnapshot value;

    public ScreenShots(Integer key, PageSnapshot value){
        this.key = key; this.value = value;
    }
    public Integer  getPage(){
        return this.key;
    }
    public PageSnapshot getScreen(){
        return this.value;
    }
}