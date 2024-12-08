import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;
class RouterTest {

    @Test
    void mapURLtoHost() {
        Router router = new Router();
        try{
            router.addMapping("/abc", new byte[]{127, 0, 0, 2});
            router.addMapping("/er33", "localhost");
            router.addMapping("/urt",
                    Inet4Address.getByAddress(new byte[] {127, 0, 0, 3}));
            router.addMapping("/abc/sss/fff", new byte[] {127, 0, 0, 4});
        }catch (UnknownHostException e){
            e.printStackTrace();
        }

        try {
            assertEquals(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), router.mapURLtoHost("/er33"));
            assertEquals(InetAddress.getByAddress(new byte[]{127, 0, 0, 2}), router.mapURLtoHost("/abc"));
            assertEquals(InetAddress.getByAddress(new byte[]{127, 0, 0, 4}), router.mapURLtoHost("/abc/sss/fff"));
            assertEquals(Inet4Address.getByAddress(new byte[]{127, 0, 0, 3}), router.mapURLtoHost("/urt"));
            assertEquals(null, router.mapURLtoHost("/aaa"));
            assertEquals(null, router.mapURLtoHost("/abd"));
            assertEquals(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), router.mapURLtoHost("/er333"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}