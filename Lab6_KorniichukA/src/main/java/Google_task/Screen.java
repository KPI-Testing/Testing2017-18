package Google_task;

public class Screen <Integer,PageSnapshot> {
    private Integer key;
    private PageSnapshot value;

    public Screen(Integer key, PageSnapshot value){
        this.key = key; this.value = value;
    }
    public Integer  getPage(){
        return this.key;
    }
    public PageSnapshot getScreen(){
        return this.value;
    }
}
