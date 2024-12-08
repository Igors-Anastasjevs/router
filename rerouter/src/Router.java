import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class Router {
    private TreeMap<String, InetAddress> map;//routing table
    public Router(){
        map = new TreeMap<>();
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
        String approximatekey = map.floorKey(url);//O(f(n)), where f(n) < n. (???)
        return (approximatekey != null) && (url.startsWith(approximatekey))?
                map.get(approximatekey): null;
    }
}
