package workshop;

public enum Category {
    POP("Pop",0),SCIENCE("Science",1),SPORTS("Sports",2),ROCK("Rock",3);
    final String type;
    final int val;

    Category(String type,int val){
        this.type = type;
        this.val = val;
    }
}
