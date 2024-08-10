import api.Reqs;
import io.restassured.response.Response;
import org.testng.Assert;
import objectRepository.User;
import org.testng.annotations.Test;

import java.util.logging.Logger;


public class UserOperations {
    String url;
    User user = new User();
    Logger logger;

    @Test
    public void UserJounrey(){
        user.setName("Atul");
        user.setJob("SDET");
        Response resCreate = user.createUser(user);
        System.out.println(resCreate.asString());
        String id = resCreate.body().jsonPath().get("id");
        Assert.assertEquals(resCreate.getStatusCode(), 201);
        user.setName("Atul Sharma");
        user.setJob("SDET");
        Response resUpdate = user.updateUser(id, user);
        Assert.assertEquals(resUpdate.getStatusCode(), 200);
        System.out.println(resUpdate.asString());
        Response resDelete = user.deleteUser(id);
        Assert.assertEquals(resDelete.getStatusCode(), 204);
        System.out.println(resDelete);
    }
}
