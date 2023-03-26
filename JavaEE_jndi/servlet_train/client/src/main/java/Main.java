import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NamingException {
        try{
            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, org.wildfly.naming.client.WildFlyInitialContextFactory.class.getName());
            properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            Context context = new InitialContext(properties);
            Scanner input=new Scanner(System.in);
            String str=input.next();
            Object obj = context.lookup(str);
            System.out.println(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
