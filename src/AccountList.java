import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
public interface AccountList {
    HashMap<String,String> loginCustomer = new HashMap<>();
    HashMap<String,String> loginSeller = new HashMap<>();

    ArrayList<String> customersUsernames = new ArrayList<>();
    ArrayList<String> customerPasswords = new ArrayList<>();
    ArrayList<String> sellerUsernames = new ArrayList<>();
    ArrayList<String> sellerPasswords = new ArrayList<>();
    ArrayList<LocalDate> datesCus = new ArrayList<>();
    ArrayList<LocalDate> datesSel = new ArrayList<>();
}
