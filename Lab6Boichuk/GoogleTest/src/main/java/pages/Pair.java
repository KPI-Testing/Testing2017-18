package pages;

public class Pair<Integer,PageSnapshot> {
    private Integer key;
    private PageSnapshot value;

    public Pair(Integer key, PageSnapshot value){
        this.key = key; this.value = value;
    }
    public Integer  getPage(){
        return this.key;
    }
    public PageSnapshot getScreen(){
        return this.value;
    }
}
