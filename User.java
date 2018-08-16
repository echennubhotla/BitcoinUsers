public class User {

    int userId;
    int targetId;
    int rating;


    public User(int u, int t, int r){
        userId = u;
        targetId = t;
        rating = r;
    }

    public int getUserId(){
        return userId;
    }

    public int getTargetId(){
        return targetId;
    }

    public int getRating(){
        return rating;
    }

    public void setUserId(int u){
        userId = u;
    }

    public void setTargetId(int t){
        targetId = t;
    }

    public void setRating(int r){
        rating = r;
    }

}
