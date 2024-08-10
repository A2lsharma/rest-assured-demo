package objectRepository;

import api.Reqs;
import io.restassured.response.Response;

public class User {
    private String name;
    private String job;
    String url;
    Response resCreateUser;
    Reqs req =  new Reqs();

    public void setName(String name){
        this.name = name;
    }
    public void setJob(String job){
        this.job = job;
    }
    public void getName(String name){
        this.name = name;
    }
    public void getJob(String job){
        this.job = job;
    }

    public Response createUser(Object user){
        url = "/api/users";
        resCreateUser = req.POST(url, user);
        return resCreateUser;
    }
    public Response updateUser(String id, Object updateUser){
        url = "/api/users/"+id;
        Response resUpdate = req.PUT(url, updateUser);
        return resUpdate;
    }
    public Response deleteUser(String id){
        url = "/api/users/"+id;
        Response resDelete = req.DELETE(url);
        return resDelete;
    }
}
