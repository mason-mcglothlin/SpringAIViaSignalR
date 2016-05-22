package javaai;

import com.springrts.ai.oo.*;
import com.springrts.ai.oo.clb.*;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import microsoft.aspnet.signalr.client.*;
import microsoft.aspnet.signalr.client.hubs.*;
import microsoft.aspnet.signalr.client.transport.*;

public class JavaBridge extends AbstractOOAI {

    private OOAICallback Callback;
    private static final String LogLocation = "C:\\Users\\msm8b\\Documents\\JavaBridgeLog.txt";
    private HubConnection Connection;
    private HubProxy MyHubProxy;

    public static void InitializeLogFile()
    {
        try
        {
            Writer output = new BufferedWriter(new FileWriter(LogLocation));
            output.close();
        }
        catch(IOException ex){
            //cant do anything here
        }
    }

    public static void Log(String message) {
        try
        {
            Writer output = new BufferedWriter(new FileWriter(LogLocation, true));
            output.append(message + "\n");
            output.close();
        }
        catch(IOException ex){
            //cant do anything here
        }
    }

    private void InitializeSignalR()
    {
        Log("Initializing SignalR");
        Connection = new HubConnection("http://localhost:8080");
        MyHubProxy = Connection.createHubProxy("GameHub");
        ClientTransport transport = new ServerSentEventsTransport(Connection.getLogger());
        SignalRFuture<Void> awaitConnection = Connection.start(transport);
        // when do we close the connection?!
        try
        {
            awaitConnection.get();
        }
        catch (InterruptedException e)
        {
            Log(e.getMessage());
        }
        catch (ExecutionException e)
        {
            Log(e.getMessage());
        }
        Log("SignalR initialized");
    }

    @Override
    public int init(int teamId, OOAICallback callback) {
        InitializeLogFile();
        Log("Initializing");
        InitializeSignalR();
        Callback = callback;
        Log("Initialized");
        return 0;
    }

    @Override
    public int unitFinished(Unit unit) {
        return 0;
    }

    @Override
    public int commandFinished(Unit unit, int commandId, int commandTopicId) {
        return 0;
    }

    @Override
    public int enemyCreated(Unit enemy) {
        return 0;
    }

    @Override
    public int enemyDamaged(Unit enemy, Unit attacker, float damage, AIFloat3 directionOfAttack, WeaponDef weaponUsed, boolean paralyzer) {
        return 0;
    }

    @Override
    public int enemyDestroyed(Unit enemy, Unit attacker) {

        return 0;
    }

    @Override
    public int enemyEnterLOS(Unit enemy) {
        return 0;
    }

    @Override
    public int enemyEnterRadar(Unit enemy) {
        return 0;
    }

    @Override
    public int enemyFinished(Unit enemy) {
        return 0;
    }

    @Override
    public int enemyLeaveLOS(Unit enemy) {
        return 0;
    }

    @Override
    public int enemyLeaveRadar(Unit enemy) {
        return 0;
    }

    @Override
    public int save(String file) {
        return 0;
    }

    @Override
    public int seismicPing(AIFloat3 position, float strength) {
        return 0;
    }

    @Override
    public int playerCommand(List<Unit> units, int commandTopicId, int playerId) {
        return 0;
    }

    @Override
    public int weaponFired(Unit unit, WeaponDef weaponUsed) {
        return 0;
    }

    @Override
    public int unitCaptured(Unit unit, int oldTeamId, int newTeamId) {
        return 0;
    }

    @Override
    public int unitGiven(Unit unit, int oldTeamId, int newTeamId) {
        return 0;
    }

    @Override
    public int unitDestroyed(Unit unit, Unit attacker) {
        return 0;
    }

    @Override
    public int unitDamaged(Unit unit, Unit attacker, float damage, AIFloat3 directionOfDamage, WeaponDef weaponUsed, boolean paralyzer) {
        return 0;
    }

    @Override
    public int unitMoveFailed(Unit unit) {
        return 0;
    }

    @Override
    public int unitIdle(Unit unit) {
        return 0;
    }

    @Override
    public int unitCreated(Unit unit, Unit builder) {
        return 0;
    }

    @Override
    public int message(int player, String message) {
        return 0;
    }

    @Override
    public int update(int frame) {
        if(frame == 0 )
        {
            Callback.getGame().sendTextMessage("Hello, world!", 0);
        }
        MyHubProxy.invoke("Update", frame);
        return 0;
    }

    @Override
    public int release(int i) {
        Connection.stop();
        return 0;
    }

    @Override
    public int load(String file) {
        return 0;
    }

    @Override
    public int luaMessage(String inData) {
        return 0;
    }
}
