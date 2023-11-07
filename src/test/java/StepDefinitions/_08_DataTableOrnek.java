package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _08_DataTableOrnek {
    @When("Write username {string}")
    public void writeUsername(String userName) {
        System.out.println("userName = " + userName);

    }

    @And("Write username and Password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String userName, String password) {
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
        
    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable userlar) {
        List<String> listUserlar=userlar.asList(String.class);
        
        for (String user: listUserlar){
            System.out.println("user = " + user);
        }
        
        
    }

    @And("Write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable kullanicivesifreler) {
        List<List <String> > listKullaniciveSifreler=kullanicivesifreler.asLists(String.class);

        for (int i = 0; i <listKullaniciveSifreler.size() ; i++) {
            System.out.println("listin itemleri = "+listKullaniciveSifreler.get(i).get(0)+ // username
                                              " "+listKullaniciveSifreler.get(i).get(1)); // password

        }
    }
}
