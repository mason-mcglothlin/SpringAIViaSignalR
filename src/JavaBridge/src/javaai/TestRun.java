package javaai;

import java.util.concurrent.ExecutionException;
import microsoft.aspnet.signalr.client.*;
import microsoft.aspnet.signalr.client.hubs.*;
import microsoft.aspnet.signalr.client.transport.*;

public class TestRun
{
    public static void main(String[] args)
    {
        HubConnection connection = new HubConnection("http://localhost:8080");
        HubProxy MyHubProxy = connection.createHubProxy("MyHub");
        ClientTransport transport = new ServerSentEventsTransport(connection.getLogger());
        
        SignalRFuture<Void> awaitConnection = connection.start(transport);
        try {
            awaitConnection.get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("connected!");
        MyHubProxy.invoke("Update", 1);
    }
}
