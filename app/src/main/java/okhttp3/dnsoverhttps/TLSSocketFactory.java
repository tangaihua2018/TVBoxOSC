//package okhttp3.dnsoverhttps;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//import javax.net.ssl.SSLSocket;
//import javax.net.ssl.SSLSocketFactory;
//
//public class TLSSocketFactory extends SSLSocketFactory {
//    private final SSLSocketFactory internalSSLSocketFactory;
//
//    public TLSSocketFactory(SSLSocketFactory delegate) {
//        internalSSLSocketFactory = delegate;
//    }
//
//    @Override
//    public String[] getDefaultCipherSuites() {
//        return internalSSLSocketFactory.getDefaultCipherSuites();
//    }
//
//    @Override
//    public String[] getSupportedCipherSuites() {
//        return internalSSLSocketFactory.getSupportedCipherSuites();
//    }
//
//    @Override
//    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
//        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(socket, host, port, autoClose));
//    }
//
//    @Override
//    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
//        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port));
//    }
//
//    @Override
//    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
//        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port, localHost, localPort));
//    }
//
//    @Override
//    public Socket createSocket(InetAddress host, int port) throws IOException {
//        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port));
//    }
//
//    @Override
//    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
//        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(address, port, localAddress, localPort));
//    }
//
//    private Socket enableTLSOnSocket(Socket socket) {
//        if (socket instanceof SSLSocket) {
//            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
//        }
//        return socket;
//    }
//}
//
