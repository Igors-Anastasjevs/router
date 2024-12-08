import java.net.InetAddress;
import java.net.UnknownHostException;

public class Routerusestriemap {
    private TrieMap<String, InetAddress> map;//routing table
    public Routerusestriemap(){
        map = new TrieMap<>();
    }
    public void addMapping(String route, byte[] bytes) throws UnknownHostException {
        map.put(route, InetAddress.getByAddress(bytes));
    }
    public void addMapping(String route, String host) throws UnknownHostException{
        map.put(route, InetAddress.getByName(host));
    }
    public void addMapping(String route, InetAddress inetAddress) throws UnknownHostException{
        map.put(route, inetAddress);
    }
    public InetAddress mapURLtoHost(String url){
        return map.getWithPrefix(url);
    }
}
