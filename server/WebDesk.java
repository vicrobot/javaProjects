import java.io.IOException;

public class WebDesk{
    public static void main(String[] args) throws IOException{
        WebDeskBackend webDeskBackend = new WebDeskBackend("127.0.0.1",8001);
        webDeskBackend.prakatitam();
    }
}

